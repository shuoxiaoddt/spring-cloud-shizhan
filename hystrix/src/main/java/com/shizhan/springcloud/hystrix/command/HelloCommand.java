package com.shizhan.springcloud.hystrix.command;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import org.springframework.web.client.RestTemplate;

/**
 * Created by xiaos 2019/1/29
 * //TODO 写点注释吧
 */
public class HelloCommand extends HystrixCommand<String> {

    private RestTemplate restTemplate;

    public HelloCommand(Setter setter, RestTemplate restTemplate , Long id) {
        super(setter);
    }

    @Override
    protected String run() throws Exception {
        return null;
    }
}
