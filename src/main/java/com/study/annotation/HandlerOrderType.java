package com.study.annotation;

import java.lang.annotation.*;

/**
 * 自定义策略注解
 *
 * @author xiehongwei
 * @date 2021/02/19
 */
@Target(ElementType.TYPE)//作用在类上
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited//子类可以继承此注解
public @interface HandlerOrderType {
    /**
     * 策略类型
     */
    int value();
}
