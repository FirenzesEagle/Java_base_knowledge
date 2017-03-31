package me.liumingbo.designPattern.observerPattern.client;

import me.liumingbo.designPattern.observerPattern.observer.Architect;
import me.liumingbo.designPattern.observerPattern.observer.ITalent;
import me.liumingbo.designPattern.observerPattern.observer.JuniorEngineer;
import me.liumingbo.designPattern.observerPattern.observer.SeniorEngineer;
import me.liumingbo.designPattern.observerPattern.subject.AbstractHR;
import me.liumingbo.designPattern.observerPattern.subject.HeadHunter;

/**
 * Created by bjliumingbo on 2017/3/31.
 */
public class Client {
    public static void main(String[] args) {
        ITalent juniorEngineer = new JuniorEngineer();
        ITalent seniorEngineer = new SeniorEngineer();
        ITalent architect = new Architect();

        AbstractHR hr = new HeadHunter();
        hr.addTalent(juniorEngineer);
        hr.addTalent(seniorEngineer);
        hr.addTalent(architect);

        hr.publishJob("Top 500 designPattern position");
    }
}
