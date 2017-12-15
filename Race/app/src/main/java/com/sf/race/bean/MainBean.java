package com.sf.race.bean;

import java.util.List;

/**
 * Created by gougou on 12/15/2017.
 * 主页面bean
 */

public class MainBean {
    public String getPicUrl() {
        return picUrl;
    }

    public String getMassType() {
        return massType;
    }

    public String getEndtm() {
        return endtm;
    }

    public Integer getCurrentUsers() {
        return currentUsers;
    }

    public List<String> getUsersPic() {
        return usersPic;
    }

    public String getMktNameShow() {
        return mktNameShow;
    }

    public Short getDailyMinPackages() {
        return dailyMinPackages;
    }

    public String getWeightMax() {
        return weightMax;
    }

    public String getWeightMin() {
        return weightMin;
    }

    public Short getGroupLimit() {
        return groupLimit;
    }

    public String getUseRequire() {
        return useRequire;
    }

    //最低價格
    private String lowestPrice;

    //最低費用
    private String lowestFreight;

    //推廣圖片
    private String picUrl;

    //集貨類型
    private String massType;

    public String getLowestPrice() {
        return lowestPrice;
    }

    //截止時間
    private String endtm;

    //當前人數
    private Integer currentUsers;

    //當前人數
    private List<String> usersPic;

    //集貨名稱
    private String mktNameShow;

    //最低寄件量
    private Short dailyMinPackages;

    //最小重量
    private String weightMin;

    //最大重量
    private String weightMax;

    //總名額
    private Short groupLimit;

    //使用要求
    private String useRequire;

    public String getLowestFreight() {
        return lowestFreight;
    }

    @Override
    public String toString() {
        return "MainBean{" +
                "lowestPrice='" + lowestPrice + '\'' +
                ", lowestFreight='" + lowestFreight + '\'' +
                ", picUrl='" + picUrl + '\'' +
                ", massType='" + massType + '\'' +
                ", endtm='" + endtm + '\'' +
                ", currentUsers=" + currentUsers +
                ", usersPic=" + usersPic +
                ", mktNameShow='" + mktNameShow + '\'' +
                ", dailyMinPackages=" + dailyMinPackages +
                ", weightMin='" + weightMin + '\'' +
                ", weightMax='" + weightMax + '\'' +
                ", groupLimit=" + groupLimit +
                ", useRequire='" + useRequire + '\'' +
                '}';
    }
}
