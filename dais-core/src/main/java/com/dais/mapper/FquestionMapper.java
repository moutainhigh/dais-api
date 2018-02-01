package com.dais.mapper;

import com.dais.model.Fquestion;
import com.dais.model.FquestionExample;
import com.dais.model.FquestionWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FquestionMapper {
    int countByExample(FquestionExample example);

    int deleteByExample(FquestionExample example);

    int deleteByPrimaryKey(Integer fid);

    int insert(FquestionWithBLOBs record);

    int insertSelective(FquestionWithBLOBs record);

    List<FquestionWithBLOBs> selectByExampleWithBLOBs(FquestionExample example);

    List<Fquestion> selectByExample(FquestionExample example);

    FquestionWithBLOBs selectByPrimaryKey(Integer fid);

    int updateByExampleSelective(@Param("record") FquestionWithBLOBs record, @Param("example") FquestionExample example);

    int updateByExampleWithBLOBs(@Param("record") FquestionWithBLOBs record, @Param("example") FquestionExample example);

    int updateByExample(@Param("record") Fquestion record, @Param("example") FquestionExample example);

    int updateByPrimaryKeySelective(FquestionWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(FquestionWithBLOBs record);

    int updateByPrimaryKey(Fquestion record);
}