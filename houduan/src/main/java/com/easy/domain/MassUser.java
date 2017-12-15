package com.easy.domain;

import java.io.Serializable;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.NotEmpty;

/***
 * Created on 2017/12/15 <br>
 * Description: 集货信息用户<br>
 * @author easy
 */
public class MassUser implements Serializable {

  /**
   * 用户id
   */
  private Integer id;
  /**
   *集货id
   */
  @NotEmpty(message = "集货信息id不能为空")
  private String massId;
  /**
   * 省市信息
   */
  @NotEmpty(message = "寄件省市信息不能为空")
  private String province;
  /**
   * 详细地址
   */
  @NotEmpty(message = "寄件地址详情不能为空")
  private String address;
  /**
   * 寄件人姓名
   */
  @NotEmpty(message = "寄件人姓名不能为空")
  private String userName;
  /**
   * 寄件人手机
   */
  @NotEmpty(message = "寄件人手机不能为空")
  @Pattern(regexp = "^((17[0-9])|(14[0-9])|(13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$")
  private String phone;
  /**
   * 寄件人头像
   */
  private String headPortrait;
  /**
   * 每日寄件量
   */
  @NotEmpty(message = "预估每日寄件量不能为空")
  private String sendNumber;
  /**
   * 单件平均重量
   */
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