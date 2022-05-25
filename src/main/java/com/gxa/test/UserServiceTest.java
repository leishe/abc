package com.gxa.test;

import com.gxa.aspect.TimeHandler;
import com.gxa.service.UserService;
import com.gxa.service.impl.UserServiceImpl;
import org.junit.Test;


/**
 * jdk的动态代理要求：
 *   被代理类必须实现接口
 *
 *   如果没有被代理类没有实现接口怎么办？ jdk的动态代理就不能使用
 *      引入cglib代理 ，采用继承来进行代理
 */

/**
 * 总结：
 *  1、静态代理  不违背OCP ,问题改动被代理类，代理类也需要变动
 *  2、jdk动态代理
 *     好处：改动代理类，我们是不需要动代码
 *     缺点：被代理类必须实现接口
 *  3、cglib  采用继承来做的。
 */
public class UserServiceTest {


    @Test
    public void testQuery(){

        //准备被代理对象
        UserService userService = new UserServiceImpl();
        //准备切面
        TimeHandler timeHandler = new TimeHandler();
        //产生代理对象
        UserService proxy = (UserService) timeHandler.createProxy(userService);
        //调用代理对象的方法
        proxy.update();
    }


}
