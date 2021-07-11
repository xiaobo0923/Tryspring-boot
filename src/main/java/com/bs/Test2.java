package com.bs;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.testDrools.FacilityRelationDTO;
import com.testDrools.PostalAddressDTO;
import com.testDrools.StoreAndFacilityDTO;
import com.trysb.vo.ResultVO;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class Test2 {

    public static void main(String[] args) {
        /*String xmlStr = "<PivotSet><item><column name = \"ZSXM_DM\">10101</column><column name = \"COUNT_SXF\">246640420787.614</column></item><item><column name = \"ZSXM_DM\">10104</column><column name = \"COUNT_SXF\">2246327927.35</column></item><item><column name = \"ZSXM_DM\">10106</column><column name = \"COUNT_SXF\">24655960025.6844</column></item><item><column name = \"ZSXM_DM\">30217</column><column name = \"COUNT_SXF\"></column></item></PivotSet>";
        String beginStr = "<?xml version=\"1.0\" encoding=\"GBK\"?>";
        xmlStr = beginStr + xmlStr;
        Document doc = null;
        try {
            doc = DocumentHelper.parseText(xmlStr);
            Node taserNode =  doc.selectSingleNode("//PivotSet");
            List nodes = taserNode.selectNodes("//item");
            for(int i = 0; i<nodes.size(); i++) {
                Node node = (Node) nodes.get(i);
                List chilNodes = node.selectNodes("//column");
                for(int j = 0;j<chilNodes.size();j++){
                    Node childNode = (Node) chilNodes.get(j);
                    String text = childNode.getText();
                    String name = childNode.valueOf("@name");//拿取name屬性
                }

            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }*/
        /*String s = "110150,110151,110112,110113,110207,110671";
        String[] swsxList = null;
        swsxList = s.split(",");
        String [] ss = s.split(",");
        for(String str : swsxList){
            //System.out.println(str);
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(dateFormat.format(new Date()));
        SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-mm-dd");
        System.out.println(dateFormat1.format(new Date()));*/
        /*String name = "2020";
        String path = "/";
        System.out.println(checkParam(name));
        System.out.println(checkParam(path));*/

        /*String s = "{\"data\":\"{\\\"context\\\":\\\"{\\\\\\\"CURRENT_PAGE\\\\\\\":1}\\\",\\\"dircount\\\":5,\\\"filecount\\\":0,\\\"hasMore\\\":false,\\\"infos\\\":[{\\\"filesize\\\":0,\\\"name\\\":\\\"123213\\\"},{\\\"filesize\\\":0,\\\"name\\\":\\\"1\\\"},{\\\"filesize\\\":0,\\\"name\\\":\\\"12\\\"},{\\\"filesize\\\":0,\\\"name\\\":\\\"q\\\"},{\\\"filesize\\\":0,\\\"name\\\":\\\"2020\\\"}]}\",\"paramList\":[],\"success\":true}";
        JSONObject resultJson = JSONObject.fromObject(s);
        if(!"true".equals(resultJson.optString("success"))){
            System.out.println("false");
        }
        JSONObject data = JSONObject.fromObject(resultJson.optString("data"));
        System.out.println("==查询目录文件data==："+ data);
        JSONArray array = data.getJSONArray("infos");
        System.out.println("==查询目录文件array==："+ array);
        ResultVO resultVO = JsonUtil.getObjectForJsonString(s, ResultVO.class);
        System.out.println("==resultVO==："+ JSONObject.fromObject(resultVO.getData()));

        String filepath = "//预算/";
        try {
            //filepath = new String(filepath.getBytes("ISO-8859-1"), "UTF-8");
            System.out.println("==filepath==："+ filepath);
            filepath = new String(filepath.getBytes("ISO-8859-1"), "UTF-8");
            System.out.println("==filepath==："+ filepath);
            if (StringUtils.isNotBlank(filepath)) {
                System.out.println(filepath.contains("../"));
                if(filepath.contains("../")){
                    filepath = filepath.replaceAll("../", "");
                }

                if (filepath.contains("//")) {
                    filepath = filepath.replaceAll("//", "/");
                }

                if (filepath.indexOf("..") >= 0) {
                    System.out.println("你访问的目录非法，请确认是否有越权访问目录："+ filepath);
                }
            }
            System.out.println("==filepath==："+ filepath);
        }catch (Exception e){
            e.printStackTrace();
        }*/


        /*TestPro tp = new TestPro();
        try {
            Method method = tp.getClass().getDeclaredMethod("remove");
            try {
                System.out.println(method.invoke(tp));
                System.out.println(method.invoke(tp,"1"));
                System.out.println(method.invoke("1","1"));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }*/

       /* boolean ispass = true;
        HashMap<String, Object> returnMap = new HashMap<String, Object>();
        returnMap.put("ispass",ispass);
        System.out.println(returnMap.get("ispass").getClass());
        System.out.println(returnMap.get("ispass").equals(ispass));
*/      /*if(ttt()){
            System.out.println("555ddd");
        }
        String hyDm = "5111";
        String zczb = "100000";
        String cyrs = "3";
        if("51".equals(hyDm.substring(0,2)) && Integer.parseInt(zczb)<=800000 && Integer.parseInt(cyrs)<=11){
            System.out.println("555");
        }*/
        /*NsrxxVO nsrxxVO =new NsrxxVO();
        nsrxxVO.setNsrztDm("05");
        if(nsrxxVO.getNsrztDm() == "05"){
            System.out.println("aqa");
        }
        if("05".equals(nsrxxVO.getNsrztDm())){
            System.out.println("zxz");
        }
        String st = "{\"zzsybnsrzyywlb_dm\":\"9\",\"zzsybnsrzyywlbmc\":\"工业\",\"rdyxqq\":\"2020-07-01\"}";
        System.out.println(JSONObject.fromObject(st));

        TestPro tp = new TestPro();
        try {
            Method method = tp.getClass().getDeclaredMethod("remove");
            try {
                System.out.println(method.invoke(tp));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        try {
            Field s = tp.getClass().getDeclaredField("name");
            System.out.println(s);
            System.out.println(s.get(null));
            Field s1 = tp.getClass().getField("name");
            System.out.println(s1.get(null));

            Field s2 = tp.getClass().getField("name");
            s2.setAccessible(true);
            System.out.println(s2.get(null));

            Field s3 = tp.getClass().getDeclaredField("age");
            s3.setAccessible(true);
            System.out.println(s3.get(null));

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }*/
        //int[] s = new int[]{1,1,0,5};
        //System.out.println(Integer.compare(s[0],s[3]));
        /*String str = "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";
        try {
            System.out.println(stringToObject(str));
        } catch (IOException e) {
            e.printStackTrace();
        }*/



    }
    @Test
    public void tets(){
        String s = "1,2,3,4";
        String [] sp = s.split(",");
        List<Integer> list = new ArrayList<>();

        List<StoreAndFacilityDTO> requests = new ArrayList<>();
        StoreAndFacilityDTO storeAndFacilityDTO = new StoreAndFacilityDTO();
        storeAndFacilityDTO.setId("1");
        storeAndFacilityDTO.setStoreId("HL000001");
        storeAndFacilityDTO.setFacilityId("CN_GZHDC");
        requests.add(storeAndFacilityDTO);
        System.out.println(JSON.toJSONString(requests));
    }

    public static Object stringToObject(String str) throws IOException, NullPointerException {
        ByteArrayInputStream inStream = new ByteArrayInputStream(Base64.decode(str));
        ObjectInputStream in = null;
        Object obj = null;

        try {
            in = new ObjectInputStream(inStream);

            try {
                obj = in.readObject();
            } catch (ClassNotFoundException var8) {
                var8.printStackTrace();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            in.close();
            inStream.close();
        }

        return obj;
    }
    private static boolean ttt(){
        return true;
    }

    private void test1(){
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat myFmt = new SimpleDateFormat("yyyy-MM");
        String dateStr = myFmt.format(cal.getTime()).toString()+"-01";
        int months = 3;
        if (months == 0) {
            System.out.println("111");
        }
        Calendar calendar = Calendar.getInstance();
        String formatter = "";
        if (dateStr.indexOf('-') != -1 && dateStr.length() >= 8) {
            formatter = "yyyy-MM-dd";
            String[] temp = dateStr.split("-");
            calendar.set(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]) - 1, Integer.parseInt(temp[2]));
        } else if (dateStr.indexOf('/') != -1 && dateStr.length() >= 8) {
            formatter = "yyyy/MM/dd";
            String[] temp = dateStr.split("/");
            calendar.set(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]) - 1, Integer.parseInt(temp[2]));
        } else {
            formatter = "yyyyMMdd";
            calendar.set(Integer.parseInt(dateStr.substring(0, 4)), Integer.parseInt(dateStr.substring(4, 6)) - 1,
                    Integer.parseInt(dateStr.substring(6, 8)));
        }
        SimpleDateFormat myFmt1 = new SimpleDateFormat(formatter);
        calendar.add(Calendar.MONTH, months);
        String timeStr = myFmt1.format(calendar.getTime()).toString();
        System.out.println("timeStr:"+timeStr);
    }

    private static String ts(){
        String s = "110150,110151,110112,110113,110207,110671";
        String[] swsxList = null;
        swsxList = s.split(",");
        String [] ss = s.split(",");
        for(String str : swsxList){
            System.out.println(str);
            if("110150".equals(str)){

                return "s";
            }
        }
        return "q";
    }

    private static String getFpzgkpxeDm(String kpxe) {
        String FpzgkpxeDm = "7";
        if (kpxe.equals("100")) {
            FpzgkpxeDm = "7";
        }
        if (kpxe.equals("1000")) {
            FpzgkpxeDm = "6";
        }
        if (kpxe.equals("10000")) {
            FpzgkpxeDm = "5";
        }
        if (kpxe.equals("100000")) {
            FpzgkpxeDm = "4";
        }
        if (kpxe.equals("1000000")) {
            FpzgkpxeDm = "3";
        }
        if (kpxe.equals("10000000")) {
            FpzgkpxeDm = "2";
        }
        if (kpxe.equals("100000000")) {
            FpzgkpxeDm = "1";
        }
        return FpzgkpxeDm;
    }

    /*private static String testXe(){
        String fpxxgrid = "[{\"fpzlmc\":\"增值税专用发票（中文三联无金额限制版）\",\"fpzldm\":\"1130\",\"zgkpxe\":\"10000\",\"_state\":\"added\",\"_uid\":0,\"_editing\":true,\"dffpzgkpxeMc\":\"一万元\",\"fpzgkpxeDm\":\"5\",\"_index\":0}]";
        JSONArray fpxxGridArrays = JSONArray.parseArray(fpxxgrid);
        System.out.println("fpxxGridArrays:"+fpxxGridArrays);
        JSONArray array = new JSONArray();
        String fpzldm ,zgkpxedm,ybwbz="N";//一百万标志，超一百万的专票白名单也不允许即办
        for (int i = 0; i < fpxxGridArrays.size(); i++) {

            JSONObject fpxxObj = (JSONObject) fpxxGridArrays.get(i);
            fpzldm = fpxxObj.getString("fpzldm");
            zgkpxedm = getFpzgkpxeDm(fpxxObj.getString("zgkpxe"));
            fpxxObj.put("fpzgkpxeDm", zgkpxedm);
            array.add(fpxxObj);
        }

        String fpxxGrids = array.toString();
        JSONArray fpxxArray = JSONArray.parseArray(fpxxGrids);
        System.out.println("fpxxArray:"+fpxxArray);


        return null;
    }
*/
/*    private static void checkParam(String spram) {
        if (StringUtils.isEmpty(spram)) {
            return;
        }
        String s = URLDecoder.decode(spram, "utf-8");
        for (int i = 0; i < KEYS.length; i++) {
            if (s.indexOf(KEYS[i]) > -1) {
                throw new Exception("请求参数包含非法字符串。");
            }
        }*/
}