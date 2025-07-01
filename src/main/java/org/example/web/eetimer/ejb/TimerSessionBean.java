package org.example.web.eetimer.ejb;

import jakarta.annotation.Resource;
import jakarta.ejb.Stateless;
import jakarta.ejb.Timeout;
import jakarta.ejb.TimerConfig;
import jakarta.ejb.TimerService;

@Stateless
public class TimerSessionBean {

    @Resource
    private TimerService timerService;

    public void doTask(){

        timerService.createIntervalTimer(1000,5000,new TimerConfig());
    }

    @Timeout
    public void timeOutTask(){
        System.out.println("time out task....");
    }
}
