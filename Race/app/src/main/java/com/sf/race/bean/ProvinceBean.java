package com.sf.race.bean;

/**
 * Created by lxb on 2017-12-15.
 */

public class ProvinceBean {
    private int proId;
    private String proCode;
    private String proName;
    private String proName2;
    public ProvinceBean(){}

    public ProvinceBean(int proId, String proCode, String proName, String proName2) {
        this.proId = proId;
        this.proCode = proCode;
        this.proName = proName;
        this.proName2 = proName2;
    }

    public int getProId() {
        return proId;
    }

    public void setProId(int proId) {
        this.proId = proId;
    }

    public String getProCode() {
        return proCode;
    }

    public void setProCode(String proCode) {
        this.proCode = proCode;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getProName2() {
        return proName2;
    }

    public void setProName2(String proName2) {
        this.proName2 = proName2;
    }
}
