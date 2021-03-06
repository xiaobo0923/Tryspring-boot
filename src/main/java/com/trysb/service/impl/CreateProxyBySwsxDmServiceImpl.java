package com.trysb.service.impl;

import com.testProxy.impl.InterfaceFactory;
import com.trysb.service.ICreateProxyBySwsxDmService;
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
@Service
public class CreateProxyBySwsxDmServiceImpl {


    public void test(){
        String proxyDm = "A";
        ICreateProxyBySwsxDmService ser = InterfaceFactory.getInstanceBySuf(proxyDm,ICreateProxyBySwsxDmService.class);
        System.out.println(ser.doMethod());

    }


}
