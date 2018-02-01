package com.dais.mapper;

import com.dais.model.CoinTradeRankDay;
import com.dais.model.CoinTradeRankDayExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CoinTradeRankDayMapper {
    int countByExample(CoinTradeRankDayExample example);

    int deleteByExample(CoinTradeRankDayExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CoinTradeRankDay record);

    int insertSelective(CoinTradeRankDay record);

    List<CoinTradeRankDay> selectByExample(CoinTradeRankDayExample example);

    CoinTradeRankDay selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CoinTradeRankDay record, @Param("example") CoinTradeRankDayExample example);

    int updateByExample(@Param("record") CoinTradeRankDay record, @Param("example") CoinTradeRankDayExample example);

    int updateByPrimaryKeySelective(CoinTradeRankDay record);

    int updateByPrimaryKey(CoinTradeRankDay record);
}