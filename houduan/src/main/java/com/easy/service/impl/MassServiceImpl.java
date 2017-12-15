package com.easy.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easy.dao.MassMapper;
import com.easy.domain.Mass;
import com.easy.service.MassService;

/***
 * Created on 2017/12/15 <br>
 * Description: 集货信息服务<br>
 * @author easy
 */
@Service
public class MassServiceImpl implements MassService {

  @Autowired
  private MassMapper massMapper;

  @Override
  public Integer saveMassInfo(Mass mass) {
    return massMapper.insert(mass);
  }

  @Override
  public Mass selectByPrimaryKey(String id) {
    return massMapper.selectByPrimaryKey(id);
  }

	@Override
	public Mass getMassInfo() {
		return massMapper.getMassInfo();
	}

}
