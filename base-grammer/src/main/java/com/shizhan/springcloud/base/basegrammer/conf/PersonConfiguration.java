package com.shizhan.springcloud.base.basegrammer.conf;

import com.shizhan.springcloud.base.basegrammer.entity.Person;
import com.shizhan.springcloud.base.basegrammer.entity.Persons;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by xiaos 2019/1/30
 * //TODO 写点注释吧
 */
@Configuration
public class PersonConfiguration {


    @Resource
    private Map<String,Person> mapPerson;


    @Bean("person1")
    public Person person1(){
        return new Person("P1",11);
    }

    @Bean("person2")
    public Person person2(){
        return new Person("P2",12);
    }

    @Bean
    public Persons persons(List<Person> pesons){
        Persons ps = new Persons();
        ps.setPersonList(pesons);
        return ps;
    }
}
