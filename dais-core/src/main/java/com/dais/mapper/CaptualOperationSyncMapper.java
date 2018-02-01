package com.dais.mapper;

import com.dais.model.CaptualOperationSync;
import com.dais.model.CaptualOperationSyncExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CaptualOperationSyncMapper {
    int countByExample(CaptualOperationSyncExample example);

    int deleteByExample(CaptualOperationSyncExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CaptualOperationSync record);

    int insertSelective(CaptualOperationSync record);

    List<CaptualOperationSync> selectByExample(CaptualOperationSyncExample example);

    CaptualOperationSync selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CaptualOperationSync record, @Param("example") CaptualOperationSyncExample example);

    int updateByExample(@Param("record") CaptualOperationSync record, @Param("example") CaptualOperationSyncExample example);

    int updateByPrimaryKeySelective(CaptualOperationSync record);

    int updateByPrimaryKey(CaptualOperationSync record);
}