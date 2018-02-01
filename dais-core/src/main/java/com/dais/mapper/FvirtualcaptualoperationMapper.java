package com.dais.mapper;

import com.dais.model.Fvirtualcaptualoperation;
import com.dais.model.FvirtualcaptualoperationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FvirtualcaptualoperationMapper {
    int countByExample(FvirtualcaptualoperationExample example);

    int deleteByExample(FvirtualcaptualoperationExample example);

    int deleteByPrimaryKey(Integer fid);

    int insert(Fvirtualcaptualoperation record);

    int insertSelective(Fvirtualcaptualoperation record);

    List<Fvirtualcaptualoperation> selectByExample(FvirtualcaptualoperationExample example);

    Fvirtualcaptualoperation selectByPrimaryKey(Integer fid);

    int updateByExampleSelective(@Param("record") Fvirtualcaptualoperation record, @Param("example") FvirtualcaptualoperationExample example);

    int updateByExample(@Param("record") Fvirtualcaptualoperation record, @Param("example") FvirtualcaptualoperationExample example);

    int updateByPrimaryKeySelective(Fvirtualcaptualoperation record);

    int updateByPrimaryKey(Fvirtualcaptualoperation record);
}