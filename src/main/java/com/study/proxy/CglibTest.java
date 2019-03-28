package com.study.proxy;

import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @description CGLIB动态代理
 * @date 2019/3/17
 */
public class CglibTest {

    public static void main(String[] args) {
//代理类class文件存入本地磁盘
        //System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\code");
        //
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(PersonService.class);
        enhancer.setCallback(new CglibProxyIntercepter());
        PersonService proxy= (PersonService)  enhancer.create();
        proxy.setPerson();
        proxy.getPerson("1");
    }
}


 class PersonService {
    public PersonService() {
        System.out.println("PersonService构造");
    }
    //该方法不能被子类覆盖
    final public Person getPerson(String code) {
        System.out.println("PersonService:getPerson>>"+code);
        return null;
    }

    public void setPerson() {
        System.out.println("PersonService:setPerson");
    }
}


class Person{

}
 class CglibProxyIntercepter implements MethodInterceptor {
    @Override
    public Object intercept(Object sub, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("执行前...");
        Object object = methodProxy.invokeSuper(sub, objects);
        System.out.println("执行后...");
        return object;
    }
}