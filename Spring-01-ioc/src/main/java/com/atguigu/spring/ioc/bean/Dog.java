package com.atguigu.spring.ioc.bean;

import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@ToString
@Data
public class Dog {
    public Dog() {
        System.out.println("Dog构造器----");
    }

    //@Autowired //自动注入组件的，基本类型自己搞

    /**
     * 1/@Value("字面值”）：直接赋值
     * 2、@Value（“${key}"):动态从配置文件中取出某一项的值。如：${person.age}
     *3.@Value("#{SpLE}"):SpLE:Spring language Exepetion :Spring表达式语言
     */

    @Value("旺财")
    private String name;

    @Value("${dog.age}")
    private int age;

    @Value("#{T(java.util.UUID).randomUUID().toString()}")
    private String id;

    @Value("#{10*20}")
    private String color;

    @Value("#{'Hello Word'.substring(0,5)}")
    private String msg;

    @Value("#{1>2?'haha':'hehe'}")
    private String flag;

}
