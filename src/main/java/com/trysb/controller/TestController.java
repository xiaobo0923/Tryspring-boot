package com.trysb.controller;

import com.alibaba.fastjson.JSON;
import com.testProxy.ApplicationContextHelper;
import com.testProxy.impl.InterfaceFactory;
import com.trysb.service.ICreateProxyBySwsxDmService;
import com.trysb.service.impl.AServiceImpl;
import com.trysb.service.impl.BServiceImpl;
import org.junit.Test;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/wk")
public class TestController {


    @RequestMapping("/testList")
    public Object sayHello(){

        List<Map<String,String>> sbfkList = new ArrayList<>();
        int i = 0;
        while (i<19){
            Map<String,String> map = new HashMap<>();
            map.put("idx",String.valueOf(i));
            sbfkList.add(map);
            i++;
        }
        System.out.println(sbfkList.size());//0  10
        String pageIndex = "1";
        String pageSize = "10";
        int formIndex = Integer.parseInt(pageIndex)*Integer.parseInt(pageSize);
        int EndIndex = formIndex + Integer.parseInt(pageSize);
        if(sbfkList.size()>=EndIndex){
            sbfkList = sbfkList.subList(formIndex,EndIndex);
        }else{
            sbfkList = sbfkList.subList(formIndex,sbfkList.size());
        }
        System.out.println(sbfkList.size());//0  10
        return sbfkList;
    }

    @RequestMapping("/testSwsx")
    public Object TestSwsx(String[] args) {
        return getSwsxList("110671,110207");
    }

    private String[]  getSwsxList(String swsxStr){
        try {
            String[] swsxArray = {"110113","110207","110671","110150","110151"};
            List<String> list = new ArrayList<String>();
            for(String swsxDm : swsxArray){
                if(swsxStr.contains(swsxDm)){
                    list.add(swsxDm);
                }
            }
            return (String[]) list.toArray(new String[list.size()]);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Test
    @RequestMapping("/testA")
    public void test(){
        //System.out.println("232323:"+producer.getClass().isAnnotation());

        AServiceImpl pro = new AServiceImpl();
        System.out.println("qqqq:"+ JSON.toJSONString(pro.getClass().getAnnotations()));

        System.out.println("pro.getClass().getName():"+pro.getClass().getName());

        /*BServiceImpl bService = (BServiceImpl) InterfaceFactory.getObject("serviceB");
        System.out.println("bbbb:"+ JSON.toJSONString(bService.getClass().getAnnotations()));
        AServiceImpl aService = (AServiceImpl) ApplicationContextHelper.getBean("serviceA");
        System.out.println("aaaa:"+ JSON.toJSONString(aService.getClass().getAnnotations()));*/

        String proxyDm = "A";
        ICreateProxyBySwsxDmService ser = InterfaceFactory.getInstanceBySuf(proxyDm,ICreateProxyBySwsxDmService.class);
        System.out.println(ser.doMethod());


        proxyDm = "B";
        ICreateProxyBySwsxDmService serb = ApplicationContextHelper.getInstanceBySuf(proxyDm,ICreateProxyBySwsxDmService.class);
        System.out.println(serb.doMethod());
        //Annotation[] annotations = producer.getClass().getAnnotations();
        //System.out.println(annotations);
    }
}
