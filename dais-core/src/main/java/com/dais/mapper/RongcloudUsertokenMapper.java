package com.dais.mapper;

import com.dais.model.RongcloudUsertoken;
import com.dais.model.RongcloudUsertokenExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RongcloudUsertokenMapper {
    int countByExample(RongcloudUsertokenExample example);

    int deleteByExample(RongcloudUsertokenExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RongcloudUsertoken record);

    int insertSelective(RongcloudUsertoken record);

    List<RongcloudUsertoken> selectByExample(RongcloudUsertokenExample example);

    RongcloudUsertoken selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RongcloudUsertoken record, @Param("example") RongcloudUsertokenExample example);

    int updateByExample(@Param("record") RongcloudUsertoken record, @Param("example") RongcloudUsertokenExample example);

    int updateByPrimaryKeySelective(RongcloudUsertoken record);

    int updateByPrimaryKey(RongcloudUsertoken record);
}