package com.testDrools.constans;

/**
 * @Author: xbo
 * @Description:
 * @Date: 2021/5/6 16:08
 */
public enum DayEnum {
    ORDER("order"),
    WAYBILL("waybill"),
    ALLOWANCE("allowance");

    private String value;
    DayEnum(String value) {
    }

    public String getValue() {
        return this.value;
    }
}
