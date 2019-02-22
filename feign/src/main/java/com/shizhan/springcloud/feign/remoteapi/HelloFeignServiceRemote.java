package com.shizhan.springcloud.feign.remoteapi;

import com.shizhan.springcloud.api.HelloFeignService;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * Created by xiaos 2019/2/22
 * //TODO 写点注释吧
 */
@FeignClient(value = "expose-service")
public interface HelloFeignServiceRemote extends HelloFeignService {
}
