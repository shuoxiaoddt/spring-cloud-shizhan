package com.shizhan.springcloud.hystrix.controller;

import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import com.shizhan.springcloud.hystrix.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xiaos 2019/1/29
 * //TODO 写点注释吧
 */
@RestController
public class ConsumerController {


    @Autowired
    HelloService service;

    @RequestMapping(value = "/ribbon-consumer/{name}",method = RequestMethod.GET)
    public String helloConsumer(@PathVariable String name){
        return service.helloService(name);
    }
    @RequestMapping(value = "/hellos",method = RequestMethod.GET)
    public String hellos(@PathVariable String name){
        return service.hellos(name);
    }

    @RequestMapping(value = "/updateCache",method = RequestMethod.GET)
    public String updateCache(){
        return service.updateCache();
    }
}
