package com.shizhan.springcloud.base.basegrammer.annotation;

import java.lang.annotation.*;

/**
 * Created by xiaos 2019/2/25
 * 自动发送钉钉消息
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DingTalkMessage {

    /**
     * 钉钉群组ID
     * @return
     */
    String groupId();

    /**
     * 消息体 , 如果为空,则会使用
     * @return
     */
    String content() default "";

    /**
     *  是否使用返回值作为消息体,如果是true,content的内容会失效
     */
    boolean isUseReturnObj() default false;
}
