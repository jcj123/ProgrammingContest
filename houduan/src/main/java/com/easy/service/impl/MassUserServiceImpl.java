package com.easy.service.impl;


import com.easy.dao.MassMapper;
import com.easy.dao.MassUserMapper;
import com.easy.dao.ProMarketMapper;
import com.easy.domain.Mass;
import com.easy.domain.MassUser;
import com.easy.domain.ProMarket;
import com.easy.service.MassUserService;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
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
  private MassUserMapper massUserMapper;

  @Autowired
  private MassMapper massMapper;

  @Autowired
  private ProMarketMapper proMarketMapper;


  @Override
  public int insert(MassUser massUser) {
    String massId = massUser.getMassId();
    //集货信息是否已经过时
    Mass mass = massMapper.selectByPrimaryKey(massId);
    if (mass == null) {
      return 0;
    }
    if (new Date().after(mass.getEndtm())){
      return 0;
    }
    //集货人员是否已经满
    String mktId = mass.getMktId();
    if (StringUtils.isBlank(mktId)) {
      return 0;
    }
    ProMarket proMarket = proMarketMapper.selectByPrimaryKey(mktId);
    if (proMarket.getGroupLimit() <= mass.getCurrentUsers()) {
      return 0;
    }
    //符合加入
    int insert = massUserMapper.insert(massUser);
    if (insert == 0) {
      return 0;
    }
    //成功加入  更新总人数
    Mass updateMass = new Mass();
    updateMass.setId(mass.getId());
    updateMass.setCurrentUsers(mass.getCurrentUsers() + 1);
    massMapper.updateByPrimaryKeySelective(updateMass);
    return insert;
  }


	@Override
	public List<String> getHeadUrlListByMassId(String MassId) {
		return massUserMapper.getHeadUrlListByMassId(MassId);
	}
}
