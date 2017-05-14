package me.liumingbo.designPattern.adapterPattern.client;

import me.liumingbo.designPattern.adapterPattern.target.Adapter;
import me.liumingbo.designPattern.adapterPattern.target.ConcreteTarget;
import me.liumingbo.designPattern.adapterPattern.target.ITarget;

/**
 * 适配器模式测试类
 *
 * Created by FirenzesEagle on 2017/5/14.
 * Email:liumingbo2008@gmail.com
 */
public class AdapterClient {

    public static void main(String[] args) {
        ITarget adapter = new Adapter();
        adapter.request();
        ITarget target = new ConcreteTarget();
        target.request();
    }

}
