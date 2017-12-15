package com.easy.service.impl;


import com.easy.dao.MassUserMapper;
import com.easy.domain.MassUser;
import com.easy.service.MassUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/***
 * Created on 2017/11/8 <br>
 * Description: <br>
 * @author easy
 */
@Service
public class MassUserServiceImpl implements MassUserService {

  @Autowired
  MassUserMapper massUserMapper;


  @Override
  public int insert(MassUser massUser) {
    return massUserMapper.insert(massUser);
  }
}
