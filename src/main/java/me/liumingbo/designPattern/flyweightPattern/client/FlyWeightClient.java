package me.liumingbo.designPattern.flyweightPattern.client;

import me.liumingbo.designPattern.flyweightPattern.factory.FlyWeightFactory;
import me.liumingbo.designPattern.flyweightPattern.flyweight.FlyWeight;

/**
 * Created by FirenzesEagle on 2017/5/14.
 * Email:liumingbo2008@gmail.com
 */
public class FlyWeightClient {
    public static void main(String[] args) {
        FlyWeight bmw1 = FlyWeightFactory.getFlyWeight("bmw");
        FlyWeight bmw2 = FlyWeightFactory.getFlyWeight("bmw");
        FlyWeight bmw3 = FlyWeightFactory.getFlyWeight("bmw");

        bmw1.action("start");
        bmw2.action("stop");
        bmw3.action("boost");

    }
}
