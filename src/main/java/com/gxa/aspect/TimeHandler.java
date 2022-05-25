package com.gxa.aspect;


import com.gxa.service.UserService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//切面类（关注时间）
public class TimeHandler implements InvocationHandler {
    private UserService userService;

    //根据被代理对象创建代理对象
    public Object createProxy(UserService userService){
        this.userService = userService;

        Object proxy = Proxy.newProxyInstance(userService.getClass().getClassLoader(),
                                             userService.getClass().getInterfaces(),
                                            this);

        return proxy;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("执行方法前");

        //通过反射调用实际方法
        Object result = method.invoke(userService, args);
        System.out.println("执行方法后");

        return result;
    }
}
