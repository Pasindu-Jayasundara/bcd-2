package org.example.web.eetimer.ejb;

import jakarta.annotation.Resource;
import jakarta.ejb.Stateless;
import jakarta.enterprise.concurrent.ManagedExecutorService;
import org.example.web.eetimer.ejb.remote.TaskSession;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;

@Stateless
public class TaskSessionBean implements TaskSession {

    @Resource
    ManagedExecutorService mes;

    @Override
    public Future<String> doTask() {
        System.out.println("doTask ....");

//        mes.submit(new Runnable() {
//            @Override
//            public void run() {
//
//                System.out.println(Thread.currentThread().getName()+" : Sending messahe");
//
//                try {
//                    Thread.sleep(3000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//
//                System.out.println(Thread.currentThread().getName()+" : Message sent");
//            }
//        });

        return mes.submit(new Callable<String>(){

            @Override
            public String call() throws Exception {

                System.out.println(Thread.currentThread().getName()+" : Sending messahe");

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName()+" : Message sent");

                return "Task Done";
            }
        });
    }
}
