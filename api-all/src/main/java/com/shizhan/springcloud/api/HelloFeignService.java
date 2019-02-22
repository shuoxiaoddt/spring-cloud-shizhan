package com.shizhan.springcloud.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by xiaos 2019/2/22
 * //TODO 写点注释吧
 */
@RequestMapping("/hello/feign")
public interface HelloFeignService {

    @RequestMapping("/someone")
    String helloFeign(@RequestParam("name") String name);


}
