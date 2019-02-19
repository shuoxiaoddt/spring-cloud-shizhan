package com.shizhan.springcloud.eurekaclient.serviceImpl;

import com.shizhan.springcloud.api.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by xiaos 2019/1/28
 * //TODO 写点注释吧
 */
@RestController
public class HelloServiceImpl implements HelloService {

    @Autowired
    private DiscoveryClient client;

    private volatile int requestTimes = 0;

    @Override
    @RequestMapping("/hello/{name}")
    public String sayHello(@PathVariable  String name) {

        int sleepTime = new Random().nextInt(1000);

        requestTimes++;

        System.out.println("sleep:"+sleepTime);

        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("request times:" + requestTimes);
        return "hello:"+name;
    }

    @Override
    @RequestMapping("/hellos/")
    public List<String> sayHellos(List<String> names) {
        List<String> result = new ArrayList<>();

        if(CollectionUtils.isEmpty(names)){
            return result;
        }

        names.forEach(x -> {
            result.add("hello:"+names);
        });
        return result;
    }


    @RequestMapping("/zero")
    public String setZero(){
        requestTimes = 0;
        return "success!";
    }


}
