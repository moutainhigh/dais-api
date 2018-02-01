package com.dais.mapper;

import com.dais.model.Fvirtualcointype;
import com.dais.model.FvirtualcointypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FvirtualcointypeMapper {
    int countByExample(FvirtualcointypeExample example);

    int deleteByExample(FvirtualcointypeExample example);

    int deleteByPrimaryKey(Integer fid);

    int insert(Fvirtualcointype record);

    int insertSelective(Fvirtualcointype record);

    List<Fvirtualcointype> selectByExample(FvirtualcointypeExample example);

    Fvirtualcointype selectByPrimaryKey(Integer fid);

    int updateByExampleSelective(@Param("record") Fvirtualcointype record, @Param("example") FvirtualcointypeExample example);

    int updateByExample(@Param("record") Fvirtualcointype record, @Param("example") FvirtualcointypeExample example);

    int updateByPrimaryKeySelective(Fvirtualcointype record);

    int updateByPrimaryKey(Fvirtualcointype record);
}