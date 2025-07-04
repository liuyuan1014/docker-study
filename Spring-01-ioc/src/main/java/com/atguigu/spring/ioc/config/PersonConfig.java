package com.atguigu.spring.ioc.config;

import com.atguigu.spring.ioc.bean.Person;
import com.atguigu.spring.ioc.condition.MacCondition;
import com.atguigu.spring.ioc.condition.WindowsCondition;
import org.springframework.context.annotation.*;

@Configuration //告诉Spring容器，这是一个配置类
/**
 * @Scope 调整组件的作用域
 * 1、@Scope("prototype"):非单实例
 * 2、@Scope("singleton"):单实例
 * 3、@Scope("request"):同一个请求单实例
 * 4、@Scope("session"): 同一次会话单实例
 */



public class PersonConfig {
    //场景：判断当前的操作系统是windows还是mac
    //windows系统： 容器中有bill
    //mac系统： 容器中有 john


    //只有当 MacCondition 条件满足时（即运行在 macOS 系统上），bill Bean 才会被创建。可以标在方法或者类上
    @Conditional(MacCondition.class)
    @Bean("bill")
    public Person bill() {
        Person person = new Person();
        person.setName("比尔盖茨");
        person.setAge(55);
        person.setGender("男");
        return person;
    }

    @Conditional(WindowsCondition.class)
    @Bean("john")
    public Person john() {
        Person person = new Person();
        person.setName("乔布斯");
        person.setAge(58);
        person.setGender("男");
        return person;
    }


        //3、给容器中注册一个组件；容器中的每个组件都有自己的名字，方法名就是组件的名字
//    @Scope("singleton")
    @Scope("prototype")
    @Bean("hahaha")
    public Person zhangsan() {
        Person person = new Person();
        person.setName("张三");
        person.setAge(20);
        person.setGender("男");
        return person;

    }

    @Primary //主组件：默认组件
    @Bean("lisi")
    public Person lisi() {
        Person person = new Person();
        person.setName("李四");
        person.setAge(20);
        person.setGender("男");
        return person;

    }
}
