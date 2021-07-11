package com.testDrools;

import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

/**
 * @Author: xbo
 * @Description:
 * @Date: 2021/5/6 12:22
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultDTO<T> {

    private String code;
    private  String msg;
    private T data;
    private Object gd7;

}
