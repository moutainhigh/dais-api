package com.dais.mapper;

import com.dais.model.Ffees;
import com.dais.model.FfeesExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FfeesMapper {
    int countByExample(FfeesExample example);

    int deleteByExample(FfeesExample example);

    int deleteByPrimaryKey(Integer fid);

    int insert(Ffees record);

    int insertSelective(Ffees record);

    List<Ffees> selectByExample(FfeesExample example);

    Ffees selectByPrimaryKey(Integer fid);

    int updateByExampleSelective(@Param("record") Ffees record, @Param("example") FfeesExample example);

    int updateByExample(@Param("record") Ffees record, @Param("example") FfeesExample example);

    int updateByPrimaryKeySelective(Ffees record);

    int updateByPrimaryKey(Ffees record);
}