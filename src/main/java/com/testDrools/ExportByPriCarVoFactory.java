/*
package com.testDrools;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

*/
/**
 * @Author: xbo
 * @Description:
 * @Date: 2021/5/6 14:54
 *//*

public class ExportByPriCarVoFactory {

        public static ExportByPriCarVo create(){
            LocalDate today  = LocalDate.now();
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("MM月dd日");
            String dateStrs[]=new String[7];
            for (int j=0;j<7;j++){
                LocalDate todayj=today.plusDays(-j);
                String dateStr = todayj.format(fmt);
                dateStrs[j]=dateStr;
            }
            ExportByPriCarVo vo = new ExportByPriCarVo();
            vo.n_pri_ser_cost_rate_d1d = dateStrs[0];
            vo.n_pri_ser_cost_rate_d2d = dateStrs[1];
            return vo;
        }

        @Test
        public void test(){
            System.out.println(create());
        }
}
*/
