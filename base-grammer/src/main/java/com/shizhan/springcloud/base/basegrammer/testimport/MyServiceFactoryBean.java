package com.shizhan.springcloud.base.basegrammer.testimport;


import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


/**
 * Created by xiaos 2019/2/18
 * //TODO 写点注释吧
 */

public class MyServiceFactoryBean implements FactoryBean<MyService>  {

    private MyServiceProxy  serviceProxy = new MyServiceProxy(new MyServiceImpl());

    @Override
    public MyService getObject() throws Exception {
        return (MyService) serviceProxy.newInstance();
    }

    @Override
    public Class<?> getObjectType() {
        return MyService.class;
    }
}
