package com.shizhan.springcloud.feign.controller;

import com.shizhan.springcloud.feign.remoteapi.HelloFeignServiceRemote;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by xiaos 2019/2/22
 * //TODO 写点注释吧
 */
@RestController
public class HelloController {

    @Resource
    private HelloFeignServiceRemote serviceRemote;

    @RequestMapping("/helloFeign/{name}")
    public String feignHello(@PathVariable("name") String name){
        return serviceRemote.helloFeign(name);
    }
}
