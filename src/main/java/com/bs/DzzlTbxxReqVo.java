package com.bs;

public class DzzlTbxxReqVo {
    /**
     * 业务唯一标识，对应征管流程实例id
     */
    private String bussid;

    /**
     * 纳税人识别号
     */
    private String taxpayernum;

    /**
     * 纳税人名称，非必传
     */
    private String nsrmc;

    /**
     * 纳税人身份证号 ，非必传
     */
    private String idnumber;

    /**
     * 事项类型编码 ，对应受理税务事项代码
     */
    private String typecode;

    /**
     * 事项类型名称，非必传
     */
    private String typename;

    /**
     * 受理时间
     */
    private String submittime;

    /**
     * 系统标记，JS/金三,DS/电税,TS/退税
     */
    private String systype;

    /**
     * 税务机关代码
     */
    private String swjgdm;

    /**
     * 纳税人所属税务机关代码
     */
    private String nsrswjgdm;

    /**
     * 受理人员编号，非必传
     */
    private String bsry;

    /**
     * 受理人员名称，非必传
     */
    private String slrymc;

    /**
     * 是否审批信息，1/是，其它不是
     */
    private String isaudit;


    /**
     * @return the bussid
     */
    public String getBussid() {
        return bussid;
    }

    /**
     * @param bussid the bussid to set
     */
    public void setBussid(String bussid) {
        this.bussid = bussid;
    }

    /**
     * @return the taxpayernum
     */
    public String getTaxpayernum() {
        return taxpayernum;
    }

    /**
     * @param taxpayernum the taxpayernum to set
     */
    public void setTaxpayernum(String taxpayernum) {
        this.taxpayernum = taxpayernum;
    }

    /**
     * @return the nsrmc
     */
    public String getNsrmc() {
        return nsrmc;
    }

    /**
     * @param nsrmc the nsrmc to set
     */
    public void setNsrmc(String nsrmc) {
        this.nsrmc = nsrmc;
    }

    /**
     * @return the idnumber
     */
    public String getIdnumber() {
        return idnumber;
    }

    /**
     * @param idnumber the idnumber to set
     */
    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber;
    }

    /**
     * @return the typecode
     */
    public String getTypecode() {
        return typecode;
    }

    /**
     * @param typecode the typecode to set
     */
    public void setTypecode(String typecode) {
        this.typecode = typecode;
    }

    /**
     * @return the typename
     */
    public String getTypename() {
        return typename;
    }

    /**
     * @param typename the typename to set
     */
    public void setTypename(String typename) {
        this.typename = typename;
    }

    /**
     * @return the submittime
     */
    public String getSubmittime() {
        return submittime;
    }

    /**
     * @param submittime the submittime to set
     */
    public void setSubmittime(String submittime) {
        this.submittime = submittime;
    }

    /**
     * @return the systype
     */
    public String getSystype() {
        return systype;
    }

    /**
     * @param systype the systype to set
     */
    public void setSystype(String systype) {
        this.systype = systype;
    }

    /**
     * @return the swjgdm
     */
    public String getSwjgdm() {
        return swjgdm;
    }

    /**
     * @param swjgdm the swjgdm to set
     */
    public void setSwjgdm(String swjgdm) {
        this.swjgdm = swjgdm;
    }

    /**
     * @return the nsrswjgdm
     */
    public String getNsrswjgdm() {
        return nsrswjgdm;
    }

    /**
     * @param nsrswjgdm the nsrswjgdm to set
     */
    public void setNsrswjgdm(String nsrswjgdm) {
        this.nsrswjgdm = nsrswjgdm;
    }

    /**
     * @return the bsry
     */
    public String getBsry() {
        return bsry;
    }

    /**
     * @param bsry the bsry to set
     */
    public void setBsry(String bsry) {
        this.bsry = bsry;
    }

    /**
     * @return the slrymc
     */
    public String getSlrymc() {
        return slrymc;
    }

    /**
     * @param slrymc the slrymc to set
     */
    public void setSlrymc(String slrymc) {
        this.slrymc = slrymc;
    }

    /**
     * @return the isaudit
     */
    public String getIsaudit() {
        return isaudit;
    }

    /**
     * @param isaudit the isaudit to set
     */
    public void setIsaudit(String isaudit) {
        this.isaudit = isaudit;
    }



}
