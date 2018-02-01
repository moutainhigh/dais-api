package com.dais.mapper;

import com.dais.model.Fvirtualaddress;
import com.dais.model.FvirtualaddressExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FvirtualaddressMapper {
    int countByExample(FvirtualaddressExample example);

    int deleteByExample(FvirtualaddressExample example);

    int deleteByPrimaryKey(Integer fid);

    int insert(Fvirtualaddress record);

    int insertSelective(Fvirtualaddress record);

    List<Fvirtualaddress> selectByExample(FvirtualaddressExample example);

    Fvirtualaddress selectByPrimaryKey(Integer fid);

    int updateByExampleSelective(@Param("record") Fvirtualaddress record, @Param("example") FvirtualaddressExample example);

    int updateByExample(@Param("record") Fvirtualaddress record, @Param("example") FvirtualaddressExample example);

    int updateByPrimaryKeySelective(Fvirtualaddress record);

    int updateByPrimaryKey(Fvirtualaddress record);
}