package me.liumingbo.designPattern.strategyPattern.context;

import me.liumingbo.designPattern.strategyPattern.strategy.Strategy;

/**
 * Context类，持有具体策略类的实例，负责调用具体算法
 * <p>
 * Created by FirenzesEagle on 2017/5/14.
 * Email:liumingbo2008@gmail.com
 */
public class SimpleContext {

    private Strategy strategy;

    public SimpleContext(Strategy strategy) {
        this.strategy = strategy;
    }

    public void action(String input) {
        strategy.strategy(input);
    }

}
