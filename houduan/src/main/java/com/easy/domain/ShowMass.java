package com.easy.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
/***
 * Created on 2017/12/15 <br>
 * Description: 展示集货信息bean<br>
 * @author easy
 */
public class ShowMass implements Serializable {

  /**
   * 主键
   */
  private String id;

  /**
   * 寄貨id
   */
  private String mktId;

  /**
   * 最低價格
   */
  private String lowestPrice;

  /**
   * 最低費用
   */
  private String lowestFreight;

  /**
   * 推广图片
   */
  private String picUrl;

  /**
   * 集货类型
   */
  private String massType;

  /**
   * 截止時間
   */
  private Date endtm;

  /**
   * 當前人數
   */
  private Integer currentUsers;

  /**
   * 當前人數
   */
  private List<String> usersPic;

  /**
   * 集貨名稱
   */
  private String mktNameShow;

  /**
   * 最低寄件量
   */
  private Short dailyMinPackages;

  /**
   * 最小重量
   */
  private BigDecimal weightMin;

  /**
   * 最大重量
   */
  private BigDecimal weightMax;

  /**
   * 總名額
   */
  private Short groupLimit;

  /**
   * 使用要求
   */
  private String useRequire;

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

  public Date getEndtm() {
    return endtm;
  }

  public void setEndtm(Date endtm) {
    this.endtm = endtm;
  }

  public Integer getCurrentUsers() {
    return currentUsers;
  }

  public void setCurrentUsers(Integer currentUsers) {
    this.currentUsers = currentUsers;
  }

  public List<String> getUsersPic() {
    return usersPic;
  }

  public void setUsersPic(List<String> usersPic) {
    this.usersPic = usersPic;
  }

  public String getMktNameShow() {
    return mktNameShow;
  }

  public void setMktNameShow(String mktNameShow) {
    this.mktNameShow = mktNameShow;
  }

  public Short getDailyMinPackages() {
    return dailyMinPackages;
  }

  public void setDailyMinPackages(Short dailyMinPackages) {
    this.dailyMinPackages = dailyMinPackages;
  }

  public BigDecimal getWeightMin() {
    return weightMin;
  }

  public void setWeightMin(BigDecimal weightMin) {
    this.weightMin = weightMin;
  }

  public BigDecimal getWeightMax() {
    return weightMax;
  }

  public void setWeightMax(BigDecimal weightMax) {
    this.weightMax = weightMax;
  }

  public Short getGroupLimit() {
    return groupLimit;
  }

  public void setGroupLimit(Short groupLimit) {
    this.groupLimit = groupLimit;
  }

  public String getUseRequire() {
    return useRequire;
  }

  public void setUseRequire(String useRequire) {
    this.useRequire = useRequire;
  }

}
