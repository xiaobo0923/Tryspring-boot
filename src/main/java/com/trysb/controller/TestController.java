package com.trysb.controller;

import org.springframework.boot.configurationprocessor.json.JSONArray;
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

}
