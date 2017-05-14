package me.liumingbo.designPattern.strategyPattern.client;

import me.liumingbo.designPattern.strategyPattern.context.SimpleContext;
import me.liumingbo.designPattern.strategyPattern.context.SimpleFactoryContext;
import me.liumingbo.designPattern.strategyPattern.strategy.ConcreteStrategyA;
import me.liumingbo.designPattern.strategyPattern.strategy.Strategy;

/**
 * 客户端可以实例化具体策略类，并传给Context类，通过Context统一调用具体算法
 * <p>
 * Created by FirenzesEagle on 2017/5/14.
 * Email:liumingbo2008@gmail.com
 */
public class SimpleClient {
    public static void main(String[] args) {
        Strategy strategy = new ConcreteStrategyA();
        SimpleContext context = new SimpleContext(strategy);
        context.action("Hellow, world");

        SimpleFactoryContext context1 = new SimpleFactoryContext();
        context1.action("Hellow, world");
    }
}
