package com.bs;


import com.alibaba.fastjson.JSON;
import org.springframework.boot.configurationprocessor.json.JSONArray;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/**
 * <p>
 * Project: test
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
 * @date 2020/10/21
 */

public class OctTest {


public static class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }


        public static ListNode addtwonumbers(ListNode l1, ListNode l2) {
            //生成listnode链表对象，链表的值为0，没有指向的节点
            ListNode dummyhead = new ListNode(0);
            ListNode p = l1, q = l2, curr = dummyhead;
            //carry代表进位
            int carry = 0;
            while (p != null || q != null) {
//两个链表的同一位赋值给变量x和y
                int x = (p != null) ? p.val : 0;
                int y = (q != null) ? q.val : 0;
                int sum = carry + x + y;
                carry = sum / 10; //这里的carry循环时在上面这个式子用int sum = carry + x + y;
                curr.next = new ListNode(sum % 10);  //如果结果是两位数，各位数留在结果链表里
                curr = curr.next;
                if (p != null) p = p.next;
                if (q != null) q = q.next;
            }

//最后一位的进位，如果有进位，把进位放到下一个链表里
            if (carry > 0) {
                curr.next = new ListNode(carry);
            }
            return dummyhead.next;
        }


    public void testLinckListCode(){

        //创建两个链表
        //第一个链表: 1-> 8 -> 7 -> 6 (在做加法运算代表的是6781)
        ListNode l1 = new ListNode(3);
        //这是第一个链表的第一个节点(不能用这个节点去往下加数据)
        //必须有一个指针去往第一个节点上去加数据
        ListNode p = l1;
        //这个指针节点会从链表的第一个节点一直往下走(直至最后一个节点)
        p.next = new ListNode(4);
        p = p.next;
        p.next = new ListNode(2);

        //第二个链表
        ListNode l2 = new ListNode(5);
        ListNode q = l2;
        q.next = new ListNode(6);
        q = q.next;
        q.next = new ListNode(4);
        ListNode re = addtwonumbers(l1, l2);
        while(re != null)
        { System.out.println(re.val); re = re.next; }
    }


    public static int findPoisonedDuration(int[] timeSeries, int duration) {
        int sumTime  = 0;
        int  startTime = 0;//中毒开始时间（每次）
        int conTime = 0;//中毒持续时间（每次）
        /*for(int i = 0;i<timeSeries.length;i++){
            int k = timeSeries[i];
            //计算中毒持续时间是否已经结束
            if((startTime + conTime) < k){
                //现在是没有中毒的状态；
                startTime = k;
                conTime = duration;

            }else{
                //现在是已中毒的状态
                int leftTime = (startTime + conTime)-k;//计算剩余时间；
                startTime = leftTime + k;
                conTime = duration - leftTime;
            }
            sumTime += conTime;
        }*/
        for(int k : timeSeries){
            if((startTime + conTime) < k){
                //现在是没有中毒的状态；
                startTime = k;
                conTime = duration;

            }else{
                //现在是已中毒的状态
                int leftTime = (startTime + conTime)-k;//计算剩余时间；
                startTime = leftTime + k;
                conTime = duration - leftTime;
            }
            sumTime += conTime;
        }

        return sumTime;
    }

    public static void testFindPoisonedDuration(){
        int [] tt = {1,2};
        System.out.println(findPoisonedDuration(tt,2));

    }
    public static String validIPAddress1(String IP) {

        //IP 仅由英文字母，数字，字符 '.' 和 ':' 组成。
        /*
        *         String rexp = "([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}";
        Pattern pattern = Pattern.compile(rexp);
        Matcher matcher = pattern.matcher(ipAddress);
        return matcher.matches();
    }
        * */
        Pattern pattern ;
        if(IP.contains(":")){
            //ipv6
        }else{
            //ipv4
        }
        return null;
    }

    public String validIPAddress(String IP) {
        String[] IP4Arr = IP.split("\\.",-1);
        if(IP4Arr.length == 4){
            return isIP4Arr(IP4Arr);
        }

        String[] IP6Arr = IP.split(":",-1);
        if(IP6Arr.length == 8){
            return isIP6Arr(IP6Arr);
        }

        return "Neither";
    }

    public String isIP4Arr(String[] IP4Arr){
        for(String ip : IP4Arr){
            if(ip.length() > 3 || ip.length() <= 0){
                return "Neither";
            }
            for(int i = 0 ;i < ip.length();++i){
                if(!Character.isDigit(ip.charAt(i))){
                    return "Neither";
                }
            }
            int num = Integer.parseInt(ip);
            if(num > 255 || String.valueOf(num).length() != ip.length()){
                return "Neither";
            }
        }
        return "IPv4";
    }

    public String isIP6Arr(String[] IP6Arr){
        for(String ip : IP6Arr){
            if(ip.length() > 4 || ip.length() <= 0){
                return "Neither";
            }
            for(int i = 0 ;i < ip.length();++i){
                char c = ip.charAt(i);
                if(!Character.isDigit(c) && !( 'a' <= c && c <= 'f') && !('A' <= c && c <= 'F')){
                    return "Neither";
                }
            }
        }
        return "IPv6";
    }

    /**
     * 示例 1：
     *
     * 输入：[1,2,3,4]
     * 输出："23:41"
     * 示例 2：
     *
     * 输入：[5,5,5,5]
     * 输出：""
     * @param arr
     * @return
     */
    public String largestTimeFromDigits(int[] arr) {
        for(int i = 0;i<arr.length;i++){
            //把时间格式hh:mm看作两个字符串,两个两位数的数字。
            //第一位数字最大为24，第二位最大数字为59；
            int c = arr[i];
            //小时首位只能是0 1 2 ；分钟的首位数只能是0 1 2 3 4 5；

        }

        return null;
    }

