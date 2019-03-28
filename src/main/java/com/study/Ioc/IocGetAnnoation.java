package com.study.Ioc;

import com.alibaba.dubbo.common.utils.StringUtils;


import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description ioc注解手写
 * @date 2018/12/26
 */
public class IocGetAnnoation {

    private ConcurrentHashMap<String, Object> initBean = null;

    //扫包的范围
    private String packageName;

    public IocGetAnnoation(String packageName) {
        this.packageName = packageName;

    }

    public Object GetObject(String beanId) throws Exception {

        //1.获取包下所有包含该注解的类
        List<Class> classes = findClassInServive();

        //2.获取beanid和对象集合
        initBean = initBean(classes);

        //3.获取对象
        Object object = initBean.get(beanId);

        //4.给属性赋值
        attriAssign(object);

        return object;
    }

    private void attriAssign(Object object) throws IllegalAccessException {

        Class<?> classInfo = object.getClass();
        Field[] fields = classInfo.getDeclaredFields();
        for (Field field : fields) {
            //属性
            //属性应该也要加上注解
            ExtRouce extRouce = field.getAnnotation(ExtRouce.class);
            String name = field.getName();
            Object bean = initBean.get(name);
            if (bean != null) {
                field.setAccessible(true);

                field.set(object, bean);
            }

        }
    }

    private ConcurrentHashMap<String, Object> initBean(List<Class> classes) throws IllegalAccessException, InstantiationException {

        initBean = new ConcurrentHashMap<String, Object>();
        for (Class classInfo : classes) {
            Object obejct = classInfo.newInstance();
            initBean.put(toLowerCaseFirstOne(classInfo.getSimpleName()), obejct);
        }
        return initBean;
    }

    private String toLowerCaseFirstOne(String str) {

        if (Character.isLowerCase(str.charAt(0))) {
            return str;
        } else {
            return new StringBuilder().append(Character.toLowerCase(str.charAt(0))).append(str.substring(1)).toString();

        }

    }

    private List<Class> findClassInServive() throws Exception {

        if (StringUtils.isEmpty(packageName)) {
            throw new Exception("包名不能为空");
        }
        //获取包下所有的class
        List<Class<?>> classes = ClassUtil.getClasses(packageName);

        List<Class> exisClassesAnnotation = new ArrayList<Class>();
        for (Class classInfo : classes) {
            ExtService extService = (ExtService) classInfo.getAnnotation(ExtService.class);
            if (extService != null) {
                exisClassesAnnotation.add(classInfo);

            }
        }

        return exisClassesAnnotation;
    }
}
