package com.dais.mapper;

import com.dais.model.Fmessage;
import com.dais.model.FmessageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FmessageMapper {
    int countByExample(FmessageExample example);

    int deleteByExample(FmessageExample example);

    int deleteByPrimaryKey(Integer fid);

    int insert(Fmessage record);

    int insertSelective(Fmessage record);

    List<Fmessage> selectByExample(FmessageExample example);

    Fmessage selectByPrimaryKey(Integer fid);

    int updateByExampleSelective(@Param("record") Fmessage record, @Param("example") FmessageExample example);

    int updateByExample(@Param("record") Fmessage record, @Param("example") FmessageExample example);

    int updateByPrimaryKeySelective(Fmessage record);

    int updateByPrimaryKey(Fmessage record);
}