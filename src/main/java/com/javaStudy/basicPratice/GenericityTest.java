package com.javaStudy.basicPratice;

import java.util.ArrayList;

/**
 * @description 泛型
 * @date 2019/3/30
 */
public class GenericityTest {

    public static void main(String[] args) {
        ArrayList<Integer> arrayList=new ArrayList<>();
        getSth(arrayList);

        Genericity genericity=new Genericity();

        GenericityTestInImp imp1=new GenericityTestInImp();
        GenericityTestInImp imp12=new GenericityTestInImp();

        genericity.getNum(new ArrayList<GenericityTestIn>());

        genericity.getNum1(new ArrayList<GenericityTestIn>());

    }
    private  static  void  getSth(ArrayList<? extends  Integer> arrayList){

    }

    private  static <T> T getSthDon(T t){
return t;
    }
}


class Genericity {

   //通配符上限
public   Integer getNum(ArrayList<? extends   GenericityTestIn> arrayList){

    return  0;
}

//下限
public  Integer getNum1(ArrayList<? super GenericityTestInImp > arrayList){
    return 0;
}
}
class   GenericityTestIn{

}

class  GenericityTestInImp extends   GenericityTestIn{

}


interface GenericityInter<T> {
    T get();

    ArrayList<T> getArraylist();
}

class GenericityInterImp<T> implements GenericityInter<T> {
    @Override
    public T get() {
        return null;
    }

    @Override
    public ArrayList<T> getArraylist() {
        return null;
    }
}

//类型通配符
