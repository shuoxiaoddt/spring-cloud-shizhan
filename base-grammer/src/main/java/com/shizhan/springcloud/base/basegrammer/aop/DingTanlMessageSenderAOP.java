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
 * //TODO 写点注释吧
 */
@Component
@Aspect
@Order(1)
public class DingTanlMessageSenderAOP {

    @Pointcut("@annotation(com.shizhan.springcloud.base.basegrammer.annotation.DingTalkMessage)")
    private void dingtalkPintcut(){}

    @Around("dingtalkPintcut() && @annotation(dingTalkMessage)")
    public Object sendDingTalkMessage(ProceedingJoinPoint joinPoint, DingTalkMessage dingTalkMessage) throws Throwable {
        String s = dingTalkMessage.groupId();
        boolean useReturnObj = dingTalkMessage.isUseReturnObj();


        System.out.println("groupid:"+s);
        return joinPoint.proceed();
    }
}
