package com.easy.domain;

import java.io.Serializable;
import java.math.BigDecimal;

/***
 * Created on 2017/12/15 <br>
 * Description: 专业市场基本信息<br>
 * @author easy
 */
public class ProMarket implements Serializable {

  /**
   * 专业市场ID
   */
  private String mktId;

  /**
   * 市场外部名称
   */
  private String mktNameShow;

  /**
   * 单客日均最小件量
   */
  private Short dailyMinPackages;

  /**
   * 重量区间（最小）
   */
  private BigDecimal weightMin;

  /**
   * 重量区间（最大）
   */
  private BigDecimal weightMax;

  /**
   * 首重价格
   */
  private BigDecimal basePrice;

  /**
   * 首重重量
   */
  private BigDecimal baseWeight;

  /**
   * 成团人数
   */
  private Short groupLimit;

  /**
   * 拼团周期
   */
  private Integer groupDuration;

  /**
   * 使用要求
   */
  private String useRequire;

  public String getMktId() {
    return mktId;
  }

  public void setMktId(String mktId) {
    this.mktId = mktId;
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

  public BigDecimal getBasePrice() {
    return basePrice;
  }

  public void setBasePrice(BigDecimal basePrice) {
    this.basePrice = basePrice;
  }

  public BigDecimal getBaseWeight() {
    return baseWeight;
  }

  public void setBaseWeight(BigDecimal baseWeight) {
    this.baseWeight = baseWeight;
  }

  public Short getGroupLimit() {
    return groupLimit;
  }

  public void setGroupLimit(Short groupLimit) {
    this.groupLimit = groupLimit;
  }

  public Integer getGroupDuration() {
    return groupDuration;
  }

  public void setGroupDuration(Integer groupDuration) {
    this.groupDuration = groupDuration;
  }

  public String getUseRequire() {
    return useRequire;
  }

  public void setUseRequire(String useRequire) {
    this.useRequire = useRequire;
  }
}