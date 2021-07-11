package com.testDrools;

import lombok.Data;

import java.io.Serializable;

/**
 * @ProjectName: Tryspring-boot
 * @Package: com.testDrools
 * @ClassName: IrssetDroolsVo
 * @Author: xbo
 * @Description:
 * @Date: 2021/4/10 14:34
 */
@Data
public class IrssetDroolsVo implements Serializable {

    private Integer surpDayCnt = null;
    private boolean mBlack = false;
    private String msg;
}
