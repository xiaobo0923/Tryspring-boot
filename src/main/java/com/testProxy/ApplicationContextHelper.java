package com.testProxy;


import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * ApplicationContextHelper
 *
 * @author xiqin.liu
 */
@Component
public class ApplicationContextHelper implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ApplicationContextHelper.applicationContext = applicationContext;
    }

    public static ApplicationContext getApplicationContext() {
        return ApplicationContextHelper.applicationContext;
    }

    public static <T> T getBean(Class<T> targetClz) {

        T beanInstance = null;
        //优先按type查
        try {
            beanInstance = (T) applicationContext.getBean(targetClz);
        } catch (Exception e) {
        }
        //按name查
        if (Objects.isNull(beanInstance)) {
            String simpleClassName = targetClz.getSimpleName();
            //首字母小写
            simpleClassName = Character.toLowerCase(simpleClassName.charAt(0)) + simpleClassName.substring(1);
            beanInstance = (T) applicationContext.getBean(simpleClassName);
        }
        if (Objects.isNull(beanInstance)) {
            // new SysException(BasicErrorCode.COLA_ERROR, "Component " + targetClz + " can not be found in Spring Container");
        }
        return beanInstance;
    }

    public static Object getBean(String beanName) {
        return ApplicationContextHelper.applicationContext.getBean(beanName);
    }

    public static <T> T getInstanceBySuf(String suffix, Class<T> clazz) {
        String sbzlClass = clazz.getName() + "_" + suffix;
        return (T) getBean(sbzlClass);
    }

}
