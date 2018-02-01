package com.dais.mapper;

import com.dais.model.Fvirtualwallet;
import com.dais.model.FvirtualwalletExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FvirtualwalletMapper {
    int countByExample(FvirtualwalletExample example);

    int deleteByExample(FvirtualwalletExample example);

    int deleteByPrimaryKey(Integer fid);

    int insert(Fvirtualwallet record);

    int insertSelective(Fvirtualwallet record);

    List<Fvirtualwallet> selectByExample(FvirtualwalletExample example);

    Fvirtualwallet selectByPrimaryKey(Integer fid);

    int updateByExampleSelective(@Param("record") Fvirtualwallet record, @Param("example") FvirtualwalletExample example);

    int updateByExample(@Param("record") Fvirtualwallet record, @Param("example") FvirtualwalletExample example);

    int updateByPrimaryKeySelective(Fvirtualwallet record);

    int updateByPrimaryKey(Fvirtualwallet record);
}