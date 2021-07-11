package com.trysb.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bs.XmlUtils;
import com.trysb.service.ftx.IFtxService;
import org.dom4j.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.util.Arrays;
import java.util.Map;

/**
 * @ProjectName: Tryspring-boot
 * @Package: com.trysb.controller
 * @ClassName: FtxReadController
 * @Author: xbo
 * @Description:
 * @Date: 2021/4/7 11:23
 */
@RestController
@RequestMapping("/ftx")
public class FtxReadController {

    @Autowired
    private IFtxService ftxService;


    @RequestMapping("/read")
    public void ReadAndSaveInfo(){
        String fileName = "E:\\ftGo\\tt";//E:\ftGo\tt,E:\ftGo\FxGoX+FxGoC (FTX挂机程序)下载\info

        File file = new File(fileName);
        File[] files = file.listFiles();
        System.out.println(files.length);
        readFile(files);


    }

    private void readFile(File[] files){
        Arrays.stream(files).forEach((file) -> {
            if(file.isFile()){
                String fileName = file.getName();
                System.out.println(fileName);
                //BufferedInputStream bis = null;
                try {
                    Reader reader = new InputStreamReader(new FileInputStream(file));
                    BufferedReader htmlReader = new BufferedReader(reader);
                    StringBuffer stringBuffer = new StringBuffer();
                    String tempLine =null;
                    while (null!=(tempLine = htmlReader.readLine())){
                        stringBuffer.append(tempLine);
                        stringBuffer.append("\n\r");
                    }

                    dealFile(stringBuffer.toString());
                    reader.close();
                    /*FileInputStream fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    int len = 0;
                    byte[] temp = new byte[1024];
                    while ((len = bis.read(temp)) != -1) {
                        stringBuffer.append(new String(temp, 0, len));
                    }
                    System.out.println(stringBuffer.toString().substring(0, 200));*/
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else if(file.isDirectory()){
                File[] newfiles = file.listFiles();
                readFile(newfiles);
            }
        });
    }

    private void dealFile(String htmlstr) {
        try {
            htmlstr = htmlstr.replace("<meta charset=\"UTF-8\">","");
            htmlstr = "<ROOT>"+htmlstr+"</ROOT>";


            System.out.println(XmlUtils.xml2map(htmlstr));

            Map map = XmlUtils.xml2map(htmlstr);

            Map zhxxMap = (Map) map.get("div");


            System.out.println(JSON.toJSONString(map));
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }


    @RequestMapping("/select")
    public String selectFtx(){
        return ftxService.selectFtx();
    }
}
