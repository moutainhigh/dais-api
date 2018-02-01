package com.dais.mapper;

import com.dais.model.Fcountlimit;
import com.dais.model.FcountlimitExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FcountlimitMapper {
    int countByExample(FcountlimitExample example);

    int deleteByExample(FcountlimitExample example);

    int deleteByPrimaryKey(Integer fid);

    int insert(Fcountlimit record);

    int insertSelective(Fcountlimit record);

    List<Fcountlimit> selectByExample(FcountlimitExample example);

    Fcountlimit selectByPrimaryKey(Integer fid);

    int updateByExampleSelective(@Param("record") Fcountlimit record, @Param("example") FcountlimitExample example);

    int updateByExample(@Param("record") Fcountlimit record, @Param("example") FcountlimitExample example);

    int updateByPrimaryKeySelective(Fcountlimit record);

    int updateByPrimaryKey(Fcountlimit record);
}