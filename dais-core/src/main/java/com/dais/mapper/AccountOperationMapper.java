package com.dais.mapper;

import com.dais.model.AccountOperation;
import com.dais.model.AccountOperationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AccountOperationMapper {
    int countByExample(AccountOperationExample example);

    int deleteByExample(AccountOperationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AccountOperation record);

    int insertSelective(AccountOperation record);

    List<AccountOperation> selectByExample(AccountOperationExample example);

    AccountOperation selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AccountOperation record, @Param("example") AccountOperationExample example);

    int updateByExample(@Param("record") AccountOperation record, @Param("example") AccountOperationExample example);

    int updateByPrimaryKeySelective(AccountOperation record);

    int updateByPrimaryKey(AccountOperation record);
}