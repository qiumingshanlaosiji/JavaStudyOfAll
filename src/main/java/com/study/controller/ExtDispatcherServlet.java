package com.study.controller;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.dubbo.remoting.http.servlet.DispatcherServlet;
import com.study.Ioc.ClassUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description ExtDispatcherServlet
 * @date 2018/12/26
 * *
 * * @QQ644064779 1.自定义DispatcherServlet<br>
 * *              2.servlet init()方法初始化###只会执行一次<br>
 * *              ######2.1获取当前包下所有的类<br>
 * *              ######2.2初始化当前包下所有的类,使用Java反射机制初始化对象存放在SpringMVC容器中key(beanId)-
 * *              value( 当前实例对象) <br>
 * *              ######2.3初始化HandlerMapping方法,将url和方法对应上 <br>
 * *              ########2.3.1使用Java反射技术读取类的信息,存放在map集合中key为url请求地址,value为对应方法
 * *              <br>
 * *              ########2.3.2使用Java反射技术读取类的信息,存放在map集合中key为url请求地址,value为对应实例对象
 * *              <br>
 * *              3.servlet get或者post请求<br>
 * *              ######## 3.1.1获取请求地址,使用Java反射技术找到对应的方法和实例对象进行执行 <br>
 * *
 */

public class ExtDispatcherServlet extends DispatcherServlet {

    //key bean  value 对象
    private ConcurrentHashMap<String, Object> mvcBeans = new ConcurrentHashMap<String, Object>();

    //key url value 对象
    private ConcurrentHashMap<String, Object> mvcBeanUrl = new ConcurrentHashMap<String, Object>();

    private ConcurrentHashMap<String, String> mvcMethodUrl = new ConcurrentHashMap<String, String>();

    /*
    初始化方法

     */
    @Override
    public void init() {

        try {
            //1.获取包下所有的类
            List<Class<?>> classes = ClassUtil.getClasses("com.study.controller");

            //2.初始化包下所有的类
            findClassMVCBeans(classes);

            //3.初始化HandlerMapping方法,将url和方法对应上
            handlerMapping(mvcBeans);
        } catch (Exception e) {


        }
    }

    private void handlerMapping(ConcurrentHashMap<String, Object> mvcBeans) {

        for (Map.Entry<String, Object> map : mvcBeans.entrySet()) {

            Object mvcObject = map.getValue();

            Class<? extends Object> classInfo = mvcObject.getClass();
            String requestBaseUrl = null;
            ExtRequestMapping extRequestMapping = (ExtRequestMapping) classInfo.getAnnotation(ExtRequestMapping.class);
            if (extRequestMapping != null) {
                requestBaseUrl = extRequestMapping.value();

            }
            Method[] declaredMethods = classInfo.getDeclaredMethods();
            for (Method method : declaredMethods) {
                ExtRequestMapping extMethodMapping = (ExtRequestMapping) method.getAnnotation(ExtRequestMapping.class);
                if (extMethodMapping != null) {
                    String httpRequestUrl = extMethodMapping.value();
                    mvcBeanUrl.put(requestBaseUrl + httpRequestUrl, mvcObject);
                    mvcMethodUrl.put(requestBaseUrl + httpRequestUrl, method.getName());
                }

            }


        }
    }

    /*
    初始化包下的所有类
     */
    private void findClassMVCBeans(List<Class<?>> classes) {
        try {
            for (Class classinfo : classes) {

                ExtController extController = (ExtController) classinfo.getAnnotation(ExtController.class);
                if (extController != null) {

                    String beanId = ClassUtil.toLowerCaseFirstOne(classinfo.getSimpleName());
                    mvcBeans.put(beanId, classinfo.newInstance());
                }
            }
        } catch (Exception e) {

        }

    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.service(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doDispatch(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doDispatch(req, resp);
    }

    private void doDispatch(HttpServletRequest request, HttpServletResponse response) throws IOException {

        //1.获取请求url地址
        String requestUrl = request.getRequestURI();

        //2.使用请求url查找对应的mvc bean
        Object object = mvcBeanUrl.get(requestUrl);
        if (object == null) {

            response.getWriter().println(404);
            return;
        }

        //3.获取对应的请求方法
        String method = mvcMethodUrl.get(requestUrl);
        if (StringUtils.isEmpty(method)) {

            response.getWriter().println(404);
            return;
        }

        //4.获取执行结果
        Class<? extends Object> classInfo = object.getClass();
        String resultPage = (String) methodInvoke(classInfo, object, method);

        //5.页面跳转
        viewdisplay(resultPage, request, response);
    }


    private void viewdisplay(String pageName, HttpServletRequest req, HttpServletResponse res) {
        try {
            String suffix = ".jsp";
            String prefix = "/";
            req.getRequestDispatcher(prefix + pageName + suffix).forward(req, res);
        } catch (Exception e) {

        }

    }

    private Object methodInvoke(Class<? extends Object> classInfo, Object object, String methodName) {
        try {
            Method method = classInfo.getMethod(methodName);
            Object result = method.invoke(object);
            return result;
        } catch (Exception e) {
            return null;

        }

    }
}
