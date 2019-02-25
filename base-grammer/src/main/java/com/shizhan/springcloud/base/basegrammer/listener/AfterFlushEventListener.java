package com.shizhan.springcloud.base.basegrammer.listener;

import com.shizhan.springcloud.base.basegrammer.entity.Person;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by xiaos 2019/2/25
 */
@Component
public class AfterFlushEventListener implements ApplicationListener<ContextRefreshedEvent> ,ApplicationContextAware {


    private ApplicationContext applicationContext;
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        Person person1 = applicationContext.getBean("person1", Person.class);
        System.out.println(person1);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
