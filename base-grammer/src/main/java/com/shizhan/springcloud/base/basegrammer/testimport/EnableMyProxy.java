package com.shizhan.springcloud.base.basegrammer.testimport;


import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * Created by xiaos 2019/2/18
 * //TODO 写点注释吧
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Import(MyServiceRegister.class)
public @interface EnableMyProxy {

}
