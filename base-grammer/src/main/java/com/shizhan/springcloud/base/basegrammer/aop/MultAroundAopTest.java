package com.shizhan.springcloud.base.basegrammer.aop;

import com.shizhan.springcloud.base.basegrammer.annotation.DingTalkMessage;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by xiaos 2019/2/25
 * 测试同一个方法是否支持同一种切面 => 支持
 */
@Component
@Aspect
@Order(2)
public class MultAroundAopTest {

    @Pointcut("execution(* com.shizhan.springcloud.base.basegrammer.controller.*.*(..))")
    private void multAop(){}

    @Around("multAop()")
    public Object sendDingTalkMessage(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("MultAroundAopTest:");
        return joinPoint.proceed();
    }
}