/*    public String [] getArray(int [] arr){
        arr.sort(Comparator.comparing(arr));
        System.out.println(persions);
        return null;
    }*/

    public static int[][] flipAndInvertImage(int[][] A) {
        int [] [] R = new int[A.length][];
        //每个元素，先逆序再取反
        for(int i=0;i<A.length;i++){
            int arr [] = A[i];
            int [] tarr = new int [arr.length];
            //int [] rarr = new int [arr.length];
            for(int j=0;j<arr.length;j++){
                tarr[j] = arr[arr.length-1-j];
                tarr[j] = Integer.compare(tarr[j],0) == 0 ? 1 : 0;
            }
            A[i] = tarr;
        }
        System.out.println("1:"+ JSON.toJSONString(A));
        System.out.println("2:"+JSON.toJSONString(R));
        return R;
    }

    /**
     * nums = [5,2,6,1]
     * 输出：[2,1,1,0]
     * @param nums
     * @return
     */
    public static List<Integer> countSmaller1(int[] nums) {
        int [] newarr = new int[nums.length];
        for(int k = 0;k<nums.length;k++){
            newarr[k] = nums[k];
        }
        Arrays.sort(newarr);

        //先排序，然后遍历原数组，二res分法寻找对应数在新数组中的下标
        Integer[]  res = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            int start = 0;
            int end = nums.length - 1;
            while(start <= end){
                int mid = start + (end -start)/2;
                if(newarr[mid] >= temp)
                    end = mid -1;
                else
                    start = mid +1;
            }
            res[i] = start;
        }
        return Arrays.asList(res);
    }

    private static int[] getNewArr(int[] yy) {
        Arrays.sort(yy);
        return yy;
    }

    public static List<Integer> countSmaller2(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Integer[] ans = new Integer[nums.length];
        for(int i=nums.length -1;i>=0;i--){
            int index = binSearch(list,nums[i]);
            list.add(index,nums[i]);
            ans[i] = index;
        }
        return Arrays.asList(ans);
    }

    public static int binSearch(List<Integer> list,int target){
        int l = 0,r = list.size() -1;
        while(l <= r){
            int mid = l + (r -l)/2;
            if(list.get(mid) >= target)
                r = mid -1;
            else
                l = mid +1;
        }
        return l;
    }

    public static long getDifferMinite(String dateBegin, String dateOver, String format) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat(format);
        long over = df.parse(dateOver).getTime();
        long begin = df.parse(dateBegin).getTime();
        long differMinite = (over - begin) / (1000 * 60);
        return differMinite;
    }

    public static void main(String[] args) {
        /*int [] nums = {5,2,6,1};
       System.out.println(countSmaller1(nums));*/
         String s = "12345678901";
    }

}

