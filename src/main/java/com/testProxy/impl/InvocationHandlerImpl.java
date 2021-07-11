package com.testProxy.impl;

import com.testProxy.IProducer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @ProjectName: Tryspring-boot
 * @Package: com.testProxy.impl
 * @ClassName: InvocationHandlerImpl
 * @Author: xbo
 * @Description:
 * @Date: 2021/3/31 16:03
 */
public class InvocationHandlerImpl implements InvocationHandler {

    //这个就是我们要代理的真实对象
    private Object proxyObject;

    //构造方法
    public InvocationHandlerImpl(IProducer producer) {
        this.proxyObject = producer;
    }

    /**
     * @param proxy:    代理类实例
     * @param method:   被调用的方法对象
     * @param args:调用参数
     * @Description 该方法负责集中处理动态代理类上的所有方法调用。
     * @return: java.lang.Object
     * @author: xbo
     * @date: 2021/3/31 16:14
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //在代理真实对象前我们可以添加一些自己的操作
        System.out.println("调用之前dothing");
        System.out.println("Method:" + method);
        // 当代理对象调用真实对象的方法时，其会自动的跳转到代理对象关联的handler对象的invoke方法来进行调用
        Object returnValue = method.invoke(proxyObject, args);
        //在代理真实对象后我们也可以添加一些自己的操作
        System.out.println("调用之后dothing");
        return returnValue;
    }


}
