package com.trysb.vo;

import com.trysb.util.CTools;

public class ResultVO {

    private Object data;
    private String message;
    private String messagecode;
    private boolean success;
    private String jylsh;
    private String businessNum;

    public static ResultVO valueOfSuccess(Object obj,boolean boo) {
        ResultVO resultVO = new ResultVO();
        resultVO.setData(obj);
        Thread thread = new Thread();
        resultVO.setJylsh(String.valueOf(thread.getId()));
        resultVO.setSuccess(boo);
        resultVO.setBsinessNum(CTools.getBsnum());
        return resultVO;
    }



    public String getBsinessNum() {
        return bsinessNum;
    }

    public void setBsinessNum(String bsinessNum) {
        this.bsinessNum = bsinessNum;
    }

    private String bsinessNum;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessagecode() {
        return messagecode;
    }

    public void setMessagecode(String messagecode) {
        this.messagecode = messagecode;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getJylsh() {
        return jylsh;
    }

    public void setJylsh(String jylsh) {
        this.jylsh = jylsh;
    }
}
