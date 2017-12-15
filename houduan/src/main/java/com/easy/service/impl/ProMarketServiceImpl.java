package com.easy.service.impl;


import com.easy.dao.ProMarketMapper;
import com.easy.domain.ProMarket;
import com.easy.service.ProMarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/***
 * Created on 2017/12/15 <br>
 * Description: <br>
 * @author easy
 */
@Service
public class ProMarketServiceImpl implements ProMarketService {

  @Autowired
  ProMarketMapper proMarketMapper;

  @Override
  public int insert(ProMarket record) {
    return proMarketMapper.insert(record);
  }

	@Override
	public ProMarket selectByPrimaryKey(String mktId) {
		return proMarketMapper.selectByPrimaryKey(mktId);
	}
}
