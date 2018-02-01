package com.dais.mapper;

import com.dais.model.PublicBlockAccount;
import com.dais.model.PublicBlockAccountExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PublicBlockAccountMapper {
    int countByExample(PublicBlockAccountExample example);

    int deleteByExample(PublicBlockAccountExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PublicBlockAccount record);

    int insertSelective(PublicBlockAccount record);

    List<PublicBlockAccount> selectByExample(PublicBlockAccountExample example);

    PublicBlockAccount selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PublicBlockAccount record, @Param("example") PublicBlockAccountExample example);

    int updateByExample(@Param("record") PublicBlockAccount record, @Param("example") PublicBlockAccountExample example);

    int updateByPrimaryKeySelective(PublicBlockAccount record);

    int updateByPrimaryKey(PublicBlockAccount record);
}