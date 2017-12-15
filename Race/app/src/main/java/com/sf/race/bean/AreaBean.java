package com.sf.race.bean;

/**
 * Created by lxb on 2017-12-15.
 */

public class AreaBean {
    private int areaId;
    private int cityId;
    private String areaName;
    private String cityCode;

    public AreaBean(){}

    public AreaBean(int areaId, int cityId, String areaName, String cityCode) {
        this.areaId = areaId;
        this.cityId = cityId;
        this.areaName = areaName;
        this.cityCode = cityCode;
    }

    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }
}
