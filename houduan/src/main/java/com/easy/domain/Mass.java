package com.easy.domain;

import java.util.Date;

public class Mass {

  private String id;

  private String mktId;

  private String lowestPrice;

  private String lowestFreight;

  private String picUrl;

  private String massType;

  private Date endtm;

  private Integer currentUsers;

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
}