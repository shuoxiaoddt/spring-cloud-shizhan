package com.shizhan.springcloud.base.basegrammer.testimport;


/**
 * Created by xiaos 2019/2/18
 * //TODO 写点注释吧
 */
public class MyServiceImpl implements MyService{

    @Override
    public String sayHelloService(String name){
        return "hello->"+name;
    }

}
