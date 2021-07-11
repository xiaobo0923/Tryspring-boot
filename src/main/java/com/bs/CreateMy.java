/*
package com.bs;

import com.itextpdf.text.pdf.BarcodeQRCode;
import com.swetake.util.Qrcode;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class CreateMy {


    public static void main(String[] args) {
        */
/*byte[] strbyte = new String("ddjctest").getBytes();
        byte[] md5data = SecurityUtil.getMD5Digest(strbyte);
        Base64.encodeToString(md5data);
        System.out.println(Base64.encodeToString(md5data));*//*

        */
/*byte[] md5data = MD5Util.md5("yxxt2020",true).getBytes();
        System.out.println("转之后："+Base64.encodeToString(md5data));*//*

        try {
            String content = "123,abc,oo";
            BarcodeQRCode pdf417 = new BarcodeQRCode(content, 300, 300, null);
            // 生成二维码图像
            Image image128 = pdf417.getImage();
            image128.scalePercent(50);
            System.out.println("1："+pdf417);
            System.out.println("2："+image128);
            System.out.println("3："+image128);



            */
/*BarcodePDF417 barcodePDF417 = new BarcodePDF417();

            barcodePDF417.setText(content.getBytes("UTF-8"));

            java.awt.Image pdfImg = barcodePDF417.createAwtImage(Color.black, Color.white);
            BufferedImage img = new BufferedImage((int) pdfImg.getWidth(null),
                    (int) pdfImg.getHeight(null), BufferedImage.TYPE_INT_RGB);
            Graphics g = img.getGraphics();

            g.drawImage(pdfImg, 0, 0, Color.white, null);
*//*

            //ImageIO.write(img, "jpg",new File("C:\\Users\\xbo92\\Desktop\\123.jpg"));
            */
/*ByteArrayOutputStream os = new ByteArrayOutputStream();


            byte[] buffs = os.toByteArray();

            ImageIO.write(img, "JPG", os);
            os.close();*//*


            Qrcode handler = new Qrcode();
            handler.setQrcodeErrorCorrect('M');
            handler.setQrcodeEncodeMode('B');
            handler.setQrcodeVersion(9);

            byte[] contentBytes = content.getBytes("UTF-8");
            int imgSize = 67 + 12 * (9 - 1);// 设置图片大小
            BufferedImage bufImg = new BufferedImage(imgSize, imgSize, BufferedImage.TYPE_INT_RGB);
            Graphics2D gs = bufImg.createGraphics();
            gs.setBackground(Color.WHITE);
            gs.clearRect(0, 0, imgSize, imgSize);
            // 设定图像颜色：BLACK
            gs.setColor(Color.BLACK);
            // 设置偏移量 不设置肯能导致解析出错
            int pixoff = 2;
            // 输出内容：二维码
            if (contentBytes.length > 0 && contentBytes.length < 200) {
                boolean[][] codeOut = handler.calQrcode(contentBytes);
                for (int i = 0; i < codeOut.length; i++) {
                    for (int j = 0; j < codeOut.length; j++) {
                        if (codeOut[j][i]) {
                            gs.fillRect(j * 3 + pixoff, i * 3 + pixoff, 3, 3);
                        }
                    }
                }
            } else {
            }
            gs.dispose();
            bufImg.flush();
            // 生成二维码QRCode图片
            ImageIO.write(bufImg, "jpg",new File("C:\\Users\\xbo92\\Desktop\\123.jpg"));

        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
*/
