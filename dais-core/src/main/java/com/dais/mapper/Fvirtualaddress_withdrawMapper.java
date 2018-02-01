package com.dais.mapper;

import com.dais.model.Fvirtualaddress_withdraw;
import com.dais.model.Fvirtualaddress_withdrawExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Fvirtualaddress_withdrawMapper {
    int countByExample(Fvirtualaddress_withdrawExample example);

    int deleteByExample(Fvirtualaddress_withdrawExample example);

    int deleteByPrimaryKey(Integer fid);

    int insert(Fvirtualaddress_withdraw record);

    int insertSelective(Fvirtualaddress_withdraw record);

    List<Fvirtualaddress_withdraw> selectByExample(Fvirtualaddress_withdrawExample example);

    Fvirtualaddress_withdraw selectByPrimaryKey(Integer fid);

    int updateByExampleSelective(@Param("record") Fvirtualaddress_withdraw record, @Param("example") Fvirtualaddress_withdrawExample example);

    int updateByExample(@Param("record") Fvirtualaddress_withdraw record, @Param("example") Fvirtualaddress_withdrawExample example);

    int updateByPrimaryKeySelective(Fvirtualaddress_withdraw record);

    int updateByPrimaryKey(Fvirtualaddress_withdraw record);
}