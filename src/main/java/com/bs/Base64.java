package com.bs;

/**
 * <p>
 * Project: Tryspring-boot
 * </p>
 *
 * <p>
 * Function: [功能模块：]
 * </p>
 *
 * <p>
 * Description: [功能描述：]
 * </p>
 *
 * <p>
 * Copyright: Copyright(c) 2013-2022 税友集团
 * </p>
 *
 * <p>
 * Company: 税友软件集团有限公司
 * </p>
 *
 * @author xbo
 * @version 1.0
 * @date 2021/1/14
 */

public final class Base64 {
    static private final int BASELENGTH = 255;
    static private final int LOOKUPLENGTH = 64;
    static private final int TWENTYFOURBITGROUP = 24;
    static private final int EIGHTBIT = 8;
    static private final int SIXTEENBIT = 16;
    static private final int SIXBIT = 6;
    static private final int FOURBYTE = 4;
    static private final int SIGN = -128;
    static private final byte PAD = (byte) '=';
    static private byte[] base64Alphabet = new byte[BASELENGTH];
    static private byte[] lookUpBase64Alphabet = new byte[LOOKUPLENGTH];

    static {
        for (int i = 0; i < BASELENGTH; i++) {
            base64Alphabet[i] = -1;
        }
        for (int i = 'Z'; i >= 'A'; i--) {
            base64Alphabet[i] = (byte) (i - 'A');
        }
        for (int i = 'z'; i >= 'a'; i--) {
            base64Alphabet[i] = (byte) (i - 'a' + 26);
        }
        for (int i = '9'; i >= '0'; i--) {
            base64Alphabet[i] = (byte) (i - '0' + 52);
        }

        base64Alphabet['+'] = 62;
        base64Alphabet['/'] = 63;

        for (int i = 0; i <= 25; i++) {
            lookUpBase64Alphabet[i] = (byte) ('A' + i);

        }
        for (int i = 26, j = 0; i <= 51; i++, j++) {
            lookUpBase64Alphabet[i] = (byte) ('a' + j);

        }
        for (int i = 52, j = 0; i <= 61; i++, j++) {
            lookUpBase64Alphabet[i] = (byte) ('0' + j);

        }
        lookUpBase64Alphabet[62] = (byte) '+';
        lookUpBase64Alphabet[63] = (byte) '/';
    }

    private static boolean isBase64(String isValidString) {
        return isArrayByteBase64(isValidString.getBytes());
    }

    private static boolean isBase64(byte octect) {
        //shall we ignore white space? JEFF??
        return (octect == PAD || base64Alphabet[octect] != -1);
    }

    private static boolean isArrayByteBase64(byte[] arrayOctect) {
        int length = arrayOctect.length;
        if (length == 0) {
            // shouldn't a 0 length array be valid base64 data?
            // return false;
            return true;
        }
        for (int i = 0; i < length; i++) {
            if (!Base64.isBase64(arrayOctect[i])) {
                return false;
            }
        }
        return true;
    }

    /**
     * �Դ��ݵ��ַ�������Base64����,���ر������ַ���.
     *
     * @param strData containing binary data to encode.
     * @return Base64-encoded data.
     */
    public static String encode(String strData) {
        return new String(encode(strData.getBytes()));
    }

    /**
     * �Դ��ݵĶ������ֽ��������Base64����,���ر������ַ���.
     *
     * @param binaryData
     * @return
     */
    public static String encodeToString(byte[] binaryData) {
        return new String(encode(binaryData));
    }

    /**
     * �Դ��ݵĶ������ֽ��������Base64����,���ر������ֽ�����.
     *
     * @param binaryData
     * @return
     */
    public static byte[] encode(byte[] binaryData) {
        int lengthDataBits = binaryData.length * EIGHTBIT;
        int fewerThan24bits = lengthDataBits % TWENTYFOURBITGROUP;
        int numberTriplets = lengthDataBits / TWENTYFOURBITGROUP;
        byte encodedData[] = null;

        if (fewerThan24bits != 0) {
            //data not divisible by 24 bit
            encodedData = new byte[(numberTriplets + 1) * 4];
        } else {
            // 16 or 8 bit
            encodedData = new byte[numberTriplets * 4];
        }

        byte k = 0, l = 0, b1 = 0, b2 = 0, b3 = 0;

        int encodedIndex = 0;
        int dataIndex = 0;
        int i = 0;
        for (i = 0; i < numberTriplets; i++) {
            dataIndex = i * 3;
            b1 = binaryData[dataIndex];
            b2 = binaryData[dataIndex + 1];
            b3 = binaryData[dataIndex + 2];

            l = (byte) (b2 & 0x0f);
            k = (byte) (b1 & 0x03);

            encodedIndex = i * 4;
            byte val1 = ((b1 & SIGN) == 0) ? (byte) (b1 >> 2) :
                    (byte) ((b1) >> 2 ^ 0xc0);
            byte val2 = ((b2 & SIGN) == 0) ? (byte) (b2 >> 4) :
                    (byte) ((b2) >> 4 ^ 0xf0);
            byte val3 = ((b3 & SIGN) == 0) ? (byte) (b3 >> 6) :
                    (byte) ((b3) >> 6 ^ 0xfc);

            encodedData[encodedIndex] = lookUpBase64Alphabet[val1];
            encodedData[encodedIndex + 1] =
                    lookUpBase64Alphabet[val2 | (k << 4)];
            encodedData[encodedIndex + 2] =
                    lookUpBase64Alphabet[(l << 2) | val3];
            encodedData[encodedIndex + 3] = lookUpBase64Alphabet[b3 & 0x3f];
        }

        // form integral number of 6-bit groups
        dataIndex = i * 3;
        encodedIndex = i * 4;
        if (fewerThan24bits == EIGHTBIT) {
            b1 = binaryData[dataIndex];
            k = (byte) (b1 & 0x03);
            byte val1 = ((b1 & SIGN) == 0) ? (byte) (b1 >> 2) :
                    (byte) ((b1) >> 2 ^ 0xc0);
            encodedData[encodedIndex] = lookUpBase64Alphabet[val1];
            encodedData[encodedIndex + 1] = lookUpBase64Alphabet[k << 4];
            encodedData[encodedIndex + 2] = PAD;
            encodedData[encodedIndex + 3] = PAD;
        } else if (fewerThan24bits == SIXTEENBIT) {

            b1 = binaryData[dataIndex];
            b2 = binaryData[dataIndex + 1];
            l = (byte) (b2 & 0x0f);
            k = (byte) (b1 & 0x03);

            byte val1 = ((b1 & SIGN) == 0) ? (byte) (b1 >> 2) :
                    (byte) ((b1) >> 2 ^ 0xc0);
            byte val2 = ((b2 & SIGN) == 0) ? (byte) (b2 >> 4) :
                    (byte) ((b2) >> 4 ^ 0xf0);

            encodedData[encodedIndex] = lookUpBase64Alphabet[val1];
            encodedData[encodedIndex + 1] =
                    lookUpBase64Alphabet[val2 | (k << 4)];
            encodedData[encodedIndex + 2] = lookUpBase64Alphabet[l << 2];
            encodedData[encodedIndex + 3] = PAD;
        }

        return encodedData;
    }

