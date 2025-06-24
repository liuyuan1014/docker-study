package com.atguigu.spring.ioc.controller;

import com.atguigu.spring.ioc.bean.Person;
import com.atguigu.spring.ioc.service.UserService;
import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;


@ToString //自动生成ToString方法
@Data
@Controller
public class UserController {

    /**
     *自动装配流程（先按照类型，再按照名称）
     * 1、按照类型，找到这个组件；
     *      1.0、只有且找到一个，直接注入，名字无所谓
     *      1.1、如果能找到多个，再按名称去找，变量名就是名字（新版）
     *          1.1.1、如果找到，直接注入
     *          1.1.2、如果没找到，报错
     */
    @Autowired //自动装配 原理：Spring调用 容器的getBean方法
    UserService abc;

    @Autowired
    UserService bill;

    @Autowired //把这个类型的所有组件都拿来
    List<Person> personlist;

    @Autowired
    Map<String,Person> personMap;
}
