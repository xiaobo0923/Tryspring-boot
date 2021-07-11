package com.utils;

import lombok.extern.log4j.Log4j2;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Log4j2
public class DateUtils {

	public static final String ZERO_ZERO = " 0:0:0 0";
	public static final String TIME_LAST = " 23:59:59 99";

	private DateUtils() {
	}

	public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

	/**
	 * 将时间转换为String类型
	 * @author JUM
	 * @param date	时间
	 * @param fmt	时间格式 默认为yyyy-MM-dd HH:mm:ss
	 */
	public static String dateParseString(Date date, String fmt) {
		if (date == null) {
			return null;
		}
		SimpleDateFormat df;
		if (fmt == null || fmt.equals("")) {
			df = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
		} else {
			df = new SimpleDateFormat(fmt);
		}
		return df.format(date).toString();
	}
	/**
	 * 将String类型转换为时间类型
	 * @author JUM
	 * @param source	需要转换的String字符串
	 * @param fmt		需要转换的类型
	 * @return	Date	时间	
	 */
	public static Date stringParseDate(String source,String fmt){
		if(null==source || ("").equals(source)){
			return null;
		}
		Date  date=null;
		SimpleDateFormat df;
		if (fmt == null || fmt.equals("")) {
			df = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
		} else {
			df = new SimpleDateFormat(fmt);
		}
		try {
			date=df.parse(source);
		} catch (ParseException e) {
			log.warn("内容：{} 格式：{}不匹配",source,fmt,e);
		}
		return date;
	}
	/**
	 * 将String类型转换为时间类型
	 * @author JUM
	 * @param source	需要转换的String字符串  格式:yyyy-MM-dd HH:mm:ss
	 * @return	Date	时间	
	 */
	public static Date stringParseDate(String source){
		String df = null;
		if(source.contains("-") && source.contains(":")){
			df = YYYY_MM_DD_HH_MM_SS;
		}else  if(source.contains("-") && !source.contains(":")){
			df = "yyyy-MM-dd";
		}
		return stringParseDate(source,df);
	}
	
