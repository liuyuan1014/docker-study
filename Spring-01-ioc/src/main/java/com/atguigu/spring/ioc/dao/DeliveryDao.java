package com.atguigu.spring.ioc.dao;


import com.atguigu.spring.ioc.database.MyDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeliveryDao {


    /**
     * 问题1、数据源组件有sange
     *     1、@Primary
     *  效果：能不能自动？
     *     1、告诉Spring。哪个数据源那种情况下生效。@Conditional
     */

    @Autowired
    MyDataSource myDataSource;

     public void saveDelivery() {
        System.out.println("数据源：保存数据" + myDataSource);
    }
}
