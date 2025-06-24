package com.atguigu.spring.ioc;

import com.atguigu.spring.ioc.bean.Car;
import com.atguigu.spring.ioc.bean.Dog;
import com.atguigu.spring.ioc.bean.Person;
import com.atguigu.spring.ioc.controller.UserController;
import com.atguigu.spring.ioc.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Map;

/**
 * 这是主入口类，也是主程序类
 */

@SpringBootApplication
public class Spring01IocApplication {
    /**
     * 测试自动注入
     * @param args
     */
    public static <UserControlller> void main(String[] args) {
        ConfigurableApplicationContext ioc = SpringApplication.run(Spring01IocApplication.class, args);
        System.out.println("===容器创建完成====");

        UserController userController = ioc.getBean(UserController.class);
        System.out.println("usercontroller = " +userController);

    }


    /**
     * 条件注册
     * @param args
     */
    public static void test06(String[] args) {
        ConfigurableApplicationContext ioc = SpringApplication.run(Spring01IocApplication.class, args);

        Map<String, Person> beans = ioc.getBeansOfType(Person.class);
        System.out.println("beans = " + beans);

        //拿到环境变量
        ConfigurableEnvironment environment = ioc.getEnvironment();
        String p = environment.getProperty("OS");
        System.out.println("property = " + p);

        Map<String, Dog> beans1 = ioc.getBeansOfType(Dog.class);
        System.out.println("beans = " + beans1);
    }

    //FactoryBean在容器中放的组件的类型，是接口中泛型指定的类型，组件的名字是 工厂自己的名字
    public static void test05(String[] args) {
        ConfigurableApplicationContext ioc = SpringApplication.run(Spring01IocApplication.class, args);
        System.out.println("======容器创建完成了=====");

        Car bean1 = ioc.getBean(Car.class);
        Car bean2 = ioc.getBean(Car.class);
        System.out.println(bean1 == bean2);

        Map<String, Car> beansOfType = ioc.getBeansOfType(Car.class);
        System.out.println("beansOfType:" + beansOfType);


    }

    /**
     * @Scope 调整组件的作用域
     * 1、@Scope("prototype"):非单实例
     *      容器启动的时候不会创建非单实例的对象
     *      什么获取什么时候创建
     * 2、@Scope("singleton"):单实例 默认值
     *      容器启动的时候会创建单实例对象
     *      容器启动完成之前就会创建好
     *    @lazy：懒加载
     *      容器启动完成之前不会创建懒加载组件的对象
     *      什么时候获取，什么时候创建
     * 3、@Scope("request"):同一个请求单实例
     * 4、@Scope("session"): 同一次会话单实例
     */
    public static void test04(String[] args) {
        ConfigurableApplicationContext ioc = SpringApplication.run(Spring01IocApplication.class, args);
        Object zhangsan = ioc.getBean("hahaha");
        System.out.println("zhangsan = " + zhangsan);
//        Object zhangsan1 = ioc.getBean("hahaha");
//        System.out.println("zhangsan2 = " + zhangsan1);
//        Object zhangsan2 = ioc.getBean("hahaha");
//        System.out.println("zhangsan2 = " + zhangsan2);

//        //容器创建的时候（完成之前），所有的单实例对象创建完成
//        System.out.println(zhangsan1 == zhangsan2);//true

        Object zhangsan1 = ioc.getBean("hahaha");
        System.out.println("zhangsan = " + zhangsan1);
        Object zhangsan2 = ioc.getBean("hahaha");
        System.out.println("zhangsan = " + zhangsan2);

        System.out.println(zhangsan1 == zhangsan2);//false

    }

    /**
     * 默认，分层注解能起作用的前提是：这些组件必须放在主程序所在的包及其子包结构下
     * Spring为我们提供了快速的MVC分层注解
     * 1、@Controller  控制器
     * 2、@Service  服务层
     * 3、@Repository 持久层
     *4、@Component 组件
     * @param args
     */
    public static void test03(String[] args) {
        ConfigurableApplicationContext ioc = SpringApplication.run(Spring01IocApplication.class, args);
        UserController bean = ioc.getBean(UserController.class);
        System.out.println("bean = " + bean);

        UserService bean1 = ioc.getBean(UserService.class);
        System.out.println("bean1 = " + bean1);


    }



    /**
     * 组件：框架的底层配置
     * 配置文件：指定配置
     * 配置类：分类管理组件的配置,配置类也是容器中的组件
     * 组件的创建时机：容器启动的过程中就会创建组件对象
     * 单实例特性：所有组件默认是单例的，每次获取直接从容器中拿就行了，容器启动的时候会创建组件
     * @param args
     */
    public static void test02(String[] args) {
        //跑起一个Spring程序的应用； ApplicationContex：Spring应用上下文对象
        //SpringBoot创建并管理Spring应用上下文
        ConfigurableApplicationContext ioc = SpringApplication.run(Spring01IocApplication.class, args);


        System.out.println("========ioc容器创建完成======");

        //2.获取组件
        Dog bean = ioc.getBean(Dog.class);
        System.out.println("bean =" + bean);
        Dog bean1 = ioc.getBean(Dog.class);
        System.out.println("bean1 =" + bean);
        Dog bean2 = ioc.getBean(Dog.class);
        System.out.println("bean2 =" + bean);

        System.out.println("======================");
        for (String beanName : ioc.getBeanDefinitionNames()) {
            System.out.println(beanName);
        }

    }

    public static void test01BeanAnnotation(String[] args) {
        //跑起一个Spring程序的应用； ApplicationContex：Spring应用上下文对象
        //SpringBoot创建并管理Spring应用上下文
        ConfigurableApplicationContext ioc = SpringApplication.run(Spring01IocApplication.class, args);
        System.out.println("ioc=" + ioc);
        //2、容器中装了那些组件；SPring中有很多默认组件
//        String[] names = ioc.getBeanDefinitionNames();
//        for (String name : names) {
//            System.out.println(name);
//        }

        //4、精准获取容器中的组件对象
        //组件的四大特性：名字、类型、对象、作用域
        //组件名全局唯一；组件名重复了，一定只会给容器中放一个最先声明的那个

        /**
         * 小结：
         * 从容器中获取组件：
         * 1）如果组件不存在，抛异常：NoSuchBeanDefinitionException;
         *2）如果组件不唯一，按照类型如果只要一个，也会抛异常：NoUniqueBeanDefinitionException
         *  按名字只要一个，精确获取到指定对象
         *  多个：返回所有组件的list集合
         * 3）组件唯一存在，正确返回
         */
        //4.1按照组件的名字获取
//        Person zhangsan = (Person)ioc.getBean("hahaha");
//        System.out.println("对象 = " + zhangsan);
//
//        //4.2按照组件的类型获取对象
//        Person bean = ioc.getBean(Person.class);
//        System.out.println("对象bean = " + bean);
        //4.3按照组件的类型获取所有组件
        Map<String, Person> beansOfType = ioc.getBeansOfType(Person.class);
        System.out.println("beansOfType=" + beansOfType);

        //4.4按照类型+名字
        Person bean = ioc.getBean("hahaha", Person.class);
        System.out.println("bean =" +bean);

        //5.组件是单实例的


    }




}
