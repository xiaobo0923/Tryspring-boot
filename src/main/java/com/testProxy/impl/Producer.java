package com.testProxy.impl;

import com.testProxy.IProducer;
import org.springframework.stereotype.Service;

/**
 * @ProjectName: Tryspring-boot
 * @Package: com.testProxy.impl
 * @ClassName: ProducerImpl
 * @Author: xbo
 * @Description: 生产者的实现类
 * @Date: 2021/3/31 15:48
 */
@Service("cn.com.service.product")
public class Producer implements IProducer {


    @Override
    public void saleProduct(float money) {
        System.out.println("销售产品，并拿到钱："+money);
    }

    @Override
    public void afterService(float money) {
        System.out.println("提供售后服务，并拿到钱："+money);
    }
}
