package com.ftx.http;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class HttpUtil {

	private static Log log = LogFactory.getLog(HttpUtil.class);
	
	    /**
     *
     * @Title doPost 对参数进行URLEncoder
     * @Description post请求
     * @param requestUrl url
     * @param paramMap 请求参数
     * @param headerMap head参数
     * @return String
     */
	public static String doPost(String requestUrl, Map<String, String> paramMap, Map<String, String> headerMap) {
		URL url = null;
		HttpURLConnection httpurlconnection = null;
		InputStream ins = null;
		OutputStream outPutStream = null;
		try {
			url = new URL(requestUrl);
            // 获取一个HttpURLConnection链接对象
			httpurlconnection = (HttpURLConnection) url.openConnection();
            // 设置超时时间
			httpurlconnection.setConnectTimeout(600000);
			httpurlconnection.setReadTimeout(600000);

			httpurlconnection.setUseCaches(false);
			httpurlconnection.setDoInput(true);
			httpurlconnection.setDoOutput(true);
			httpurlconnection.setRequestMethod("POST");
            // 添加头部参数
			if (headerMap != null && !headerMap.isEmpty()) {
				for (Entry<String, String> header : headerMap.entrySet()) {
					httpurlconnection.addRequestProperty(header.getKey(), header.getValue());
				}
			}
            // 添加请求参数
			if (paramMap != null && !paramMap.isEmpty()) {
				StringBuilder sb = new StringBuilder("");
				for (Entry<String, String> param : paramMap.entrySet()) {
					sb.append("&").append(param.getKey()).append("=")
							.append(URLEncoder.encode(param.getValue(), "UTF-8"));
				}
				outPutStream = httpurlconnection.getOutputStream();
				outPutStream.write(sb.toString().getBytes("UTF-8"));
			}

            // 接口调用后获得输入流
			ins = httpurlconnection.getInputStream();

			byte[] responseData = read(ins);
			return new String(responseData, "UTF-8");
		} catch (Exception e) {
            log.error("http请求发送失败", e);
		} finally {
			if (httpurlconnection != null) {
				httpurlconnection.disconnect();
			}
			try {
				if (outPutStream != null) {
					outPutStream.flush();
				}
				if (outPutStream != null) {
					outPutStream.close();
				}
				if (ins != null) {
					ins.close();
				}
			} catch (IOException e) {
				log.error(e);
			}
		}
		return "";
	}
	public static String doGet(String requestUrl) {
		URL url = null;
		HttpURLConnection httpurlconnection = null;
		try {
			url = new URL(requestUrl);
            // 获取一个HttpURLConnection链接对象
			httpurlconnection = (HttpURLConnection) url.openConnection();
			httpurlconnection.setRequestMethod("GET");
			httpurlconnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            // 设置超时时间
			httpurlconnection.setConnectTimeout(30000);
			httpurlconnection.setReadTimeout(30000);
			//防止服务器默认的跳转。
//			httpurlconnection.setInstanceFollowRedirects(false);

			httpurlconnection.setUseCaches(false);
			httpurlconnection.setDoInput(true);
            // 接口调用后获得输入流
			InputStream ins = httpurlconnection.getInputStream();
			byte[] responseData = read(ins);
			ins.close();
			return new String(responseData, "UTF-8");
		} catch (Exception e) {
            log.error("http请求发送失败", e);
		} finally {
			if (httpurlconnection != null) {
				httpurlconnection.disconnect();
			}
		}
		return "";
	}


	public static String doGet(String requestUrl, String cookie) {
		URL url = null;
		HttpURLConnection httpurlconnection = null;
		try {
			url = new URL(requestUrl);
			// 获取一个HttpURLConnection链接对象
			httpurlconnection = (HttpURLConnection) url.openConnection();
			httpurlconnection.setRequestMethod("GET");
			httpurlconnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			// 设置超时时间
			httpurlconnection.setConnectTimeout(30000);
			httpurlconnection.setReadTimeout(30000);
			//防止服务器默认的跳转。
//			httpurlconnection.setInstanceFollowRedirects(false);
			if(!StringUtils.isEmpty(cookie)){
				httpurlconnection.setRequestProperty("Cookie","DZSWJ_TGC="+cookie);
			}
			httpurlconnection.setUseCaches(false);
			httpurlconnection.setDoInput(true);
			// 接口调用后获得输入流
			InputStream ins = httpurlconnection.getInputStream();
			byte[] responseData = read(ins);
			ins.close();
			return new String(responseData, "UTF-8");
		} catch (Exception e) {
			log.error("http请求发送失败", e);
		} finally {
			if (httpurlconnection != null) {
				httpurlconnection.disconnect();
			}
		}
		return "";
	}



	public Map<String, Object> weixinUrl(String requestUrl) {
		URL url = null;
		HttpURLConnection httpurlconnection = null;
		Map map = new HashMap();
		try {
			url = new URL(requestUrl);
            // 获取一个HttpURLConnection链接对象
			httpurlconnection = (HttpURLConnection) url.openConnection();
			httpurlconnection.setRequestMethod("POST");
            // 设置超时时间
			httpurlconnection.setConnectTimeout(30000);
			httpurlconnection.setReadTimeout(30000);

			httpurlconnection.setDoInput(true);
            // 接口调用后获得输入流
			InputStream ins = httpurlconnection.getInputStream();
			byte[] dzzlData = read(ins);
            log.info("获取的输出流为：" + dzzlData.length);
            // log.info("获取的输出流类型为：" + httpurlconnection.getHeaderField("Content-Type"));
            //log.info("获取的输出流类型为：" + CommonUtil.vaildLog(httpurlconnection.getHeaderField("Content-Type")));
            // log.info("获取的输出流类型为：" + httpurlconnection.getContentType());
            //log.info("获取的输出流类型为：" + CommonUtil.vaildLog(httpurlconnection.getContentType()));
            log.info("获取的返回值为：" + httpurlconnection.getResponseCode());
			Map<String, byte[]> byteMap = new HashMap<String, byte[]>();
			byteMap.put("dzzlData", dzzlData);
			map.put("dzzl", byteMap);
			map.put("contentType", httpurlconnection.getContentType());
			map.put("fileType", httpurlconnection.getHeaderField("Content-Type"));
			map.put("responseCode", httpurlconnection.getResponseCode());
			ins.close();
			return map;
		} catch (Exception e) {
		} finally {
			if (httpurlconnection != null) {
				httpurlconnection.disconnect();
			}
		}
		return map;
	}

    // 微信用的，，太恶心，，下次别用了，，
	public Map<String, Object> invokeWxUrl(String requestUrl) {
		Map map = null;
		for (int i = 0; i < 10; i++) {
			map = this.weixinUrl(requestUrl);
            // log.info("Map：" + map);
            //log.info(CommonUtil.vaildLog("Map：" + map));
            // log.info("Map中contentType：" + map.get("contentType"));
            //log.info(CommonUtil.vaildLog("Map中contentType：" + map.get("contentType")));
			if ("image/jpeg".equals(map.get("contentType"))) {
				return map;
			}
		}
		return null;
	}

	    /**
     *
     * @Title doPost 对参数进行URLEncoder
     * @Description post请求
     * @param requestUrl url
     * @param json 请求参数
     * @return String
     */
	public static byte[] weixinPost(String requestUrl,  String json) {
		URL url = null;
		HttpURLConnection httpurlconnection = null;
		OutputStream outPutStream = null;
		InputStream ins = null;
		try {
			url = new URL(requestUrl);
            // 获取一个HttpURLConnection链接对象
			httpurlconnection = (HttpURLConnection) url.openConnection();
			httpurlconnection.setRequestMethod("POST");
			httpurlconnection.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
            // 设置超时时间
			httpurlconnection.setConnectTimeout(600000);
			httpurlconnection.setReadTimeout(600000);

			httpurlconnection.setUseCaches(false);
			httpurlconnection.setDoInput(true);
			httpurlconnection.setDoOutput(true);
            // 添加请求参数
			if (!StringUtils.isEmpty(json)) {
				outPutStream = httpurlconnection.getOutputStream();
				outPutStream.write(json.getBytes("UTF-8"));

			}

            // 接口调用后获得输入流
			ins = httpurlconnection.getInputStream();
			byte[] responseData = read(ins);
            log.info("获取的输出流为：" + responseData.length);
            // log.info("获取的输出流类型为：" + httpurlconnection.getHeaderField("Content-Type"));
            //log.info("获取的输出流类型为：" + CommonUtil.vaildLog(httpurlconnection.getHeaderField("Content-Type")));
            // log.info("获取的输出流类型为：" + httpurlconnection.getContentType());
            //log.info("获取的输出流类型为：" + CommonUtil.vaildLog(httpurlconnection.getContentType()));
            log.info("获取的返回值为：" + httpurlconnection.getResponseCode());
            // log.info("获取的数据为：" + new String(responseData, "UTF-8"));
            //log.info("获取的数据为：" + CommonUtil.vaildLog(new String(responseData, "UTF-8")));

			return responseData;
		} catch (Exception e) {
            log.error("http请求发送失败", e);
		} finally {
			if (httpurlconnection != null) {
				httpurlconnection.disconnect();
			}

			try {
				if (outPutStream != null) {
					outPutStream.flush();
				}
				if (outPutStream != null) {
					outPutStream.close();
				}
				if (ins != null) {
					ins.close();
				}
			} catch (IOException e) {
				log.error(e);
			}
		}
		return null;
	}

	    /**
     * 
     * @Title doPost
     * @Description post请求
     * @param requestUrl
     *            url
     * @param json
     *            请求参数josn串
     * @return String
     */
	public static String doPost(String requestUrl, String json) {
		URL url = null;
		HttpURLConnection httpurlconnection = null;
		//log.info("requestUrl===" + requestUrl);
		//log.info("requestUrl===" + CommonUtil.vaildLog(requestUrl));
		OutputStream outPutStream = null;
		InputStream ins = null;
		try {
			url = new URL(requestUrl);
            // 获取一个HttpURLConnection链接对象
			httpurlconnection = (HttpURLConnection) url.openConnection();
            // 设置超时时间
			httpurlconnection.setConnectTimeout(600000);
			httpurlconnection.setReadTimeout(600000);

			httpurlconnection.setUseCaches(false);
			httpurlconnection.setDoInput(true);
			httpurlconnection.setDoOutput(true);
			httpurlconnection.setRequestMethod("POST");
			httpurlconnection.addRequestProperty("Content-Type", "application/json");
            // 添加头部参数
			/*
			 * if (headerMap != null && !headerMap.isEmpty()) { for
			 * (Entry<String, String> header : headerMap.entrySet()) {
			 * httpurlconnection.addRequestProperty(header.getKey(),
			 * header.getValue()); } }
			 */
            // 添加请求参数
			if (!StringUtils.isEmpty(json)) {
				outPutStream = httpurlconnection.getOutputStream();
				outPutStream.write(json.getBytes("UTF-8"));
			}

            // 接口调用后获得输入流
			ins = httpurlconnection.getInputStream();

			byte[] responseData = read(ins);
			return new String(responseData, "UTF-8");
		} catch (Exception e) {
            log.error("http请求发送失败", e);
		} finally {
			if (httpurlconnection != null) {
				httpurlconnection.disconnect();
			}
			try {
				if (outPutStream != null) {
					outPutStream.flush();
				}
				if (outPutStream != null) {
					outPutStream.close();
				}
				if (ins != null) {
					ins.close();
				}
			} catch (IOException e) {
				log.error(e);
			}
		}
		return "";
	}

	    /**
     * https调用腾讯的征信接口进行实名认证
     * @param requestURL
     * @param params
     * @param fileInputStream
     * @param fieldName
     * @param fileName
     * @return
     */
	/*public static String sendPost4TencentHttpsFile(String requestURL,String params,InputStream fileInputStream,String fieldName,String fileName) throws Exception {
        String boundary = UUID.randomUUID().toString(); // 边界标识 随机生成
		String prefix = "--", end = "\r\n";
        String content_type = "multipart/form-data"; // 内容类型
        String CHARSET = "utf-8"; // 设置编码
        int TIME_OUT = 10 * 10000000; // 超时时间
		BufferedReader in = null;
		String result = "";
        // 创建SSLContext对象，并使用我们指定的信任管理器初始化
		OutputStream outputSteam = null;
		try {
			TrustManager[] tm = { new MyX509TrustManager() };
			SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
			sslContext.init(null, tm, new java.security.SecureRandom());
            // 从上述SSLContext对象中得到SSLSocketFactory对象
			SSLSocketFactory ssf = sslContext.getSocketFactory();
            // log.info("==================================开始调用腾讯征信接口，接收参数为：" + params);
            log.info("==================================开始调用腾讯征信接口，接收参数为：" + CommonUtil.vaildLog(params));
			URL url = new URL(requestURL + "?" + params);
			HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
			conn.setSSLSocketFactory(ssf);
			conn.setReadTimeout(TIME_OUT);
			conn.setConnectTimeout(TIME_OUT);
            conn.setDoInput(true); // 允许输入流
            conn.setDoOutput(true); // 允许输出流
            conn.setUseCaches(false); // 不允许使用缓存
            conn.setRequestMethod("POST"); // 请求方式
            conn.setRequestProperty("Charset", "utf-8"); // 设置编码
			conn.setRequestProperty("connection", "keep-alive");
			conn.setRequestProperty("Content-Type", content_type + ";boundary=" + boundary);
			conn.setRequestProperty("Accept-Charset", "utf-8");
			conn.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.8");
			            *//**
             * 当文件不为空，把文件包装并且上传
             *//*
			outputSteam = conn.getOutputStream();
			DataOutputStream dos = new DataOutputStream(outputSteam);
		              *//*
             * 上传多个文件的时候，文件需要一个一个写，加上分隔符(上传多个图片的时候加上)
             * StringBuffer stringBuffer = new StringBuffer();
             * stringBuffer.append(prefix);
             * stringBuffer.append(boundary);
             * stringBuffer.append(end);
             * dos.write(stringBuffer.toString().getBytes());
             * dos.writeBytes("Content-Disposition: form-data; name=\"" + fieldName + "\""+ end);
             * dos.writeBytes(end);
             * dos.writeBytes("uploadFile");
             * dos.writeBytes(end);
             *//*

			StringBuffer sb = new StringBuffer();
			sb.append(prefix);
			sb.append(boundary);
			sb.append(end);
			            *//**
             * 这里重点注意： name里面的值为服务器端需要key 只有这个key 才可以得到对应的文件
             * filename是文件的名字，包含后缀名的 比如:abc.png
             *//*
			sb.append(
					"Content-Disposition: form-data; name=\"" + fieldName + "\"; filename=\"" + fileName + "\"" + end);
			sb.append("Content-Type: application/octet-stream; charset=" + CHARSET + end);
			sb.append(end);
			dos.write(sb.toString().getBytes());
			SysUtil.writeStream(fileInputStream, dos);
            dos.write(end.getBytes());// 一个文件结束标志
            byte[] end_data = (prefix + boundary + prefix + end).getBytes();// 结束 http 流
			dos.write(end_data);
			dos.flush();
            dos.close();
            // 定义BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
			String line = "";
			while ((line = in.readLine()) != null) {
				result += line;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (outputSteam != null) {
				outputSteam.close();
			}
		}
		return result;
	}*/

	    /**
     * 发起https请求并获取结果
     *
     * @param requestUrl 请求地址
     * @param requestMethod 请求方式（GET、POST）
     * @param outputStr 提交的数据
     * @return JSONObject(通过JSONObject.get(key)的方式获取json对象的属性值)
     */
	/*public static String httpRequest(String requestUrl, String requestMethod, String outputStr) {
		StringBuffer buffer = new StringBuffer();
		try {
			TrustManager[] tm = { new MyX509TrustManager() };
			SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
			sslContext.init(null, tm, new java.security.SecureRandom());
            // 从上述SSLContext对象中得到SSLSocketFactory对象
			SSLSocketFactory ssf = sslContext.getSocketFactory();
            // 打开连接
			URL url = new URL(requestUrl);
			HttpsURLConnection httpUrlConn = (HttpsURLConnection) url.openConnection();
			httpUrlConn.setSSLSocketFactory(ssf);
			httpUrlConn.setDoOutput(true);
			httpUrlConn.setDoInput(true);
			httpUrlConn.setUseCaches(false);
            // 设置请求方式（GET/POST）
			httpUrlConn.setRequestMethod(requestMethod);
			if ("GET".equalsIgnoreCase(requestMethod)){
				httpUrlConn.connect();
			}
            // 当有数据需要提交时
			if (null != outputStr) {
				OutputStream outputStream = httpUrlConn.getOutputStream();
                // 注意编码格式，防止中文乱码
				outputStream.write(outputStr.getBytes("UTF-8"));
				outputStream.close();
			}
            // 将返回的输入流转换成字符串
			InputStream inputStream = httpUrlConn.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			String str = null;
			while ((str = bufferedReader.readLine()) != null) {
				buffer.append(str);
			}
			bufferedReader.close();
			inputStreamReader.close();
            // 释放资源
			inputStream.close();
			inputStream = null;
			httpUrlConn.disconnect();
		} catch (ConnectException ce) {
            log.error("========================https获取腾讯征信流水号请求超时========================");
		} catch (Exception e) {
            log.error("========================https获取腾讯征信流水号请求失败========================", e);
		}
		return buffer.toString();
	}*/

	    /**
     * 时时获取腾讯征信实名认证交易流水号
     * @return
     * @throws Exception
     */
	/*public static Map<String, String> getZxSeqNo() throws Exception {
		String Code = "uin="+WxSmRzUtil.APPID+"&time=" + System.currentTimeMillis();
		byte[] codE = AESPlus.encrypt(ResourceConfig.getAppZxkey(), Code);
		String scodE = AESPlus.getBcdStr(codE);
		String seq_no_str = "ent_no="+ResourceConfig.getAppZxEntNo()+"&req_data=" + scodE;
		String ZxSeqNoMap = HttpUtil.httpRequest(SmrzConstants.APP_ZX_SEQURL, "GET", seq_no_str);
        // log.error("========================https获取腾讯征信流水号为========================"+ZxSeqNoMap);
        log.error("========================https获取腾讯征信流水号为========================" + CommonUtil.vaildLog(ZxSeqNoMap));
		Map<String, String> zxSeqNoMap = JsonUtil.getMapForJson(ZxSeqNoMap);
		return zxSeqNoMap;
	}*/

		public static byte[] read(InputStream inputStream) throws IOException {
			try {
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				byte[] buffer = new byte[1024];
				int num = inputStream.read(buffer);
				while (num != -1) {
					baos.write(buffer, 0, num);
					num = inputStream.read(buffer);
				}
				baos.flush();
				return baos.toByteArray();
			} finally {
				if (inputStream != null) {
					inputStream.close();
				}
			}
		}
}