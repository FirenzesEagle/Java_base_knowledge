package me.liumingbo.designPattern.observerPattern.subject;

import me.liumingbo.designPattern.observerPattern.observer.ITalent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by bjliumingbo on 2017/3/31.
 */
public abstract class AbstractHR {
    protected Collection<ITalent> allTalents = new ArrayList<ITalent>();

    public abstract void publishJob(String job);

    public void addTalent(ITalent iTalent){
        allTalents.add(iTalent);
    }

    public void removeTalent(ITalent iTalent){
        allTalents.remove(iTalent);
    }
}
