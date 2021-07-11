/**
 * Project Name:CassEC
 * File Name:T.java
 * Package Name:com.casstime.ec.util
 * Date:2015年8月27日上午9:57:26
 * Copyright (c) 2015, chenzhou1025@126.com All Rights Reserved.
 *
 */

package com.bs;


import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.*;

public class XmlUtils {
	private static final Logger logger = LoggerFactory.getLogger(XmlUtils.class);
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Map xml2map(String xmlString) throws DocumentException {
		Document doc = DocumentHelper.parseText(xmlString);
		Element rootElement = doc.getRootElement();
		Map<String, Object> map = new HashMap<String, Object>();
		map = Dom2Map(rootElement);
		// System.out.println(map);
		// 到此xml2map完成，下面的代码是将map转成了json用来观察我们的xml2map转换的是否ok
		// String string = JSONObject.fromObject(map).toString();
		// System.out.println(string);
		return map;
	}

	@SuppressWarnings("rawtypes")
	public static Map<String, Object> Dom2Map(Document doc) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (doc == null) {
			return map;
		}
		Element root = doc.getRootElement();
		for (Iterator iterator = root.elementIterator(); iterator.hasNext();) {
			Element e = (Element) iterator.next();
			List list = e.elements();
			if (list.size() > 0) {
				map.put(e.getName(), Dom2Map(e));
			} else {
				map.put(e.getName(), e.getText());
			}
		}
		return map;
	}

	@SuppressWarnings("unchecked")
	public static Map<String, Object> Dom2MapFindNode(Document doc, String node) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (doc == null) {
			return map;
		}
		List<Element> list = doc.selectNodes(node);
		for (Element ele : list) {
			map.put(ele.getName(), Dom2Map(ele));
		}
		return map;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Map Dom2Map(Element e) {
		Map map = new HashMap();
		List list = e.elements();
		if (list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				Element iter = (Element) list.get(i);
				List mapList = new ArrayList();

				if (iter.elements().size() > 0) {
					Map m = Dom2Map(iter);
					if (map.get(iter.getName()) != null) {
						Object obj = map.get(iter.getName());
						if (!(obj instanceof ArrayList)) {
							mapList = new ArrayList();
							mapList.add(obj);
							mapList.add(m);
						}else if (obj instanceof ArrayList) {
							mapList = (List) obj;
							mapList.add(m);
						}
						map.put(iter.getName(), mapList);
					} else {
						map.put(iter.getName(), m);
					}
				} else {
					if (map.get(iter.getName()) != null) {
						Object obj = map.get(iter.getName());
						if (!(obj instanceof ArrayList)) {
							mapList = new ArrayList();
							mapList.add(obj);
							mapList.add(iter.getText());
						}else if (obj instanceof ArrayList) {
							mapList = (List) obj;
							mapList.add(iter.getText());
						}
						map.put(iter.getName(), mapList);
					} else {
						map.put(iter.getName(), iter.getText());
					}
				}
			}
		} else {
			map.put(e.getName(), e.getText());
		}
		return map;
	}


	/**
	 * Coverter.
	 *
	 * @param object
	 *            the object
	 * @return the string
	 */
	public static String coverter2XMLString(Object object) {
		StringBuilder strBuilder = new StringBuilder();
		if (isObject(object)) {
			if(object instanceof Date){
				strBuilder.append(object);
			}else{
				Class<? extends Object> clz = object.getClass();
				ArrayList<Field> fieldsAll = new ArrayList<Field>(); 
				Field[] fields = clz.getDeclaredFields();
				fieldsAll.addAll(Arrays.asList(fields));
				Class<? extends Object> clazzSuper=clz.getSuperclass();
				Field[] fieldsSuper = clazzSuper.getDeclaredFields();
				fieldsAll.addAll(Arrays.asList(fieldsSuper));
				for (Field field : fieldsAll) {
					field.setAccessible(true);
					String fieldName = field.getName();
					Object value = null;
					try {
						value = field.get(object);
					} catch (IllegalArgumentException e) {
						continue;
					} catch (IllegalAccessException e) {
						continue;
					}
					if (isObject(value)) {
						if(value instanceof Date){
							strBuilder.append("<" + fieldName.toString().replaceAll("<", "&lt;").replaceAll(">", "&gt;") + ">");
							strBuilder.append(value.toString().replaceAll("<", "&lt;").replaceAll(">", "&gt;"));
							strBuilder.append("</" + fieldName.toString().replaceAll("<", "&lt;").replaceAll(">", "&gt;") + ">");
						}else{
							strBuilder.append("<" + fieldName.toString().replaceAll("<", "&lt;").replaceAll(">", "&gt;") + ">");
							strBuilder.append(coverter2XMLString(value));
							strBuilder.append("</" + fieldName.toString().replaceAll("<", "&lt;").replaceAll(">", "&gt;") + ">");
						}
						
					} else if (value == null) {
						strBuilder.append("<" + fieldName.toString().replaceAll("<", "&lt;").replaceAll(">", "&gt;") + ">");
						strBuilder.append("");
						strBuilder.append("</" + fieldName.toString().replaceAll("<", "&lt;").replaceAll(">", "&gt;") + ">");
					} else {
						strBuilder.append("<" + fieldName.toString().replaceAll("<", "&lt;").replaceAll(">", "&gt;") + ">");
						strBuilder.append(value.toString().replaceAll("<", "&lt;").replaceAll(">", "&gt;"));
						strBuilder.append("</" + fieldName.toString().replaceAll("<", "&lt;").replaceAll(">", "&gt;") + ">");
					}
				}
			}
		} else if (object == null) {
			strBuilder.append("");
		} else {
			strBuilder.append(object.toString().replaceAll("<", "&lt;").replaceAll(">", "&gt;") + "\n");
		}
		return strBuilder.toString();
	}

	/**
	 * Checks if is object.
	 *
	 * @param obj
	 *            the obj
	 *
	 * @return true, if is object
	 */
	private static boolean isObject(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj instanceof String) {
			return false;
		}
		if (obj instanceof Integer) {
			return false;
		}
		if (obj instanceof Double) {
			return false;
		}
		if (obj instanceof Float) {
			return false;
		}
		if (obj instanceof Byte) {
			return false;
		}
		if (obj instanceof Long) {
			return false;
		}
		if (obj instanceof Character) {
			return false;
		}
		if (obj instanceof BigDecimal) {
			return false;
		}
		if (obj instanceof Short) {
			return false;
		}
		if (obj instanceof Boolean) {
			return false;
		}
		return true;
	}

	@SuppressWarnings("rawtypes")
	public static String parseToXMLString(Map map) {
		StringBuffer sb = new StringBuffer();
		/** 开始对map进行解析 */
		if (map == null) {
			throw new NullPointerException("map 数据为空,不能解析!");
		}
		Set set = map.entrySet();
		Iterator records = set.iterator();
		try {
			while (records.hasNext()) {
				Map.Entry entry = (Map.Entry) records.next();
				if (entry.getValue() instanceof List) {// 子目录
					sb.append("<" + entry.getKey().toString() + ">");
					List mapList = (List) entry.getValue();
					for (Object listMap : mapList) {
						if(listMap instanceof Map){
							sb.append(parseToXMLString((HashMap) listMap));	
						}else{
							sb.append(coverter2XMLString(listMap));
						}
						
					}
					sb.append("</" + entry.getKey().toString().replaceAll("<", "&lt;").replaceAll(">", "&gt;") + ">");
				} else if (entry.getValue() instanceof Map) {// 子目录
					sb.append("<" + entry.getKey().toString().replaceAll("<", "&lt;").replaceAll(">", "&gt;") + ">");
					sb.append(parseToXMLString((Map) entry.getValue()));
					sb.append("</" + entry.getKey().toString().replaceAll("<", "&lt;").replaceAll(">", "&gt;") + ">");
				} else if (isParseAble(entry.getValue())) {// 到达顶点
					sb.append("<" + entry.getKey().toString().replaceAll("<", "&lt;").replaceAll(">", "&gt;") + ">");
					sb.append(entry.getValue().toString().replaceAll("<", "&lt;").replaceAll(">", "&gt;"));
					sb.append("</" + entry.getKey().toString().replaceAll("<", "&lt;").replaceAll(">", "&gt;") + ">");
				} else if(isObject(entry.getValue())){
					sb.append("<" + entry.getKey().toString().replaceAll("<", "&lt;").replaceAll(">", "&gt;") + ">");
					sb.append(coverter2XMLString(entry.getValue()));
					sb.append("</" + entry.getKey().toString().replaceAll("<", "&lt;").replaceAll(">", "&gt;") + ">");
				}
			}
		} catch (Exception e) {
			logger.error("json格式转xml格式字符串失败",e);
		}
		
		return sb.toString();
	}

	/**
	 * Checks if is object.
	 *
	 * @param obj
	 *            the obj
	 *
	 * @return true, if is object
	 */
	private static boolean isParseAble(Object obj) {

		if (obj instanceof String) {
			return true;
		}
		if (obj instanceof Integer) {
			return true;
		}
		if (obj instanceof Double) {
			return true;
		}
		if (obj instanceof Float) {
			return true;
		}
		if (obj instanceof Byte) {
			return true;
		}
		if (obj instanceof Long) {
			return true;
		}
		if (obj instanceof Character) {
			return true;
		}
		if (obj instanceof Short) {
			return true;
		}
		if (obj instanceof Boolean) {
			return true;
		}
		return false;
	}

	/**
	 * 将map对象转化为 xml字符串
	 * 
	 * @param map
	 * @author wu.chen 2016.6.12
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static String map2XmlStringForSoap(Map<String, Object> map) {
		StringBuffer sb = new StringBuffer();
		if (map != null) {
			for (String key : map.keySet()) {
				Object mapObj = map.get(key);
				if (mapObj instanceof Map) {
					sb.append("<" + key + ">"
							+ map2XmlStringForSoap((Map) mapObj) + "</" + key
							+ ">");
				} else if (mapObj instanceof List) {
					sb.append("<" + key + ">"
							+ mapList2XmlStringForSoap((List) mapObj) + "</"
							+ key + ">");
				} else {
					sb.append("<" + key + ">" + map.get(key) + "</" + key + ">");
				}

			}
		}
		return sb.toString();
	}

	/**
	 * 将list对象转化为 xml字符串
	 * 
	 * @param mapList
	 * @author wu.chen 2016.6.12
	 */
	public static String mapList2XmlStringForSoap(
			List<Map<String, Object>> mapList) {
		StringBuffer sb = new StringBuffer();
		if (mapList != null) {
			for (Map<String, Object> map : mapList) {
				sb.append(map2XmlStringForSoap(map));
			}
		}
		return sb.toString();
	}

	/**
	 * 将list对象转化为 xml字符串,并增加一个Entity
	 * 
	 * @param mapList
	 * @author wu.chen 2016.6.12
	 */
	public static String mapList2XmlStringAddEntity(
			List<Map<String, Object>> mapList) {
		StringBuffer sb = new StringBuffer();
		if (mapList != null) {
			for (Map<String, Object> map : mapList) {
				sb.append("<Entity>" + map2XmlStringForSoap(map) + "</Entity>");
			}
		}
		return sb.toString();
	}

	/*public static void main(String[] args) {
		String a = "<string xmlns=\"http://tempuri.org/\"><Model_ID>CGH0124A0058</Model_ID><Model_ID>CGH0124A0057</Model_ID><Year>2010</Year><Check>E0</Check><CXDM>HG7241AB</CXDM><FDJXH>K24Z2</FDJXH></string>";
		try {
			System.out.println(XmlUtils.xml2map(a).get("Model_ID").getClass()
					.getCanonicalName());
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 * List<Map<String, String>> WorkTypeSettingsMapList =
		 * Lists.newArrayList(); Map<String, String> WorkTypeSettingsMap = new
		 * HashMap<String, String>(); WorkTypeSettingsMap.put("WorkType",
		 * "Mechanical"); WorkTypeSettingsMap.put("Price", "decimal");
		 * WorkTypeSettingsMapList.add(WorkTypeSettingsMap); Map<String, String>
		 * WorkTypeSettingsMap1 = new HashMap<String, String>();
		 * WorkTypeSettingsMap1.put("WorkdType", "Mechanical");
		 * WorkTypeSettingsMap1.put("Price", "decimal");
		 * WorkTypeSettingsMapList.add(WorkTypeSettingsMap1); Map<String,
		 * Object> topMap = new HashMap<String, Object>(); topMap.put("topMap",
		 * WorkTypeSettingsMapList);
		 * System.out.println(XmlUtils.parseToXMLString(topMap));
		 

	}*/
}
