package me.liumingbo.designPattern.strategyPattern.strategy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 具体策略类，实现策略接口，提供具体算法
 * <p>
 * Created by FirenzesEagle on 2017/5/14.
 * Email:liumingbo2008@gmail.com
 */
@me.liumingbo.designPattern.strategyPattern.annotation.Strategy(name = "StrategyB")
public class ConcreteStrategyB implements Strategy {

    private static Logger logger = LoggerFactory.getLogger(ConcreteStrategyB.class);

    @Override
    public void strategy(String input) {
        logger.info("Strategy B for input : {}", input);
    }
}
