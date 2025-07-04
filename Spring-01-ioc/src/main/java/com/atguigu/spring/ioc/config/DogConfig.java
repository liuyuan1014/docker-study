package com.atguigu.spring.ioc.config;

import com.atguigu.spring.ioc.bean.Dog;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnResource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DogConfig {

//    @ConditionalOnMissingBean(name = "bill")
//    @ConditionalOnBean(name = "bill")
    @ConditionalOnResource(resources = "classpath:haha.abc")
    @Bean
    public Dog dog() {
        return new Dog();
    }

//    @Bean
//    public Dog dog01() {
//        Dog dog = new Dog();
//        dog.setName("大狗");
//
//        return dog;
//    }
//
//    @Bean
//    public Dog dog02() {
//        Dog dog = new Dog();
//        dog.setName("二狗");
//        return dog;
//    }
}
