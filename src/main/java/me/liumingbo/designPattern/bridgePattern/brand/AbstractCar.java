package me.liumingbo.designPattern.bridgePattern.brand;

import me.liumingbo.designPattern.bridgePattern.transmission.Transmission;

/**
 * Created by FirenzesEagle on 2017/5/14.
 * Email:liumingbo2008@gmail.com
 */
public abstract class AbstractCar {

    protected Transmission gear;

    public abstract void run();

    public void setTransmission(Transmission gear) {
        this.gear = gear;
    }

}
