package com.dais.mapper;

import com.dais.model.Fees;
import com.dais.model.FeesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FeesMapper {
    int countByExample(FeesExample example);

    int deleteByExample(FeesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Fees record);

    int insertSelective(Fees record);

    List<Fees> selectByExample(FeesExample example);

    Fees selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Fees record, @Param("example") FeesExample example);

    int updateByExample(@Param("record") Fees record, @Param("example") FeesExample example);

    int updateByPrimaryKeySelective(Fees record);

    int updateByPrimaryKey(Fees record);
}