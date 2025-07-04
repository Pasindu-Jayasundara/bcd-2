package org.example.web.interceptor.interceptor;

import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;
import org.example.web.interceptor.annotation.Loggin;

@Interceptor
@Loggin
public class LogginInterceptor {

    @AroundInvoke
    public Object intercept(InvocationContext ic) throws Exception{
        return ic.proceed();
    }
}
