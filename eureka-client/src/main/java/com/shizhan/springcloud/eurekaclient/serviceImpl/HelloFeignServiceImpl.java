package com.shizhan.springcloud.eurekaclient.serviceImpl;

import com.shizhan.springcloud.api.HelloFeignService;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xiaos 2019/2/22
 * //TODO 写点注释吧
 */
@RestController
public class HelloFeignServiceImpl implements HelloFeignService {
    @Override
    public String helloFeign(String name) {
        return "fegin-say-hello:"+name;
    }
}
