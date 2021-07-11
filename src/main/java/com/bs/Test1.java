package com.bs;

public class Test1 {

    public static char DELIM_QUOTE = '\'';

    /**
     * the percent character
     */
    public static char DELIM_PERCENT = '%';

    /**
     * the underbar character
     */
    public static char DELIM_UNDERBAR = '_';

    /**
     * the seperate character
     */
    public static char DELIM_SEP = '\\';

    /**
     * the quote character in MessageFormat
     */
    public static String REP_QUOTE = "''";

    /**
     * the percent character in MessageFormat
     */
    public static String REP_PERCENT = "\\%";

    /**
     * the underbar character in MessageFormat
     */
    public static String REP_UNDERBAR = "\\_";

    /**
     * the seperate character in MessageFormat
     */
    public static String REP_SEP = "\\\\";

    private static String xx = "2233";

    public static void main(String[] args) {
        String s = "T.DZSPHM NOT IN (SELECT T.DZSPHM FROM WS_DZDKSKJBD T WHERE T.DJXH = 10114403000026242515,  AND T.RKRQ BETWEEN NVL(TO_DATE(\"2019-11-01', YYYY-MM-DD'), T.RKRQ) AND NVL(TO_DATE('2019-11-20', 'YYYY-MM-DD'), T.RKRQ) AND T.SKSSQQ >= NVL(TO_DATE('', 'YYYY-MM-DD'), T.SKSSQQ) AND T.SKSSQZ <= NVL(TO_DATE('', 'YYYY-MM-DD'), T.SKSSQZ)";

        String rr = analyseString(s);
        System.out.println(rr);    }


    private static String analyseString(String s,
                                        char[] delims, String[] reps) {
        if (s == null
                || delims == null
                || reps == null || delims.length != reps.length) {
            return null;
        }
        StringBuffer result = new StringBuffer();
        for (int k = 0, j = 0, i = 0; i < s.length(); i++, j++) {
            char c = s.charAt(i);
            k = contains(c, delims);
            if (k >= 0) {
                result.append(reps[k]);
            }
            else {
                result.append(c);
            }
        }
        return new String(result);
    }

    private static int contains(char c, char[] delims) {
        for (int i = 0; i < delims.length; i++) {
            if (delims[i] == c) {
                return i;
            }
        }
        return -1;
    }

    public static String analyseString(String s) {
        char[] delim = {
                DELIM_QUOTE
        };
        String[] reps = {
                REP_QUOTE
        };
        return analyseString(s, delim, reps);
    }

}
