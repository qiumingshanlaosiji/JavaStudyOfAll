package com.study.innerClass;

/**
 * @description 成员内部类
 * @date 2019/2/14
 */
public class InnerClassTest {

    public void test1() {
        test();
    }

    public void test() {

        System.out.println("a");
    }

    public class InnerClass {

        public void test2() {
            test();
        }
    }

}

class InnerClassPartTest {
private int a;
public final int b=2;
    public void test() {

        int c=1;
        final  int d=2;
        class A {
         public void test1(){
             System.out.println(a);
         }
        }
    }

}


 class InnerClassStaticTest {

    public  void  test(){
       A a=new A();
       a.test1();
    }
    static class A{
        public  void  test1(){

        }
    }

}

