package com.study.enumtest;

/**
 * @description 枚举测试
 * @date 2019/2/14
 */
public class   EnumTest {
   public void test(){
       PersonEnum.valueOf("GIRL");
       AnimalEnum A1=    AnimalEnum.A;
   }

   public  void  test1(PersonEnum personEnum){
       switch (personEnum){
           case BOY:
               break;
       }
   }
}

enum PersonEnum{
    GIRL,BOY
}

enum AnimalEnum{
    A("123");
private  AnimalEnum(String name){

}
}