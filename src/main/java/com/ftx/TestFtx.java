package com.ftx;

import com.ftx.http.HttpUtil;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: xbo
 * @Description:
 * @Date: 2021/7/8 20:42
 */
public class TestFtx {

    @Test
    public void testq(){
        String url = "http://www.ftxgame.com/portal/portal/login";
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("accountId","270435527@qq.com");
        paramMap.put("password","592898147");
        String result = HttpUtil.doPost(url,paramMap,new HashMap<>());
        System.out.println(result);
    }
}
