package com.study.ibatis;


import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description MyInvocationHandlerMbatis
 * @date 2018/12/27
 * <p>
 * 1.使用动态代理技术,获取接口方法上的sql语句<br>
 * 2.根据不同的SQL语句<br>
 * 创建代理
 */
public class MyInvocationHandlerMbatis implements InvocationHandler {

    private Object subject;

    public MyInvocationHandlerMbatis(Object object) {
        this.subject = object;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        ExtInsert extInsert = method.getAnnotation(ExtInsert.class);
        if (extInsert != null) {
            return insertSql(extInsert, method, args);
        }

        ExtSelect extSelect = method.getAnnotation(ExtSelect.class);
        if (extSelect != null) {

            sqlqctMybatis(extSelect, method, args);
        }
        return null;
    }

    public Object sqlqctMybatis(ExtSelect extSelect, Method method, Object[] args) {
        try {
            //获取方法上的sql语句
            String selectSql = extSelect.value();

            //获取方法上的参数
            Parameter[] parameters = method.getParameters();

            //获取方法上的参数和值
            ConcurrentHashMap<Object, Object> parameterMap = getExtParams(parameters, args);

            //获取sql上的条件参数
            List<String> sqlSelectParameter = SQLUtils.sqlSelectParameter(selectSql);

            //获取sql上的参数获取方法上的值
            List<Object> parameValues = new ArrayList<>();
            for (int i = 0; i < sqlSelectParameter.size(); i++) {

                String parameterName = sqlSelectParameter.get(i);
                Object object = parameterMap.get(parameterName);
                parameValues.add(object.toString());
            }

            //组装新的sql语句  将之前的 #string 替换成?
            String newSql = SQLUtils.parameQuestion(selectSql, sqlSelectParameter);

            //获取执行结果
            ResultSet rs = JDBCUtils.query(newSql, parameValues);

            ///获取返回类型
            Class<?> returnType = method.getReturnType();

            if (!rs.next()) {
                return null;
            }

            //向上移动
            rs.previous();
             //创建对象
            Object newInstance = returnType.newInstance();

            while (rs.next()) {
                for (String name : sqlSelectParameter) {
                    //
                    Object values = rs.getObject(name);
                    //查找属性
                    Field field = returnType.getDeclaredField(name);
                    field.setAccessible(true);
                    field.set(newInstance, values);
                }

            }
            return newInstance;

        } catch (Exception e) {


        }
        return null;
    }

    /*
    插入方法
     */
    public int insertSql(ExtInsert extInsert, Method method, Object[] args) {

        //获取sql语句
        String insertSql = extInsert.value();

        //获取参数
        Parameter[] parameters = method.getParameters();

        //获取参数上的注解和值
        ConcurrentHashMap<Object, Object> hashMap = getExtParams(parameters, args);

        //获取sql上需要传递的参数
        String[] sqlParameters = SQLUtils.sqlInsertParameter(insertSql);

        //将方法中的参数和sql中需要的值进行映射
        List<Object> parameValues = new ArrayList<>();
        for (int i = 0; i < sqlParameters.length; i++) {
            String str = sqlParameters[i];
            Object object = hashMap.get(str);
            parameValues.add(object);
        }
        //获得最终的sql语句
        String newSql = SQLUtils.parameQuestion(insertSql, sqlParameters);

        //执行sql语句
        return JDBCUtils.insert(newSql, false, parameValues);

    }
    /*
    获取参数 集合
     */

    private ConcurrentHashMap<Object, Object> getExtParams(Parameter[] parameters, Object[] args) {

        ConcurrentHashMap<Object, Object> concurrentHashMap = new ConcurrentHashMap<>();

        for (int i = 0; i < parameters.length; i++) {
            ExtParam extParam = parameters[i].getDeclaredAnnotation(ExtParam.class);

            //获取参数名称  和sql语句映射
            String paramValue = extParam.value();

            //获取参数的值
            Object obj = args[i];
            concurrentHashMap.put(paramValue, obj);
        }


        return concurrentHashMap;

    }
}
