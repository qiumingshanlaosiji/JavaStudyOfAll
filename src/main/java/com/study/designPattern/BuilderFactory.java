package com.study.designPattern;

/**
 * @description 建造者模式
 * @date 2019/3/2
 */
public class BuilderFactory {
    public static void main(String[] args) {
        //服务员
        KFCWaiter waiter = new KFCWaiter();
        //套餐A
        MealA a = new MealA();
        //服务员准备套餐A
        waiter.setMealBuilder(a);
        //获得套餐
        Meal mealA = waiter.construct();
        System.out.print("套餐A的组成部分:");
        System.out.println(mealA.getFood()+"---"+mealA.getDrink());
    }

}

/*
套餐类
 */
class Meal {
    private String food;
    private String drink;

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getDrink() {
        return drink;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }
}


/*
套餐构造器
 */
 abstract class MealBuilder {
    Meal meal = new Meal();

    public abstract void buildFood();

    public abstract void buildDrink();

    public Meal getMeal(){
        return meal;
    }
}

/*
   然后是套餐A、套餐B。这个两个套餐都是实现抽象套餐类。
 */

 class MealA extends MealBuilder{

    public void buildDrink() {
        meal.setDrink("一杯可乐");
    }

    public void buildFood() {
        meal.setFood("一盒薯条");
    }

}

/*

 */
 class MealB extends MealBuilder{

    public void buildDrink() {
        meal.setDrink("一杯柠檬果汁");
    }

    public void buildFood() {
        meal.setFood("三个鸡翅");
    }

}

/*
 最后是KFC的服务员，它相当于一个指挥者，它决定了套餐是的实现过程，然后给你一个完美的套餐。
 */
 class KFCWaiter {
    private MealBuilder mealBuilder;

    public void setMealBuilder(MealBuilder mealBuilder) {
        this.mealBuilder = mealBuilder;
    }

    public Meal construct(){
        //准备食物
        mealBuilder.buildFood();
        //准备饮料
        mealBuilder.buildDrink();

        //准备完毕，返回一个完整的套餐给客户
        return mealBuilder.getMeal();
    }
}