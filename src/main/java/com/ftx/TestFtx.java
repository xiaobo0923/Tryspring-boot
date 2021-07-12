package com.ftx;

import com.bs.Base64;
import com.bs.MD5Util;
import com.ftx.http.HttpUtil;
import com.ftx.http.TcpUtil;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: xbo
 * @Description:
 * @Date: 2021/7/8 20:42
 */
public class TestFtx {

    static final HashMap<String, String> urlMap = new HashMap<>();

    static {
        urlMap.put("login","http://www.ftxgame.com/portal/portal/login");
        urlMap.put("player","http://static.ftxgame.com/data/player/get_all_player_data");
        urlMap.put("play","http://static.ftxgame.com/play");
    }


    @Test
    public void testq(){
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("accountId","270435527@qq.com");
        paramMap.put("password","592898147");
        String result = HttpUtil.doPost(urlMap.get("play"),paramMap,new HashMap<>());
        System.out.println(result);

    }

    @Test
    public void testTCP() {
        try {
            //创建Socket对象
            Socket socket = new Socket(InetAddress.getByName("47.112.135.152"), 3029);
            //获取输出流对象
            OutputStream os = socket.getOutputStream();
            //发送数据
            String str = "{\"ri\":\"1626082755792274\",\"d\":\"1626082755792\",\"si\":\"PKService.pkMainInfo\",\"rps\":{}}";
            os.write(str.getBytes());

            InputStream in = socket.getInputStream();
            ByteArrayOutputStream bytesOut = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len = -1;
            while((len=in.read(buffer)) != -1){
                bytesOut.write(buffer, 0, len);
            }
            /**
             * 解码TCP响应的完整报文
             */
            System.out.println(bytesOut.toString());

            //释放
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        /*String s = "{\"ri\":\"1626082760277320\",\"d\":\"1626082760277\",\"si\":\"PKService.pkUpdateManyPos\"," +
                "\"rps\":{\"type\":\"1\"}}";
        String str = "{\"ri\":\"1626082755792274\",\"d\":\"1626082755792\",\"si\":\"PKService.pkMainInfo\",\"rps\":{}}";
        Map<String, String> map = TcpUtil.sendTCPRequest("47.112.135.152","3029",str,"");*/
    }




}
