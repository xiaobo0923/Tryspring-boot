package com.bs;

import java.util.ArrayList;
import java.util.List;

public class TestPro {

    private static String age = "123";

    public static String name = "ABC";

    /*private String remove(){
        return "private";
    }*/

    protected  String remove(){
        return "protected";
    }

    /*public String remove(){
        return "public";
    }*/

    public TestPro() {
    }

    public static void main(String[] args) {
        System.out.println(getSwsxList("110113,110207"));
    }

    private static String[]  getSwsxList(String swsxStr){
        String[] swsxArray = {"110113","110207","110671","110150","110151"};
        List<String> list = new ArrayList<String>();
        for(String swsxDm : swsxArray){
            if(swsxStr.contains(swsxDm)){
                list.add(swsxDm);
            }
        }
        return (String[]) list.toArray();
    }
}
