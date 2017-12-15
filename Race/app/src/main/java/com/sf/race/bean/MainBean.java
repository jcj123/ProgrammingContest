package com.sf.race.bean;

import java.util.List;

/**
 * Created by gougou on 12/15/2017.
 * 主页面bean
 */

public class MainBean {

    /**
     * success : true
     * status : 0
     * message : null
     * obj : {"id":"2c029290-e16b-11e7-83f0-00ff8ba56b27","mktId":"e174424f-e153-11e7-83f0-00ff8ba56b27","lowestPrice":"6元/1.5KG","lowestFreight":"120","picUrl":"/cc","massType":"全國團","endtm":1513327213000,"currentUsers":0,"usersPic":[],"mktNameShow":"吃鸡小队","dailyMinPackages":20,"weightMin":1.5,"weightMax":5,"groupLimit":5,"useRequire":"1.每日承诺寄件量不低于20件（周六日及法定假期不要求承诺量）日发件不足20件或运费不足120元将按照120元收取最低运作费用。\\n2.承诺使用周期内提前终止寄件视为违约行为。\\n3.集货周期内未达到目标则自动取消集货。\\n4.用户需自行完成打包并贴好面单。\\n5.每日在约定时间内进行一次交件，不支持随寄随收。\\n6.按月结算运费，不支持现寄现结。"}
     */

    private boolean success;
    private int status;
    private Object message;
    private ObjBean obj;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    public ObjBean getObj() {
        return obj;
    }

    public void setObj(ObjBean obj) {
        this.obj = obj;
    }

    public static class ObjBean {
        /**
         * id : 2c029290-e16b-11e7-83f0-00ff8ba56b27
         * mktId : e174424f-e153-11e7-83f0-00ff8ba56b27
         * lowestPrice : 6元/1.5KG
         * lowestFreight : 120
         * picUrl : /cc
         * massType : 全國團
         * endtm : 1513327213000
         * currentUsers : 0
         * usersPic : []
         * mktNameShow : 吃鸡小队
         * dailyMinPackages : 20
         * weightMin : 1.5
         * weightMax : 5.0
         * groupLimit : 5
         * useRequire : 1.每日承诺寄件量不低于20件（周六日及法定假期不要求承诺量）日发件不足20件或运费不足120元将按照120元收取最低运作费用。\n2.承诺使用周期内提前终止寄件视为违约行为。\n3.集货周期内未达到目标则自动取消集货。\n4.用户需自行完成打包并贴好面单。\n5.每日在约定时间内进行一次交件，不支持随寄随收。\n6.按月结算运费，不支持现寄现结。
         */

        private String id;
        private String mktId;
        private String lowestPrice;
        private String lowestFreight;
        private String picUrl;
        private String massType;
        private long endtm;
        private int currentUsers;
        private String mktNameShow;
        private int dailyMinPackages;
        private double weightMin;
        private double weightMax;
        private int groupLimit;
        private String useRequire;
        private List<?> usersPic;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getMktId() {
            return mktId;
        }

        public void setMktId(String mktId) {
            this.mktId = mktId;
        }

        public String getLowestPrice() {
            return lowestPrice;
        }

        public void setLowestPrice(String lowestPrice) {
            this.lowestPrice = lowestPrice;
        }

        public String getLowestFreight() {
            return lowestFreight;
        }

        public void setLowestFreight(String lowestFreight) {
            this.lowestFreight = lowestFreight;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public String getMassType() {
            return massType;
        }

        public void setMassType(String massType) {
            this.massType = massType;
        }

        public long getEndtm() {
            return endtm;
        }

        public void setEndtm(long endtm) {
            this.endtm = endtm;
        }

        public int getCurrentUsers() {
            return currentUsers;
        }

        public void setCurrentUsers(int currentUsers) {
            this.currentUsers = currentUsers;
        }

        public String getMktNameShow() {
            return mktNameShow;
        }

        public void setMktNameShow(String mktNameShow) {
            this.mktNameShow = mktNameShow;
        }

        public int getDailyMinPackages() {
            return dailyMinPackages;
        }

        public void setDailyMinPackages(int dailyMinPackages) {
            this.dailyMinPackages = dailyMinPackages;
        }

        public double getWeightMin() {
            return weightMin;
        }

        public void setWeightMin(double weightMin) {
            this.weightMin = weightMin;
        }

        public double getWeightMax() {
            return weightMax;
        }

        public void setWeightMax(double weightMax) {
            this.weightMax = weightMax;
        }

        public int getGroupLimit() {
            return groupLimit;
        }

        public void setGroupLimit(int groupLimit) {
            this.groupLimit = groupLimit;
        }

        public String getUseRequire() {
            return useRequire;
        }

        public void setUseRequire(String useRequire) {
            this.useRequire = useRequire;
        }

        public List<?> getUsersPic() {
            return usersPic;
        }

        public void setUsersPic(List<?> usersPic) {
            this.usersPic = usersPic;
        }
    }
}
