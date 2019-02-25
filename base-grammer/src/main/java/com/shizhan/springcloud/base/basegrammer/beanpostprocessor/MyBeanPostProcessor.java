package com.shizhan.springcloud.base.basegrammer.beanpostprocessor;

import com.shizhan.springcloud.base.basegrammer.entity.Person;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * Created by xiaos 2019/2/25
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {


    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(beanName.equals("person1")){
            bean = new Person("xs",0);
        }
        return bean;
    }
}
