package com.atguigu.spring.ioc.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


@PropertySource("classpath:cat.properties") //说明属性来源，把指定的文件导入到系统中，供我们取值使用
//1、classpath:cat.properties:从自己的项目类路径下找
//2、classpath*:Log4j-charsets.properties;从所有包的类路径下找
@Data
@Component
public class Cat {

    @Value("${cat.name:Tom}")
    private String name;

    @Value("${cat.age:5}")
    private int age;

}
