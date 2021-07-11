package com.testProxy.impl;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @ProjectName: Tryspring-boot
 * @Package: com.testProxy.impl
 * @ClassName: InterfaceFactory
 * @Author: xbo
 * @Description: 获得Spring容器内的对象
 * @Date: 2021/4/1 9:34
 */
@Component
public class InterfaceFactory implements ApplicationContextAware {

    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {
        InterfaceFactory.context = applicationContext;
        System.out.println("++++++++context++++++++++++:"+context);
    }

    private static class Loader {
        private static final InterfaceFactory INSTANCE = new InterfaceFactory();
    }

    public static InterfaceFactory getInstance() {
        return Loader.INSTANCE;
    }

/*    private static InterfaceFactory interfaceFactory;

    public static InterfaceFactory getInstance() {
        if (interfaceFactory == null) {
            interfaceFactory = new InterfaceFactory();
            return interfaceFactory;
        } else {
            return interfaceFactory;
        }
    }*/


    /**
     * 根据 ID 获得某个Spring容器对象
     *
     * @param id 对象ID
     * @return Spring容器中的对象
     */
    public synchronized static Object getObject(String id) {
        Object object = null;
        object = context.getBean(id);
        return object;
    }

    /**
     * @Description
     * @param suffix: 后缀，通常用以分发的区分字段，例如事项代码
     * @param clazz: 类的限定名，一般注解为全路径限定+区分字段
     * @return: T
     * @author: xbo
     * @date: 2021/4/1 11:29
     */
    public static <T> T getInstanceBySuf(String suffix, Class<T> clazz) {
        /*String sbzlClass = clazz.getName() + "_" + suffix;
        String sbzlAnnotation = AnnotationFactory.getInstance().getBean(sbzlClass);
        if (!StringUtil.isNullString(sbzlAnnotation)) {
            return BondeInterfaceFactory.getInstance().getInterface(sbzlClass, new boolean[0]);
        } else {
            sbzlClass = clazz.getName();
            sbzlAnnotation = AnnotationFactory.getInstance().getBean(sbzlClass);
            return StringUtil.isNullString(sbzlAnnotation) ? null : BondeInterfaceFactory.getInstance().getInterface(sbzlClass, new boolean[0]);
        }*/
        String sbzlClass = clazz.getName() + "_" + suffix;
        return (T) getObject(sbzlClass);
    }


}
