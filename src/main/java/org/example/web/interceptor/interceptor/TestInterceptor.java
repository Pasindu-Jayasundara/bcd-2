package org.example.web.interceptor.interceptor;

import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.InvocationContext;

public class TestInterceptor {

    @AroundInvoke
    public Object intercept(InvocationContext ic) throws Exception{
        System.out.println("Interceptor - intercept ...");

        return ic.proceed();
    }
}
