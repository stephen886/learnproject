package com.learn.system.bean;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 添加@RefreshScope注解实现配置的实时刷新
 */
@Configuration
@RefreshScope
public class Config {

    @Value("${person.name:stephen}")
    public String name;

    public String getName(){
        return name;
    }

    @Bean
    Person person1(){
        Person p = new Person();
        System.out.println("------------------------------------");
        System.out.println(name);
        p.setName("person1");
        return p;
    }

    @Bean
    Person person2(@Qualifier("person1") Person p){
        return p;
    }

    @Bean
    Person person3(@Qualifier("person1") Person p){
        p.setName("person3");
        return p;
    }

}
