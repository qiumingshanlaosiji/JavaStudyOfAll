package com.studyForRule.normalStudy.normal;

import java.util.Random;

/**
 * 操作符学习
 */
public class OperatorStudy {

    public static void main(String[] args) {
        operatorStudyForBit();
    }

    /**
     * Random学习
     */
    public static void operatorStudyForRandom() {
        Random random = new Random();
        //定义一个上限  生成0-13之间的数字  不包含13
        System.out.println(random.nextInt(13));

        //产生小于0-1的double类型的数字 不包含1
        System.out.println(random.nextDouble());
        //产生小于0-5的double类型的数字 不包含5
        System.out.println(random.nextDouble()*5);

        //初始化种子数  种子数只是随机算法的起源数字，和生成的随机数字的区间无关。
        Random random1 = new Random(12);

    }


    /**
     * 递增递减
     */
    public  static  void  operatorStudyForIncrease(){

        int i=0;

        //0 先生成值再计算
        System.out.println(i++);

        //1
        System.out.println(i);

        //2 先计算,再生成值
        System.out.println(++i);

        //2
        System.out.println(i);
    }

    /**
     * 位操作
     */
    public  static  void   operatorStudyForBit(){
        int a=1;
        int b=2;
        //或操作符
        System.out.println(1|2);

        //与操作符
        System.out.println(1&2);

        //异操作符
        System.out.println(1^2);

        //非操作符
        System.out.println(~1);

        //左移两位   8*2*2
        System.out.println(8<<2);


        //右移两位   8/2*2
        System.out.println(8>>2);

        //给a赋值
        System.out.println(a<<=2);

        System.out.println(a);

        //b的值没有变化
        System.out.println(b<<2);

        System.out.println(b);

}
}
