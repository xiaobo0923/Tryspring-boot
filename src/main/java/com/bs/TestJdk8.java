package com.bs;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sun.org.apache.xpath.internal.patterns.NodeTestFilter;
import com.testDrools.Info;
import com.testDrools.ResultDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestJdk8 {

    private List<User> list = new ArrayList<>();

    @Before
    public void init() {
        list.add(new User(1L, "张无忌", "123456"));
        list.add(new User(1L, "周芷若", "123456"));
        list.add(new User(1L, "赵敏", "123456"));
        list.add(new User(1L, "张强", "123456"));
        list.add(new User(1L, "张三丰", "123456"));
    }

    /**
     * 采用jdk8流进行过滤
     */
    @Test
    public void testFilter() {

        /*
        * .findAny()表示将其中任意一个返回；
            .orElse(null)表示如果一个都没找到返回null
        * */
        list.stream()
//1.筛选所有姓张的人
                .filter((item) -> item.getUsername().startsWith("张"))
//2.筛选名字只有3个字的人
                .filter((item) -> item.getUsername().length() == 3)
//3.打印结果
                .forEach((name) -> {
                            System.out.println(name);
                        }
                );


    }

    /**
     * 将Stream转换成集合
     */
    @Test
    public void testStreamToList() {
        List<User> nameLIst = list.stream().collect(Collectors.toList());
        System.out.println(nameLIst);
    }

    /**
     * 更改集合list中的对象
     */
    @Test
    public void testUpdateList() {
        list.stream().forEach((item) -> {
            String username = item.getUsername();
            if (username.equals("赵敏")) {
                item.setUsername(String.format("%s漂亮", username));
            }
        });
        System.out.println(list);
    }
    /**
     afterSaleQuantityDTOS.stream().collect(Collectors.toMap(o->o.getOrderId()+o.getOrderItemSeqId(),
     OrderItemAfterSaleQuantityDTO::getAfterSaleQuantity, (o,n)->n));
     */

    /**
     * 数组与流的转换
     */
    @Test
    public void testArray() {
//把可变参数转换成Stream
        Stream<Integer> Stream1 = Stream.of(1, 2, 3, 4, 5);
//把数组转换成Stream
        Integer[] arr = {1, 2, 3, 4, 5};
        Stream<Integer> Stream2 = Stream.of(arr);
    }

    /**
     * map方法
     * 将T类型的数据转换成R类型数据，这种转换就叫做映射
     */
    @Test
    public void testStreamMap() {
//获取名称的集合
        List<String> nameList = list.stream()
                .filter((item) -> item.getUsername().startsWith("张"))
                .map((item) -> {
                    return item.getUsername();
                })
//获取前2个数据的流
                .limit(2)
                .collect(Collectors.toList());
        System.out.println(nameList);
    }

    /**
     * skip 方法 :跳过流中前n个数据
     */
    @Test
    public void testSkip() {
        list.stream()
                .skip(1)
                .forEach((item) -> {
                    System.out.println(item);
                });
    }


    @Data
    @AllArgsConstructor //生成全参数构造函数
    @NoArgsConstructor //生成无参构造函数
    public class User {
        private Long id;
        private String username;
        private String password;
    }

    @Test
    public void addMinute() {
        GregorianCalendar gc = new GregorianCalendar();
        //gc.setTimeInMillis(inputDate.getTime());
        //gc.add(Calendar.MINUTE, minute);
        gc.add(Calendar.MINUTE, -10);
        System.out.println("22:"+gc.getTime());
        //return gc.getTime();

        LocalDateTime time = LocalDateTime.now();
        time.minusMinutes(10);
        System.out.println("33:"+gc.getTime());
        time.plusMinutes(-10);
        System.out.println("44:"+gc.getTime());


        String tt = time.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        System.out.println("55:"+tt);

        List<String> slist = new ArrayList<>();
        slist.add("123");
        slist.add("abc");
        System.out.println("66:"+slist);
        String[] array2 = slist.toArray(new String[slist.size()]);

    }

    @Test
    public void testN(){
  /*      SyncWaybillStatusStrategyRequest request = new SyncWaybillStatusStrategyRequest()
                .setWaybillId("W2104240004176")
                .setAction("1")
                .setActionName("2")
                .setOperator("2")
                .setLogisticsNo("2")
                .setRemark("s")
                .setOrderShipmentTaskGroupId("222")
                .setStatusCode("222")
                .setStatusName("sss")
                .setTraceStamp(new Date())
                .setVersion(1);
        System.out.println(JSON.toJSONString(request));*/

        /*log.info("供应商承担的部分：{}，维修厂订单运费总金额：{}，维修厂承担的小狮服务部分:{}，物流服务商应收金额：{}",
                vendorPayAmounts, garagePayAmounts, garagePayAmountsToWhoLion, actualAmounts);*/
        //供应商承担的部分：10.00，维修厂订单运费总金额：5.00，维修厂承担的小狮服务部分:5.00，物流服务商应收金额：12.00
        /*BigDecimal vendorPayAmounts = BigDecimal.valueOf(10.00);
        BigDecimal garagePayAmounts = BigDecimal.valueOf(5.00);
        BigDecimal garagePayAmountsToWhoLion = BigDecimal.valueOf(5.00);
        BigDecimal actualAmounts = BigDecimal.valueOf(12.00);

        BigDecimal refundAmounts = garagePayAmountsToWhoLion.add(vendorPayAmounts).subtract(actualAmounts).setScale(2
                , BigDecimal.ROUND_HALF_UP);
        BigDecimal garageRefundAmounts =
                garagePayAmountsToWhoLion.multiply(refundAmounts).divide(garagePayAmountsToWhoLion.add(vendorPayAmounts), 2, BigDecimal.ROUND_HALF_UP).setScale(2, BigDecimal.ROUND_HALF_UP);
        BigDecimal vendorRefundAmounts = refundAmounts.subtract(garageRefundAmounts).setScale(2, BigDecimal.ROUND_HALF_UP);

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(df.format(new Date()));*/


        BigDecimal a = BigDecimal.valueOf(38.99);
        BigDecimal b = BigDecimal.valueOf(9.29);
        BigDecimal c = BigDecimal.valueOf(39);

        System.out.println(b.add(c).subtract(a));


    }

    public String[] test(){
        LocalDate today  = LocalDate.now();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("MM月dd日");
        String dateStrs[]=new String[7];
        for (int j=0;j<7;j++){
            LocalDate todayj=today.plusDays(-j);
            String dateStr = todayj.format(fmt);
            dateStrs[j]=dateStr;
        }

        return dateStrs;
    }

/*storeAndFacilityDTO.getFacilityRelationDTOList().forEach(facilityRelationDTO -> {
            storeAndFacilityDTO.setSupportWhoLionService(false);
            boolean enableFlag = false;
            for(Map<String, String> map : deliveryList){
                if(!StringUtils.isBlank(map.get("deliveryProvinceGeoId"))){
                    enableFlag = map.get("deliveryProvinceGeoId").equals(facilityRelationDTO.getFacilityId());
                }
                if(!StringUtils.isBlank(map.get("deliveryCityGeoId"))){
                    enableFlag = enableFlag && map.get("deliveryCityGeoId").equals(facilityRelationDTO.getCityId());
                }
                if(!StringUtils.isBlank(map.get("deliveryCountyGeoId"))){
                    enableFlag = enableFlag && map.get("deliveryCountyGeoId").equals(facilityRelationDTO.getCountyId());
                }
                if(!StringUtils.isBlank(map.get("deliveryVillageGeoName"))){
                    enableFlag = enableFlag && map.get("deliveryVillageGeoName").equals(facilityRelationDTO.getStreetId());
                }
                if(enableFlag){
                    break;
                }
            }
            if(enableFlag){
                storeAndFacilityDTO.setSupportWhoLionService(true);
            }
        });*/
@Test
public void testQ(){

    Timestamp ts = new Timestamp(System.currentTimeMillis());
    Date date = new Date();
    try {
        date = ts;
        System.out.println(date);
    } catch (Exception e) {
        e.printStackTrace();
    }

}

}
