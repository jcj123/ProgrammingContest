package com.easy.service;

import java.util.List;

import com.easy.domain.MassUser;

/***
 * Created on 2017/11/8 <br>
 * Description: <br>
 * @author easy
 */
public interface MassUserService {

  /**
   * 报名集货 新增加入用户
   * @param massUser
   * @return
   */
  int insert(MassUser massUser);
  
  List<String> getHeadUrlListByMassId(String MassId);

}
