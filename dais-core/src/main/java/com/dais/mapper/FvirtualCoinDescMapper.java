package com.dais.mapper;

import com.dais.model.FvirtualCoinDesc;
import com.dais.model.FvirtualCoinDescExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FvirtualCoinDescMapper {
    int countByExample(FvirtualCoinDescExample example);

    int deleteByExample(FvirtualCoinDescExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FvirtualCoinDesc record);

    int insertSelective(FvirtualCoinDesc record);

    List<FvirtualCoinDesc> selectByExample(FvirtualCoinDescExample example);

    FvirtualCoinDesc selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FvirtualCoinDesc record, @Param("example") FvirtualCoinDescExample example);

    int updateByExample(@Param("record") FvirtualCoinDesc record, @Param("example") FvirtualCoinDescExample example);

    int updateByPrimaryKeySelective(FvirtualCoinDesc record);

    int updateByPrimaryKey(FvirtualCoinDesc record);
}