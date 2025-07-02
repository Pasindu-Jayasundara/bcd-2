package org.example.web.interceptor.ejb;

import jakarta.ejb.Stateless;
import jakarta.interceptor.Interceptors;
import org.example.web.interceptor.interceptor.TestInterceptor;

@Stateless
@Interceptors(TestInterceptor.class)
public class UserSessionBean {

    public void doAction(){
        System.out.println("UserSessionBean -do Action ...");
    }

    public void doAction(String name, int age){
        System.out.println("UserSessionBean -do Action ..."+name+" : "+age);
    }
}
