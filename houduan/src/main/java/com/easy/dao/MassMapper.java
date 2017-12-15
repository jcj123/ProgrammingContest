package com.easy.dao;

import com.easy.domain.Mass;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MassMapper {
    int deleteByPrimaryKey(String id);

    int insert(Mass record);

    int insertSelective(Mass record);

    Mass selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Mass record);

    int updateByPrimaryKey(Mass record);
}