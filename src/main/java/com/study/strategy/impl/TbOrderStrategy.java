package com.study.strategy.impl;

import com.study.annotation.HandlerOrderType;
import com.study.constant.OrderConstant;
import com.study.entity.Order;
import com.study.strategy.OrderStrategy;
import org.springframework.stereotype.Component;

/**
 * 淘宝订单-策略类
 *
 * @author xiehongwei
 * @date 2021/02/19
 */
@Component
@HandlerOrderType(OrderConstant.TB)
public class TbOrderStrategy implements OrderStrategy {

    @Override
    public String handleOrder(Order order) {
        return "----淘宝订单----";
    }
}
