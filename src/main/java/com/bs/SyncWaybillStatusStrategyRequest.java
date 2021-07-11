package com.bs;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 *  同步运单状态策略
 */

@Data
@Accessors(chain = true)
public class SyncWaybillStatusStrategyRequest {

    private String logisticsNo;

    private String statusCode;

    private String statusName;

    private String action;

    private String actionName;

    private String remark;

    private Date traceStamp;

    private String operator;

    private String orderShipmentTaskGroupId;

    private String waybillId;

    private Integer version;
}
