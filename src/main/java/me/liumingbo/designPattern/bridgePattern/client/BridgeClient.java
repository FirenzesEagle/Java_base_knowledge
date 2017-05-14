package me.liumingbo.designPattern.bridgePattern.client;

import me.liumingbo.designPattern.bridgePattern.brand.AbstractCar;
import me.liumingbo.designPattern.bridgePattern.brand.BMWCar;
import me.liumingbo.designPattern.bridgePattern.brand.BenZCar;
import me.liumingbo.designPattern.bridgePattern.transmission.Auto;
import me.liumingbo.designPattern.bridgePattern.transmission.Manual;
import me.liumingbo.designPattern.bridgePattern.transmission.Transmission;

/**
 * Created by FirenzesEagle on 2017/5/14.
 * Email:liumingbo2008@gmail.com
 */
public class BridgeClient {
    public static void main(String[] args) {
        Transmission auto = new Auto();
        AbstractCar bmw = new BMWCar();
        bmw.setTransmission(auto);
        bmw.run();

        Transmission manual = new Manual();
        AbstractCar benz = new BenZCar();
        benz.setTransmission(manual);
        benz.run();
    }
}
