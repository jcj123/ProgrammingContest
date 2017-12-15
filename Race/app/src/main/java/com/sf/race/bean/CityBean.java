package com.sf.race.bean;

/**
 * Created by lxb on 2017-12-15.
 */

public class CityBean {
    private int cityId;
    private int proId;
    private String cityCode;
    private String cityName;
    private String proCode;

    public CityBean(){}

    public CityBean(int cityId, int proId, String cityCode, String cityName, String proCode) {
        this.cityId = cityId;
        this.proId = proId;
        this.cityCode = cityCode;
        this.cityName = cityName;
        this.proCode = proCode;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public int getProId() {
        return proId;
    }

    public void setProId(int proId) {
        this.proId = proId;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getProCode() {
        return proCode;
    }

    public void setProCode(String proCode) {
        this.proCode = proCode;
    }
}
