package com.shizhan.springcloud.base.basegrammer.testimport;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * Created by xiaos 2019/2/19
 * //TODO 写点注释吧
 */
public class MyServiceRegister implements ImportBeanDefinitionRegistrar {


    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        BeanDefinitionBuilder builder = BeanDefinitionBuilder
                .genericBeanDefinition(MyServiceFactoryBean.class);
        registry.registerBeanDefinition("myService",builder.getBeanDefinition());
    }
}
