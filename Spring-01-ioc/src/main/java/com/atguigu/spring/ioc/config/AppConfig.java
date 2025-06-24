package com.atguigu.spring.ioc.config;

import ch.qos.logback.core.CoreConstants;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

//把这些注解放到配置类上，能保持主程序干净
@Import(CoreConstants.class)
@Configuration
@ComponentScan(basePackages = "com.atguigu.spring") //组件批量扫描，只扫描利用Spring相关注解注册到容器中的组件
public class AppConfig {
}
