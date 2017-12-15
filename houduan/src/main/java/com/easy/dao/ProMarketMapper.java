package com.easy.dao;

import com.easy.domain.ProMarket;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProMarketMapper {
    int deleteByPrimaryKey(String mktId);

    int insert(ProMarket record);

    int insertSelective(ProMarket record);

    ProMarket selectByPrimaryKey(String mktId);

    int updateByPrimaryKeySelective(ProMarket record);

    int updateByPrimaryKeyWithBLOBs(ProMarket record);

    int updateByPrimaryKey(ProMarket record);
}