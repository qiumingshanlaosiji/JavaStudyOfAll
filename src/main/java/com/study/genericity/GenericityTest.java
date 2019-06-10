package com.study.genericity;

import com.sun.scenario.effect.impl.prism.PrImage;

import java.util.ArrayList;

/**
 * @description 泛型测试
 * @date 2019/2/14
 */
public class GenericityTest {


}



class  GenericityClass<T>{

    private  void  test(T a){

    }

    private  T Test2(T a){

        return  a;
    }



}

class  GenericityClass1{

    private <T> void  test(T a){


    }


    private  <T> T test1(T a){
        return  null;
    }

    private  void  test2(ArrayList<? extends  Object> a){

    }

    private  void  test21(ArrayList<? super   Object> a){

    }
}