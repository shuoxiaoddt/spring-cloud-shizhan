package com.shizhan.springcloud.base.basegrammer.controller;

import com.shizhan.springcloud.base.basegrammer.annotation.DingTalkMessage;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xiaos 2019/2/25
 * //TODO 写点注释吧
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping("/{name}")
    @DingTalkMessage(groupId = "xcs")
    public String sayHello(@PathVariable String name){
        return "hello:"+name;
    }
    @RequestMapping("/h2/{name}")
    public String sayHello2(@PathVariable String name){
        return "hello:"+name;
    }
}
