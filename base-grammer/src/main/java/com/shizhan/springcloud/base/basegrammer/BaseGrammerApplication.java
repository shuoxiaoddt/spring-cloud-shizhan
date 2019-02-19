package com.shizhan.springcloud.base.basegrammer;

import com.shizhan.springcloud.base.basegrammer.testimport.EnableMyProxy;
import com.shizhan.springcloud.base.basegrammer.testimport.MyService;
import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.event.ContextRefreshedEvent;

@SpringBootApplication
@ComponentScan(basePackages = "com.shizhan.springcloud.base")
@EnableMyProxy
public class BaseGrammerApplication implements ApplicationContextAware , ApplicationListener<ContextRefreshedEvent> {

    private ApplicationContext applicationContext;

    public static void main(String[] args) {
        SpringApplication.run(BaseGrammerApplication.class, args);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if(event instanceof  ContextRefreshedEvent){
            MyService myProxy = applicationContext.getBean(MyService.class);
            System.out.println("myProxy instance==>"+myProxy.sayHelloService("hello"));
        }
    }
}

