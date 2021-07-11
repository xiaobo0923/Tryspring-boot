package com.bs;

/**
 * <p>
 * Project: Tryspring-boot
 * </p>
 *
 * <p>
 * Function: [功能模块：]
 * </p>
 *
 * <p>
 * Description: [功能描述：]
 * </p>
 *
 * <p>
 * Copyright: Copyright(c) 2013-2022 税友集团
 * </p>
 *
 * <p>
 * Company: 税友软件集团有限公司
 * </p>
 *
 * @author xbo
 * @version 1.0
 * @date 2021/1/14
 */

public class CommonUtil {

    /*public static <T> T getInstanceBySuf(String suffix, Class<T> clazz) {
        String sbzlClass = clazz.getName() + "_" + suffix;
        String sbzlAnnotation = AnnotationFactory.getInstance().getBean(sbzlClass);
        if (!StringUtil.isNullString(sbzlAnnotation)) {
            return BondeInterfaceFactory.getInstance().getInterface(sbzlClass, new boolean[0]);
        } else {
            sbzlClass = clazz.getName();
            sbzlAnnotation = AnnotationFactory.getInstance().getBean(sbzlClass);
            return StringUtil.isNullString(sbzlAnnotation) ? null : BondeInterfaceFactory.getInstance().getInterface(sbzlClass, new boolean[0]);
        }
    }


    public static <T> T getInstanceBySuf(String suffix, Class<T> clazz) {
		String sbzlClass = clazz.getName() + "_" + suffix;
		String sbzlAnnotation = AnnotationFactory.getInstance()
				.getBean(sbzlClass);
		if (!StringUtil.isNullString(sbzlAnnotation)) {
			return (T) BondeInterfaceFactory.getInstance()
					.getInterface(sbzlClass);
		}
		sbzlClass = clazz.getName();
		// added by dain 2015-12-22 如果没有默认注解则返回空
		sbzlAnnotation = AnnotationFactory.getInstance().getBean(sbzlClass);
		if (StringUtil.isNullString(sbzlAnnotation)) {
			return null;
		}
		return (T) BondeInterfaceFactory.getInstance().getInterface(sbzlClass);
	}


    */



}
