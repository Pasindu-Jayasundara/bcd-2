package org.example.web.interceptor.ejb;

import jakarta.ejb.Schedule;
import jakarta.ejb.Stateless;
import jakarta.ejb.Timeout;
import org.example.web.interceptor.annotation.TimeoutLogger;

@Stateless
@TimeoutLogger
public class TimerSessionBean {

    @Schedule(hour="*",minute = "*", persistent = false)
    @Timeout
    public void doTask(){
        System.out.println("do task ...");
    }
}
