package com.customer.AOP;

import com.customer.Exception.CustomerNotFoundException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@Aspect
@Configuration
public class CustomerAspect {
    private final Logger log = LoggerFactory.getLogger(CustomerAspect.class);

    @Before(value = "execution(* com.customer.Controller.*.*(..))")
    public void logStatementBefore(JoinPoint joinPoint) {
        log.info("Executing controller {}", joinPoint);
    }

    @Before(value = "execution(* com.customer.Service.*.*(..))")
    public void logStatementBeforeService(JoinPoint joinPoint) {
        log.info("Executing service {}", joinPoint);
    }



    @After(value = "execution(* com.customer.Controller.*.*(..))")
    public void logStatementAfter(JoinPoint joinPoint) {
        log.info("Complete exception of controller {}", joinPoint);
    }


    @AfterReturning(value = "execution(* com.customer.Controller.*.*(..))",
            returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        log.info("{} returned with value {}", joinPoint, result);
    }


    @Around(value = "execution(* com.customer.Service.*.*(..))")
    public Object taskHandler(ProceedingJoinPoint joinPoint) throws Throwable {

        try {
            Object obj = joinPoint.proceed();
            return obj;
        } catch (CustomerNotFoundException e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

}
