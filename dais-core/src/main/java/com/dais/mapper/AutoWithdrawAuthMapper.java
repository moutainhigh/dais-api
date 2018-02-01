package com.dais.mapper;

import com.dais.model.AutoWithdrawAuth;
import com.dais.model.AutoWithdrawAuthExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AutoWithdrawAuthMapper {
    int countByExample(AutoWithdrawAuthExample example);

    int deleteByExample(AutoWithdrawAuthExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AutoWithdrawAuth record);

    int insertSelective(AutoWithdrawAuth record);

    List<AutoWithdrawAuth> selectByExample(AutoWithdrawAuthExample example);

    AutoWithdrawAuth selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AutoWithdrawAuth record, @Param("example") AutoWithdrawAuthExample example);

    int updateByExample(@Param("record") AutoWithdrawAuth record, @Param("example") AutoWithdrawAuthExample example);

    int updateByPrimaryKeySelective(AutoWithdrawAuth record);

    int updateByPrimaryKey(AutoWithdrawAuth record);
}