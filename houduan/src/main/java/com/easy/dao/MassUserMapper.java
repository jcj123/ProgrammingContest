package com.easy.dao;

import com.easy.domain.MassUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MassUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MassUser record);

    int insertSelective(MassUser record);

    MassUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MassUser record);

    int updateByPrimaryKey(MassUser record);
}