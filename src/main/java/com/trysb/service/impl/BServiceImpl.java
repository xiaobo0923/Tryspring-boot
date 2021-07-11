package com.trysb.service.impl;

import com.trysb.service.ICreateProxyBySwsxDmService;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.stereotype.Service;

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
 * @date 2021/2/2
 */
@Service("com.trysb.service.ICreateProxyBySwsxDmService_B")
public class BServiceImpl implements Condition,ICreateProxyBySwsxDmService {
    @Override
    public String doMethod() {
        return "B~~";
    }

    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        return false;
    }
}
