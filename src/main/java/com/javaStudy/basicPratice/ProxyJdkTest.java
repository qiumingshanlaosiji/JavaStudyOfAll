package com.javaStudy.basicPratice;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @description jdk动态代理
 * @date 2019/3/30
 */
public class ProxyJdkTest {



    public static void main(String[] args) {
        PersonImp personImp=new PersonImp();
        PersonProxy invocationHandler=new PersonProxy(personImp);
     Person person=   (Person)   Proxy.newProxyInstance(personImp.getClass().getClassLoader(),
             personImp.getClass().getInterfaces(),invocationHandler);
        person.set();
        person.get();
        personImp.set();
        personImp.get();
        person.get();
        PersonImp personImp1=new PersonImp();
        personImp1.get();

    }

}


  class  PersonProxy implements InvocationHandler{

    private  Object target;
    public  PersonProxy(Object target){
        super();
        this.target=target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
       return  method.invoke(target,args);
    }
}

  class  PersonImp implements  Person{

    private  Integer a=0;

      @Override
      public void set() {
          a++;
      }

      @Override
      public void get() {
          System.out.println(a);
      }
  }

interface  Person{


    void  get();

    void  set();
}