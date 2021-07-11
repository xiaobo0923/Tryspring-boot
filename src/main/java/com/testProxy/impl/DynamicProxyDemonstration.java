package com.testProxy.impl;

import com.testProxy.IProducer;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @ProjectName: Tryspring-boot
 * @Package: com.testProxy.impl
 * @ClassName: DynamicProxyDemonstration
 * @Author: xbo
 * @Description:
 * @Date: 2021/3/31 16:18
 */
public class DynamicProxyDemonstration {

    public static void main(String[] args) {
        //代理的真实对象
        IProducer realProducer = new Producer();
        /**
         * InvocationHandlerImpl 实现了 InvocationHandler 接口，并能实现方法调用从代理类到委托类的分派转发
         * 其内部通常包含指向委托类实例的引用，用于真正执行分派转发过来的方法调用.
         * * 即：要代理哪个真实对象，就将该对象传进去，最后是通过该真实对象来调用其方法
         * */
        InvocationHandler handler = new InvocationHandlerImpl(realProducer);
        ClassLoader loader = realProducer.getClass().getClassLoader();
        Class[] interfaces = realProducer.getClass().getInterfaces();
        /*** 该方法用于为指定类装载器、一组接口及调用处理器生成动态代理类实例*/
        IProducer producer = (IProducer) Proxy.newProxyInstance(loader, interfaces, handler);


        System.out.println("动态代理对象的类型：" + producer.getClass().getName());
        producer.saleProduct(new Float(15));
        //        String goodbye = subject.SayGoodBye();//        System.out.println(goodbye);    }

    }




}
