package org.example.ee.ejb;

import jakarta.annotation.security.DenyAll;
import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ejb.Stateless;

@Stateless
public class UserSessionBean {

    @DenyAll
    public void method1(){
        System.out.println("User session bean method 1");
    }

    @PermitAll
    public void method2(){
        System.out.println("User session bean method 2");
    }

    @RolesAllowed("admin")
    public void method3(){
        System.out.println("User session bean method 3");
    }

    @RolesAllowed({"admin","user"})
    public void method4(){
        System.out.println("User session bean method 4");
    }
    public void method5(){
        System.out.println("User session bean method 5");
    }
}
