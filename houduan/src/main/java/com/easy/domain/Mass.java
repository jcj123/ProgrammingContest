package com.easy.domain;

import java.io.Serializable;
import java.util.Date;
/***
 * Created on 2017/12/15 <br>
 * Description: 集货信息<br>
 * @author easy
 */
public class Mass implements Serializable {

  /**
   * 主键
   */
  private String id;

  /**
   *专业市场id
   */
  private String mktId;

  /**
   * 最低价格
   */
  private String lowestPrice;

  /**
   * 最低运费
   */
  private String lowestFreight;

  /**
   * 推广图片
   */
  private String picUrl;

  /**
   * 货团类型
   */
  private String massType;

  /**
   * 结束时间
   */
  private Date endtm;

  /**
   * 当前人数
   */
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