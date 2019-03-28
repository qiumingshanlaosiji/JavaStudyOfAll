package com.study.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Collections;
import java.util.TreeSet;

/**
 * @description 动态代理测试
 * @date 2019/2/13
 */
public class ProxyTest {

    public static void main(String[] args) throws Throwable {

        HelloImp hello = new HelloImp();
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler(hello);

        Hello proxyHello=(Hello)myInvocationHandler.getProxy(
                    myInvocationHandler);
            proxyHello.sayHello();



    }
}


 class HelloImp implements Hello {
    public void sayHello() {
        System.out.println("hello");
    }
}
 interface Hello {
    void sayHello();
}

 class MyInvocationHandler implements InvocationHandler {

    private Object target;

    public MyInvocationHandler(Object target) {
        super();
        this.target = target;
    }

    public Object getProxy(Object targetObject){
        //this.target=targetObject;

        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);

    }

    //真正执行方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("执行前");
        Object result = method.invoke(target, args);
        System.out.println(result);
        System.out.println("执行后");
        return result;
    }
}
