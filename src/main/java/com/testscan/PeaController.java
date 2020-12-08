package com.testscan;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



/**
 * <p>
 * Project: TrySpring-Boot
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
 * @date 2020/12/3
 */
@RestController
@RequestMapping("/sc")
public class PeaController {


    @RequestMapping("/testScan")

    public Object testScan(){
        return "scan new package";
    }
}
