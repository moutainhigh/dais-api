package com.dais.mapper;

import com.dais.model.CommonParams;
import com.dais.model.CommonParamsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommonParamsMapper {
    int countByExample(CommonParamsExample example);

    int deleteByExample(CommonParamsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CommonParams record);

    int insertSelective(CommonParams record);

    List<CommonParams> selectByExample(CommonParamsExample example);

    CommonParams selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CommonParams record, @Param("example") CommonParamsExample example);

    int updateByExample(@Param("record") CommonParams record, @Param("example") CommonParamsExample example);

    int updateByPrimaryKeySelective(CommonParams record);

    int updateByPrimaryKey(CommonParams record);
}