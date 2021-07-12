package com.bs;

import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {
	public static String md5(String str, boolean zero) {
		MessageDigest messageDigest = null;
		try {
			messageDigest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException ex) {
			ex.printStackTrace();
			return null;
		}
		byte[] resultByte = messageDigest.digest(str.getBytes());

		try {
			String s = URLEncoder.encode(Base64.encodeToString(resultByte), "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}

		StringBuffer result = new StringBuffer();
		for (int i = 0; i < resultByte.length; ++i) {
			int v = 0xFF & resultByte[i];
			if (v < 16 && zero)
				result.append("0");
			result.append(Integer.toHexString(v));
		}

		return result.toString();
	}

	public static void main(String[] args) {
		try {
			byte[] md5data = MD5Util.md5("xbtc2020",true).getBytes();
			System.out.println("转之后："+Base64.encodeToString(md5data));

		}catch (Exception e){
			e.printStackTrace();
		}

	}
	
	/**
	 * 解析指定的标签值
	 * 
	 * @param mes
	 * @param start
	 * @param end
	 * @return
	 */
	public static String parseDataArea(String mes, String start, String end) {
		String dataArea;
		dataArea = null;
		int startNo = mes.indexOf(start);
		int endNo = mes.indexOf(end);
		try {
			dataArea = mes.substring(startNo + start.length(), endNo).trim();

		} catch (Exception s) {
			System.out.println(s);
		}
		return dataArea;
	}
	/*public static void main(String[] args) {
		
	System.out.println(md5("<body><nsrsbh>130102195701102174</nsrsbh><khmc>石家庄市长安隆盛糖酒综合经销部</khmc><jzbh>1192246059</jzbh><xzm>2015112011225429897</xzm><yzbz>0</yzbz><gmcj>0</gmcj><zslx>10001</zslx></body>",true));
		
	}*/

}
