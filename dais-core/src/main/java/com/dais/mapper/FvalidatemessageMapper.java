package com.dais.mapper;

import com.dais.model.Fvalidatemessage;
import com.dais.model.FvalidatemessageExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FvalidatemessageMapper {
    int countByExample(FvalidatemessageExample example);

    int deleteByExample(FvalidatemessageExample example);

    int deleteByPrimaryKey(Integer fid);

    int insert(Fvalidatemessage record);

    int insertSelective(Fvalidatemessage record);

    List<Fvalidatemessage> selectByExampleWithBLOBs(FvalidatemessageExample example);

    List<Fvalidatemessage> selectByExample(FvalidatemessageExample example);

    Fvalidatemessage selectByPrimaryKey(Integer fid);

    int updateByExampleSelective(@Param("record") Fvalidatemessage record, @Param("example") FvalidatemessageExample example);

    int updateByExampleWithBLOBs(@Param("record") Fvalidatemessage record, @Param("example") FvalidatemessageExample example);

    int updateByExample(@Param("record") Fvalidatemessage record, @Param("example") FvalidatemessageExample example);

    int updateByPrimaryKeySelective(Fvalidatemessage record);

    int updateByPrimaryKeyWithBLOBs(Fvalidatemessage record);

    int updateByPrimaryKey(Fvalidatemessage record);
}