package com.study.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Collections;
import java.util.TreeSet;

/**
 * @description 动态代理测试
 * 1、为接口创建代理类的字节码文件
 *
 * 2、使用ClassLoader将字节码文件加载到JVM
 *
 * 3、创建代理类实例对象，执行对象的目标方法
 *
 *
 *
 * 1、代理类继承了Proxy类并且实现了要代理的接口，由于java不支持多继承，所以JDK动态代理不能代理类
 *
 * 2、重写了equals、hashCode、toString
 *
 * 3、有一个静态代码块，通过反射或者代理类的所有方法
 *
 * 4、通过invoke执行代理类中的目标方法doSomething
 *
 *
 * 1、根据传递进来的ClassLoader，以及我们的代理对象的父接口数组，来动态创建二进制的class文件，然后根据创建好的Class二进制文件，获取到创建的动态代理类的Class对象。
 *
 * 2、通过代理类的class对象，获取class对象中参数为InvocationHandler的构造方法
 *
 * 3、判断构造方法的访问修饰符，如果不是public的，将其设置成可以访问的
 *
 * 4、调用构造器的newInstance方法，参数为InvocationHandler，返回代理类的实例
 * ---------------------

 * @date 2019/2/13
 */
public class ProxyTest {

    public static void main(String[] args) throws Throwable {

        HelloImp hello = new HelloImp();
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler(hello);

        Hello proxyHello=(Hello)myInvocationHandler.getProxy(
                    myInvocationHandler);
            proxyHello.sayHello();
        System.out.println(hello.a);


    }
}


 class HelloImp implements Hello {
    public  int a=0;
    public void sayHello() {
        a++;
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
        System.out.println(proxy.getClass().getName());
        Object result = method.invoke(target, args);
        System.out.println(result);
        System.out.println("执行后");
        return result;

    }
}
