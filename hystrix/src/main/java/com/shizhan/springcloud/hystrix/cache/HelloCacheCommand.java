package com.shizhan.springcloud.hystrix.cache;

import com.netflix.hystrix.*;
import com.netflix.hystrix.strategy.concurrency.HystrixConcurrencyStrategy;
import com.netflix.hystrix.strategy.concurrency.HystrixConcurrencyStrategyDefault;
import org.springframework.web.client.RestTemplate;

/**
 * Created by xiaos 2019/1/31
 * //TODO 写点注释吧
 */
public class HelloCacheCommand extends HystrixCommand<String> {


    private RestTemplate restTemplate;

    private Long id;

    protected HelloCacheCommand(RestTemplate restTemplate,Long id) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("helloCache"))
                .andCommandKey(HystrixCommandKey.Factory.asKey("helloCacheService"))
                .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("helloCacheThreadPool")));
        this.id = id;
        this.restTemplate = restTemplate;
    }

    @Override
    protected String run() throws Exception {
        return restTemplate.getForObject("",String.class);
    }

    @Override
    protected String getCacheKey() {
        return String.valueOf(id);
    }

    public static void flushCache(Long id){
        HystrixRequestCache.getInstance(HystrixCommandKey.Factory.asKey("helloCacheService"),
                HystrixConcurrencyStrategyDefault.getInstance()).clear(String.valueOf(id));
    }
}
