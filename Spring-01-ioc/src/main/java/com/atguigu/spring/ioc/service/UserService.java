package com.atguigu.spring.ioc.service;

import com.atguigu.spring.ioc.bean.Person;
import com.atguigu.spring.ioc.dao.Userdao;
import jakarta.annotation.Resource;
import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@ToString
@Data
public class UserService {

//    @Qualifier("bill") //精确指定：如果容器中这样的组件有多个，则使用@Qualifier精确指定组建的名字

    @Qualifier("lisi") //精确指定：如果容器中这样的组件有多个，且有默认组件，我们可以使用@Qualifier切换别的组件
    @Autowired
    Person person;

    /**
     * 面试题：@Resource 和 @Autowired 区别？
     * 1、@Autowired 和 @Resource 都是做bean的注入用的，都可以放在属性上
     * 2、@Resource的使用性更高，@Autowired是spring家的，只能在spring中用
     * 3、如果注入的容器不存在，@Resource不可以调整，会直接报错
     * 而@Autowired（“required = false"),则可以将不存在的容器设为null，不会报错
     *
     */
    @Resource
    Userdao userdao;


}
