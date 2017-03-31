package me.liumingbo.designPattern.observerPattern.subject;

import me.liumingbo.designPattern.observerPattern.observer.ITalent;

/**
 * Created by bjliumingbo on 2017/3/31.
 */
public class HeadHunter extends AbstractHR {
    @Override
    public void publishJob(String job) {
        for (ITalent talent : allTalents) {
            talent.newJob(job);
        }
    }
}
