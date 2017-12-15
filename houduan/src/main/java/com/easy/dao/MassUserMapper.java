package com.easy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.easy.domain.MassUser;

@Mapper
public interface MassUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MassUser record);

    int insertSelective(MassUser record);

    MassUser selectByPrimaryKey(Integer id);
    
    List<String> getHeadUrlListByMassId(String MassId);

    int updateByPrimaryKeySelective(MassUser record);

    int updateByPrimaryKey(MassUser record);
}