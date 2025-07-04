package org.example.web.interceptor.ejb;

import jakarta.annotation.Priority;
import jakarta.interceptor.AroundTimeout;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;
import org.example.web.interceptor.annotation.TimeoutLogger;

@TimeoutLogger
@Interceptor
@Priority(1)
public class TimerInterceptor {

    @AroundTimeout
    public Object aroundTimeout(InvocationContext ic) throws Exception{
        return ic.proceed();
    }
}