    /**
     * ��������ַ�������Base64����,���ؽ������ֽ�����
     *
     * @param base64Data Byte array containing Base64 data
     * @return Array containing decoded data.
     */
    public static byte[] decode(String base64Data) {
        return decode(base64Data.getBytes());
    }

    /**
     * ��������ֽ��������Base64����,���ؽ������ֽ�����
     *
     * @param base64Data
     * @return
     */
    public static byte[] decode(byte[] base64Data) {
        // handle the edge case, so we don't have to worry about it later
        if (base64Data.length == 0) {
            return new byte[0];
        }

        int numberQuadruple = base64Data.length / FOURBYTE;
        byte decodedData[] = null;
        byte b1 = 0, b2 = 0, b3 = 0, b4 = 0, marker0 = 0, marker1 = 0;

        // Throw away anything not in base64Data

        int encodedIndex = 0;
        int dataIndex = 0;
        {
            // this sizes the output array properly - rlw
            int lastData = base64Data.length;
            // ignore the '=' padding
            while (base64Data[lastData - 1] == PAD) {
                if (--lastData == 0) {
                    return new byte[0];
                }
            }
            decodedData = new byte[lastData - numberQuadruple];
        }

        for (int i = 0; i < numberQuadruple; i++) {
            dataIndex = i * 4;
            marker0 = base64Data[dataIndex + 2];
            marker1 = base64Data[dataIndex + 3];

            b1 = base64Alphabet[base64Data[dataIndex]];
            b2 = base64Alphabet[base64Data[dataIndex + 1]];

            if (marker0 != PAD && marker1 != PAD) {
                //No PAD e.g 3cQl
                b3 = base64Alphabet[marker0];
                b4 = base64Alphabet[marker1];

                decodedData[encodedIndex] = (byte) (b1 << 2 | b2 >> 4);
                decodedData[encodedIndex + 1] =
                        (byte) (((b2 & 0xf) << 4) | ((b3 >> 2) & 0xf));
                decodedData[encodedIndex + 2] = (byte) (b3 << 6 | b4);
            } else if (marker0 == PAD) {
                //Two PAD e.g. 3c[Pad][Pad]
                decodedData[encodedIndex] = (byte) (b1 << 2 | b2 >> 4);
            } else if (marker1 == PAD) {
                //One PAD e.g. 3cQ[Pad]
                b3 = base64Alphabet[marker0];

                decodedData[encodedIndex] = (byte) (b1 << 2 | b2 >> 4);
                decodedData[encodedIndex + 1] =
                        (byte) (((b2 & 0xf) << 4) | ((b3 >> 2) & 0xf));
            }
            encodedIndex += 3;
        }
        return decodedData;
    }

   /* public static void main(String[] args) throws Exception {
        byte[] str = null;
        byte[] bytes = FileUtil.readFileToBytes("C:\\temp\\cert\\b\\publicKey.dat");
        FileUtil.writeFile("C:\\temp\\usercert.txt", Base64.encodeToString(bytes));

//    if (args.length > 0) {

//      str = SysFun.readFileByte("c:/","logo.gif");
//    }
        //  System.out.println("Encoding string [" + str + "]");
//    long l = System.currentTimeMillis();
//    byte[] s_str2 = null;
//     String s_str = null;
//    try {
//      for (int i = 0; i < 10; i++) {
//        s_str = new String(encode(str));
//        s_str2 = decode(s_str);
//      }
//      System.out.println(s_str);
//      java.io.FileOutputStream file = new java.io.FileOutputStream("c:/out.gif");
//      file.write(s_str2);
//
//    }
//    catch (Exception ex) {
//    }
//    long l2 = System.currentTimeMillis();
//    System.out.println(l2-l);
        // System.out.println("Encoding string [" + str + "]");
//    System.out.println("Encoded string  [" + str + "]");
//    str = decode(str);
//    System.out.println("Decoded string  [" + str + "]");
//    System.out.println();

    }*/


}