	/**
	 * 将String时间字符串转换为Long类型
	 * @author JUM
	 * @param source	需要转换的String字符串
	 * @param fmt			需要转换的类型
	 * @return	Long	
	 */
	/*public static Long stringDateParseLong(String source,String fmt){
		if(null==source || ("").equals(source)){
			return null;
		}
		Date  date=null;
		SimpleDateFormat df;
		if (fmt == null || fmt.equals("")) {
			df = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
		} else {
			df = new SimpleDateFormat(fmt);
		}
		try {
			date=df.parse(source);
		} catch (ParseException e) {
			log.warn("内容：{} 格式：{}不匹配",source,fmt,e);
		}
		if(null !=date) {
			return date.getTime();	
		}else {
			return new Date().getTime();
		}
	}*/
	/**
	 * 获取几天后的时间
	 * @author JUM
	 * @param nextDay	需要获取的天数
	 * @return	Date	几天后的时间
	 */
	public static Date getNextDate(int nextDay){
		Calendar c = Calendar.getInstance(TimeZone.getDefault(), Locale.CHINA); 
		c.add(Calendar.DATE, nextDay);
		Date newdate = c.getTime();
		return newdate;
	}
	/**
	 * 得到某一个月份的最大天数
	 * @param year		年
	 * @param month		月
	 * @return
	 */
	public static int getDays(int year, int month) {
		Calendar time = Calendar.getInstance();
		time.clear();
		time.set(Calendar.YEAR, year);
		time.set(Calendar.MONTH, month - 1);// 注意,Calendar对象默认一月为0
		int day = time.getActualMaximum(Calendar.DAY_OF_MONTH);// 本月份的天数
		return day;
	}
	/**
	 * 计算某一天是一年中的第几个星期
	 * @param year
	 * @param month
	 * @param day
	 * @return
	 */
	public static int getWeekNo(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month-1);
		cal.set(Calendar.DAY_OF_MONTH, day);
		int weekno = cal.get(Calendar.WEEK_OF_YEAR);
		return weekno;
	}
	/**
	 * 计算两个时间的相隔天数
	 * @param startday		开始时间
	 * @param endday		结束时间
	 * @return
	 */
	public static int getIntervalDays(Calendar startday, Calendar endday) {
		// 确保startday在endday之前
		if (startday.after(endday)) {
			Calendar cal = startday;
			startday = endday;
			endday = cal;
		}
		// 分别得到两个时间的毫秒数
		long sl = startday.getTimeInMillis();
		long el = endday.getTimeInMillis();

		long ei = el - sl;
		// 根据毫秒数计算间隔天数
		return (int) (ei / (1000 * 60 * 60 * 24));
	}
	/**
	 * 计算两个时间的相隔天数
	 * @param startday		开始时间
	 * @param endday		结束时间
	 * @return
	 */
	public static int getIntervalDays(Date startday, Date endday) {
		// 确保startday在endday之前
		if (startday.after(endday)) {
			Date cal = startday;
			startday = endday;
			endday = cal;
		}
		// 分别得到两个时间的毫秒数
		long sl = startday.getTime();
		long el = endday.getTime();

		long ei = el - sl;
		// 根据毫秒数计算间隔天数
		return (int) (ei / (1000 * 60 * 60 * 24));
	}
	
	public static int getDaysBetween(Calendar d1, Calendar d2) {
		if (d1.after(d2)) { // swap dates so that d1 is start and d2 is end
			Calendar swap = d1;
			d1 = d2;
			d2 = swap;
		}
		int days = d2.get(Calendar.DAY_OF_YEAR) - d1.get(Calendar.DAY_OF_YEAR);
		int y2 = d2.get(Calendar.YEAR);
		if (d1.get(Calendar.YEAR) != y2) {
			d1 = (Calendar) d1.clone();
			do {
				days += d1.getActualMaximum(Calendar.DAY_OF_YEAR);// 得到当年的实际天数
				d1.add(Calendar.YEAR, 1);
			} while (d1.get(Calendar.YEAR) != y2);
		}
		return days;
	}
	
	/**
	 * 增加几年
	 * 
	 * @param inputDate
	 * @param years
	 * @return
	 */
	public static Date addYears(Date inputDate, int years) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTimeInMillis(inputDate.getTime());
		gc.add(Calendar.YEAR, years);
		return gc.getTime();
	}

	/**
	 * 增加几天
	 * 
	 * @param inputDate
	 * @param days
	 * @return
	 */
	public static Date addDays(Date inputDate, int days) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTimeInMillis(inputDate.getTime());
		gc.add(Calendar.DATE, days);
		return gc.getTime();
	}
	/**
	 * 增加几小时
	 * @param inputDate
	 * @param hours
	 * @return
	 */
	public static Date addHours(Date inputDate, int hours) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTimeInMillis(inputDate.getTime());
		gc.add(Calendar.HOUR, hours);
		return gc.getTime();
	}
	
	/**
	 * 增加几分鐘
	 * @param inputDate
	 * @param minute
	 * @return
	 */
	@Test
	public static Date addMinute(Date inputDate, int minute) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTimeInMillis(inputDate.getTime());
		//gc.add(Calendar.MINUTE, minute);
		gc.add(Calendar.MINUTE, -10);
		System.out.println("22:"+gc.getTime());
		return gc.getTime();
	}
	/**
	 * 增加几秒钟
	 * @param inputDate
	 * @param second
	 * @return
	 */
	public static Date addSecond(Date inputDate, int second) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTimeInMillis(inputDate.getTime());
		gc.add(Calendar.SECOND, second);
		return gc.getTime();
	}

	/**
	 * 增加几月
	 * 
	 * @param inputDate
	 * @param months
	 * @return
	 */
	public static Date addMonths(Date inputDate, int months) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTimeInMillis(inputDate.getTime());
		gc.add(Calendar.MONTH, months);
		return gc.getTime();
	}

	/**
	 * 判断输入的日期是星期几
	 * 
	 * @param inputDate
	 * @return 
	 */
	public static int getWeekDay(Date inputDate) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTimeInMillis(inputDate.getTime());
		int xq = gc.get(Calendar.DAY_OF_WEEK);
		if(xq==1){
			return 7;
		}else{
			return xq-1;
		}
	}
	
	/**
	 * 判断输入的日期是星期几
	 * @param inputDate
	 * @return
	 */
	/*public static String getWeekDayZh(Date inputDate) {
		int xq = getWeekDay(inputDate);
		if (xq == 7)
			return "星期日";
		else if (xq == 1)
			return "星期一";
		else if (xq == 2)
			return "星期二";
		else if (xq == 3)
			return "星期三";
		else if (xq == 4)
			return "星期四";
		else if (xq == 5)
			return "星期五";
		else if (xq == 6)
			return "星期六";
		else
			return "";
	}*/
	
	
	/**
	 * 转换日期为中文
	 * @param inputDate
	 * @return
	 */
	public static String date2chinese(Date inputDate) {
		String dd = dateParseString(inputDate, "yyyyMMdd");
		if(null != dd) {
			return date2chinese(dd);	
		}else {
			return null;
		}
	}

	/**
	 * 转换日期为中文
	 * 
	 * @param date
	 * @return
	 */
	public static String date2chinese(String date) {
		// 日期格式为-> 20060101101520
		StringBuilder sb = new StringBuilder();
		sb.append(getChinese(Integer.parseInt(date.substring(0, 1))));
		sb.append(getChinese(Integer.parseInt(date.substring(1, 2))));
		sb.append(getChinese(Integer.parseInt(date.substring(2, 3))));
		sb.append(getChinese(Integer.parseInt(date.substring(3, 4))));
		sb.append("年");

		if (date.length() < 5) {
			return sb.toString();
		}
		String month1 = date.substring(4, 5);
		if (!"0".equals(month1)) {
			sb.append("十");
		}
		String month2 = date.substring(5, 6);
		if (!"0".equals(month2)) {
			sb.append(getChinese(Integer.parseInt(month2)));
		}
		sb.append("月");

		if (date.length() < 7) {
			return sb.toString();
		}
		String day1 = date.substring(6, 7);
		if ("0".equals(day1)) {
			// nothing
		} else if ("1".equals(day1)) {
			sb.append("十");
		} else {
			sb.append(getChinese(Integer.parseInt(day1)));
			sb.append("十");
		}
		String day2 = date.substring(7, 8);
		if (!"0".equals(day2)) {
			sb.append(getChinese(Integer.parseInt(day2)));
		}
		sb.append("日");
		return sb.toString();
	}

	private static String getChinese(int digital) {
		switch (digital) {
		case 0:
			return "〇";
		case 1:
			return "一";
		case 2:
			return "二";
		case 3:
			return "三";
		case 4:
			return "四";
		case 5:
			return "五";
		case 6:
			return "六";
		case 7:
			return "七";
		case 8:
			return "八";
		case 9:
			return "九";
		default: return "零";
		}
	}
	
	/**
	 * 根据输入的数字返回是中文的星期几 7:星期日 1：星期一
	 * 
	 * @param xq
	 * @return
	 */
	public static String getWeekName(int xq) {
		switch (xq) {
		case 1:
			return "星期一";
		case 2:
			return "星期二";
		case 3:
			return "星期三";
		case 4:
			return "星期四";
		case 5:
			return "星期五";
		case 6:
			return "星期六";
		case 7:
			return "星期日";
		default:return "";
		}
	}
	
	

	/**
	 * 获取指定时间是几号
	 * @author JumZeng
	 * @param date
	 * @return
	 */
	public static int getDay(Date date){
		int day = 1;
		Calendar time = Calendar.getInstance();
		time.setTime(date);
		day = time.get(Calendar.DAY_OF_MONTH);
		return day;
	}
	/**
	 * 获取指定时间是几月份
	 * @author JumZeng
	 * @param date
	 * @return
	 */
	public static int getMonth(Date date){
		int month = 1;
		Calendar time = Calendar.getInstance();
		time.setTime(date);
		month = time.get(Calendar.MONTH)+1;
		return month;
	}
	/**
	 * 获取指定时间是哪一年
	 * @author JumZeng
	 * @param date
	 * @return
	 */
	public static int getYear(Date date){
		int year = 1;
		Calendar time = Calendar.getInstance();
		time.setTime(date);
		year = time.get(Calendar.YEAR);
		return year;
	}
	/**
	 * 指定年月日返回Date
	 * @author JumZeng
	 * @param year
	 * @param month
	 * @param day
	 * @return
	 */
	public static Date getDate(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month-1);
		cal.set(Calendar.DAY_OF_MONTH, day);
		return cal.getTime();
	}
	/**
	 * 获取指定年月和星期都有几号，如9月所有星期1是哪几天
	 * @author JumZeng
	 * @param month
	 * @param weekDay
	 * @return
	 */
	public static List<String> getDays(int year,int month,int weekDay){
		List<String> days = new ArrayList<String>();
		if(weekDay<1 || weekDay>7){
			return days;
		}
		int monthMaxDay = getDays(year, month);
		for(int i=1;i<=monthMaxDay;i++){
			Date date = getDate(year,month,i);
			int weekDay1 = getWeekDay(date);
			if(weekDay==weekDay1){
				days.add(String.valueOf(i));
			}
		}
		return days;
	}
	
	/**
	 * 将日期做减法 返回结果区分正负
	 * @author 宋越  2016年11月23日
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static long getBetweenDate(Date date1,Date date2){
		
		long longDate1 = date1.getTime();
		long longDate2 = date2.getTime();
		
		long result = longDate1-longDate2;
		return result;
	}
	/**
	 * 判断某个日期是否是今天零点之前
	 * @author lijing 2017-11-30
	 * @param date
	 * @return ture 表示是今天以前的，false则反之
	 */
	public static boolean isBeforeToday(Date date){
		// 取得今天的零点零分零秒
		Calendar todayStart = new GregorianCalendar();
		todayStart.set(Calendar.HOUR_OF_DAY, 0);
		todayStart.set(Calendar.MINUTE, 0);
		todayStart.set(Calendar.SECOND, 0);
	    return todayStart.getTimeInMillis()>date.getTime();
	    
	}


	/**
	 * @Author: 张哲
	 * @Description: 过滤掉不能打印的特殊字符
	 */
	/*public static String filterUnSupportChar(String content) {
		StringBuilder appender = new StringBuilder("");

		if (StringUtils.isNotBlank(content)) {
			appender = new StringBuilder(content.length());

			for (int i = 0; i < content.length(); i++) {
				char ch = content.charAt(i);
				if ((ch == 0x9) || (ch == 0xA) || (ch == 0xD)
						|| ((ch >= 0x20) && (ch <= 0xD7FF))
						|| ((ch >= 0xE000) && (ch <= 0xFFFD))
						|| ((ch >= 0x10000) && (ch <= 0x10FFFF)))
					appender.append(ch);
			}
		}

		String result = appender.toString();

		return result.replace("]]>", "");
	}*/

	/**
	 * 处理前台传过来的最小和最大查询时间
	 * @param minDate
	 * @param maxDate
	 * @return
	 */
	/*public static Map<String, String> date2DefaultDate(String minDate, String maxDate) {

		Map<String, String> dateMap = new HashMap<>();
		if (StringUtils.isBlank(minDate) && StringUtils.isBlank(maxDate)) {
			try {
				java.text.DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				Date now = new Date();
				maxDate = format.format(now) + TIME_LAST;

				Calendar c = Calendar.getInstance();
				c.setTime(now);
				c.add(Calendar.MONTH, -3);
				c.add(Calendar.DATE, 1);

				minDate = format.format(c.getTime()) + ZERO_ZERO;
			} catch (Exception e) {
				log.warn("退货申请列表设置查询默认3个月失败!", e);
			}
		} else if (StringUtils.isNotEmpty(minDate) && StringUtils.isBlank(maxDate)) {
			minDate = minDate + ZERO_ZERO;
		} else if (StringUtils.isNotEmpty(maxDate) && StringUtils.isBlank(minDate)) {
			maxDate = maxDate + TIME_LAST;
		} else {
			minDate = minDate + ZERO_ZERO;
			maxDate = maxDate + TIME_LAST;
		}
		dateMap.put("minDate", minDate);
		dateMap.put("maxDate", maxDate);
		return dateMap;
	}*/
}
