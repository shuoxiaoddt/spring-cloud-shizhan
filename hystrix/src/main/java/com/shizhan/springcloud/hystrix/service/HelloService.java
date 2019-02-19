package com.shizhan.springcloud.hystrix.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheKey;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheRemove;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by xiaos 2019/1/29
 * //TODO 写点注释吧
 */
@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "helloFallBack",
            groupKey = "helloGroup",
            commandKey = "helloService",
            threadPoolKey = "helloThreadPool",
            commandProperties={@HystrixProperty(name = "execution.isolation.strategy",value = "THREAD"),
                                @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "2000")})
    public String helloService(String name){
        String body = restTemplate.getForEntity("http://EXPOSE-SERVICE/hello/" + name, String.class).getBody();
        return body;
    }

    @HystrixCommand(fallbackMethod = "helloFallBack",groupKey = "helloGroup",commandKey = "helloService",threadPoolKey = "helloThreadPool")
    public String hellos(String name){
        String[] names = StringUtils.split(name, "-");
        List<String> body = restTemplate.getForEntity("http://EXPOSE-SERVICE/hellos/" + name, List.class,names).getBody();
        System.out.println(body);
        return body.stream().collect(Collectors.joining(","));
    }

    public String helloFallBack(String name){
        System.out.println("请求过载 服务降级!");
        return name+ "error";
    }

    @CacheRemove(commandKey = "helloService")
    @HystrixCommand(fallbackMethod = "helloFallBack",groupKey = "helloGroup",commandKey = "helloService",threadPoolKey = "helloThreadPool")
    public String updateCache(){
        System.out.println("clear hystrix cache!!");
        return "clear success!";
    }

}
