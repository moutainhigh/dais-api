package com.dais.mapper;

import com.dais.model.WalletUnlockInfo;
import com.dais.model.WalletUnlockInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WalletUnlockInfoMapper {
    int countByExample(WalletUnlockInfoExample example);

    int deleteByExample(WalletUnlockInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WalletUnlockInfo record);

    int insertSelective(WalletUnlockInfo record);

    List<WalletUnlockInfo> selectByExample(WalletUnlockInfoExample example);

    WalletUnlockInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WalletUnlockInfo record, @Param("example") WalletUnlockInfoExample example);

    int updateByExample(@Param("record") WalletUnlockInfo record, @Param("example") WalletUnlockInfoExample example);

    int updateByPrimaryKeySelective(WalletUnlockInfo record);

    int updateByPrimaryKey(WalletUnlockInfo record);
}