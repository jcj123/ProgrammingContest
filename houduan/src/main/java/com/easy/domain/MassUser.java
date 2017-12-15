package com.easy.domain;

import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.NotEmpty;

public class MassUser {

  private Integer id;
  @NotEmpty(message = "集货信息id不能为空")
  private String massId;
  @NotEmpty(message = "寄件省市信息不能为空")
  private String province;
  @NotEmpty(message = "寄件地址详情不能为空")
  private String address;
  @NotEmpty(message = "寄件人姓名不能为空")
  private String userName;
  @NotEmpty(message = "寄件人手机不能为空")
  @Pattern(regexp = "^((17[0-9])|(14[0-9])|(13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$")
  private String phone;
  private String headPortrait;
  @NotEmpty(message = "预估每日寄件量不能为空")
  private String sendNumber;
  @NotEmpty(message = "单件平均重量不能为空")
  private String sendWeight;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getMassId() {
    return massId;
  }

  public void setMassId(String massId) {
    this.massId = massId;
  }

  public String getProvince() {
    return province;
  }

  public void setProvince(String province) {
    this.province = province;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getHeadPortrait() {
    return headPortrait;
  }

  public void setHeadPortrait(String headPortrait) {
    this.headPortrait = headPortrait;
  }

  public String getSendNumber() {
    return sendNumber;
  }

  public void setSendNumber(String sendNumber) {
    this.sendNumber = sendNumber;
  }

  public String getSendWeight() {
    return sendWeight;
  }

  public void setSendWeight(String sendWeight) {
    this.sendWeight = sendWeight;
  }
}