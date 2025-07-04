package com.atguigu.spring.ioc.dao;

import com.atguigu.spring.ioc.bean.Dog;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@ToString
@Repository
public class Userdao {
    Dog dog;

    /**
     * 推荐：构造器注入
     * @param dog
     */
    //Spring会自动去容器中找到构造器需要的所有参数的组件值
//    public Userdao (Dog dog) {
//        System.out.println("Userdao......有参构造器" + dog);
//
//        this.haha = dog;
//    }
//    @Autowired
//    public void setHaha(@Qualifier("dog01") Dog dog) {
//        System.out.println("setHaha = " + dog);
//        this.dog = dog;
//    }
}
