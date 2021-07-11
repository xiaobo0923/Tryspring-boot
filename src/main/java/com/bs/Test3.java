package com.bs;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Test3 {
    public static void main(String[] args) {
        try {
            /*String responseXml = "<?xml version=\"1.0\" encoding=\"GBK\"?><TaxSession><RtnState><RtnCode>0</RtnCode><RtnMsg><Code>2000</Code><Message>交接成功!</Message></RtnMsg></RtnState><RtnCont><ROOT><DDHM>7a9b1a462e6a4ffeb8bd860fc493b64e</DDHM><YJHM>sf007a9b1a462e6a4ffeb8bd860fc493b64e</YJHM><YJZF>0.1</YJZF></ROOT></RtnCont></TaxSession>";
           *//* XmlVO<TechnicalMessageVo> xmlVOHead;
            xmlVOHead = XmlUtil.doXmlParse(responseXml.toString().getBytes("UTF-8"),
                    TechnicalMessageVo.class, "UTF-8");
            TechnicalMessageVo vo = xmlVOHead.getXmlParse();
            String body = vo.getBody();
            XmlVO<TaxSession> xmlvo = XmlUtil.doXmlParse(body.getBytes("UTF-8"),
                    TaxSession.class, "UTF-8");
            TaxSession responseTaxSession = xmlvo.getXmlParse();
            RtnState rtnState = responseTaxSession.getRtnState();
            RtnCont rtnCont = responseTaxSession.getRtnCont();
            System.out.println("rtnState:"+rtnState);
            System.out.println("rtnCont:"+rtnCont);*//*
            Document document = DocumentHelper.parseText(responseXml);
            Element element = document.getRootElement();
            String retCode = element.element("RtnCont").element("ROOT").element("DDHM").getTextTrim();
            //String retMsg = element.element("HEAD").element("RET_MSG").getTextTrim();
            System.out.println("rtnState:"+retCode);

            String  s = "2019-10-15 14:18:17";
            String r = s.substring(0,10);
            String t = s.substring(11);
            System.out.println(r);
            System.out.println(t);
            test1();
            ResultVO resultVO = new ResultVO();
            System.out.println(resultVO.isSuccess());*/
            String s = getBJDate(180);
            System.out.println(s);
        }catch (Exception e ){
            e.printStackTrace();
        }

    }

    private static void test1(){
        List list = new ArrayList();
        list.add("11");
        list.add("22");
        list.add("33");
        System.out.println(list.size()+","+ JSON.toJSON(list));
        list.remove(2);
        System.out.println(list.size()+","+JSON.toJSON(list));
    }


    private static String getBJDate(Integer bjsx) {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateNowStr = sdf.format(d); //当前年月日

        Date data1 = toDate("yyyy-MM-dd HH:mm:ss", dateNowStr + " 12:00:00");
        Date data2 = toDate("yyyy-MM-dd HH:mm:ss", dateNowStr + " 14:00:00");
        Date data3 = toDate("yyyy-MM-dd HH:mm:ss", dateNowStr + " 18:00:00");
        Date data4 = toDate("yyyy-MM-dd HH:mm:ss", dateNowStr + " 09:00:00");
        Date data5 = toDate("yyyy-MM-dd HH:mm:ss", dateNowStr + " 23:59:59");
        Date data6 = toDate("yyyy-MM-dd HH:mm:ss", dateNowStr + " 00:00:00");

        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now = new Date();
        Date afterDate = new Date();

        Calendar cal = new GregorianCalendar();
        cal.setTime(d);
        cal.add(Calendar.DATE, 1);//把日期往后增加一天(年月日)

        Date time = new Date();
        //判断当前时间是否为休息时间
        if (bjsx == 30) {
            //12:00:00-14:00:00
            if (isEffectiveDate(now, data1, data2)) {
                time = toDate("yyyy-MM-dd HH:mm:ss", dateNowStr + " 14:30:00");
                return sdf1.format(time);
                //18:00:00-23:59:59
            } else if (isEffectiveDate(now, data3, data5)) {
                time = toDate("yyyy-MM-dd HH:mm:ss", sdf.format(cal.getTime()) + " 09:30:00");
                return sdf1.format(time);
                //00:00:00-09:00:00
            } else if (isEffectiveDate(now, data6, data4)) {
                time = toDate("yyyy-MM-dd HH:mm:ss", dateNowStr + " 09:30:00");
                return sdf1.format(time);
            }
            afterDate = new Date(now.getTime() + 30 * 60 * 1000);//30分钟后的时间
        } else if (bjsx == 180) {
            //12:00:00-14:00:00
            if (isEffectiveDate(now, data1, data2)) {
                time = toDate("yyyy-MM-dd HH:mm:ss", dateNowStr + " 17:00:00");
                return sdf1.format(time);
                //18:00:00-23:59:59
            } else if (isEffectiveDate(now, data3, data5)) {
                time = toDate("yyyy-MM-dd HH:mm:ss", sdf.format(cal.getTime()) + "  12:00:00");
                return sdf1.format(time);
                //00:00:00-09:00:00
            } else if (isEffectiveDate(now, data6, data4)) {
                time = toDate("yyyy-MM-dd HH:mm:ss", dateNowStr + "  12:00:00");
                return sdf1.format(time);
            }
            afterDate = new Date(now.getTime() + 3 * 60 * 60 * 1000);//3小时后的时间
        }
        //判断办结时间是否为休息时间
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(data4);
        calendar.add(calendar.DATE, 1);//把日期往后增加一天.
        data4 = calendar.getTime();
        //12:00:00-14:00:00 或者 申请时间在11:00:00-12:00:00(这段时间申请的办结时间会跳过12:00:00-14:00:00时间段,则单独判断)
        Date data7 = toDate("yyyy-MM-dd HH:mm:ss", dateNowStr + " 11:00:00");
        if (isEffectiveDate(afterDate, data1, data2) || isEffectiveDate(now, data7, data1)) {
            time = new Date(afterDate.getTime() + 2 * 60 * 60 * 1000);//+2小时
            return sdf1.format(time);
            //18:00:00-09:00:00(date+1)
        } else if (isEffectiveDate(afterDate, data3, data4)) {
            time = new Date(afterDate.getTime() + 15 * 60 * 60 * 1000); //+15小时
            return sdf1.format(time);
        } else {
            return sdf1.format(afterDate);
        }
    }


    private static boolean isEffectiveDate(Date afterDate, Date startTime, Date endTime) {
        if (afterDate.getTime() == startTime.getTime()
                || afterDate.getTime() == endTime.getTime()) {
            return true;
        }
        Calendar date = Calendar.getInstance();
        date.setTime(afterDate);

        Calendar begin = Calendar.getInstance();
        begin.setTime(startTime);

        Calendar end = Calendar.getInstance();
        end.setTime(endTime);

        if (date.after(begin) && date.before(end)) {
            return true;
        } else {
            return false;
        }
    }

    private static Date toDate(String fmt, String dateStr) {
        SimpleDateFormat sdf = new SimpleDateFormat(fmt);

        try {
            Date date = sdf.parse(dateStr);
            return date;
        } catch (ParseException var4) {
            var4.printStackTrace();
            System.out.println("格式化出错");
            return null;
        }
    }

}
