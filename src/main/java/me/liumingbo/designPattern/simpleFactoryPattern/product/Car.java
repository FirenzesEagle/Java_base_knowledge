package me.liumingbo.designPattern.simpleFactoryPattern.product;

/**
 * Created by FirenzesEagle on 2017/3/30.
 * Email:liumingbo2008@gmail.com
 */
public abstract class Car {
    protected String name;

    public abstract void drive();

    public String getName(){
        return this.name;
    }
}
