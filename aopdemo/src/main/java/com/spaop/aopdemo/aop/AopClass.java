package com.spaop.aopdemo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AopClass {

    @Before("execution(* com.spaop.aopdemo.impl.MyImpl.getData())")
    public void checkAop(){
        System.out.println("Before advice executed");
    }

    @After("execution(* com.spaop.aopdemo.impl.MyImpl.getData())")
    public void check(){
        System.out.println("After advice executed");
    }

    @Around("execution (* com.spaop.aopdemo.impl.MyImpl.getData())")
    public Object checkAround(ProceedingJoinPoint jp) throws Throwable{
        System.out.println("Before....");
        Object result = jp.proceed();
        System.out.println("After....");
        return result;
    }

    @AfterReturning(pointcut = "execution(* com.spaop.aopdemo.impl.MyImpl.getData())",returning = "retValue")
    public void checkAfterReturn(Object retValue){
        String str = (String) retValue;
        System.out.println("Returned value : "+str);
    }

    @AfterThrowing(pointcut = "execution(* com.spaop.aopdemo.impl.MyImpl.getData())", throwing = "error")
    public void afterThrowing(JoinPoint jp, Throwable error){
        System.out.println("Method signature : "+jp.getSignature());
        System.out.println("Exception : "+error);
    }

}

