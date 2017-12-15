package com.easy.domain;

import java.math.BigDecimal;

public class ProMarket {

  private String mktId;

  private String mktNameShow;

  private Short dailyMinPackages;

  private BigDecimal weightMin;

  private BigDecimal weightMax;

  private BigDecimal basePrice;

  private BigDecimal baseWeight;

  private Short groupLimit;

  private Integer groupDuration;

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