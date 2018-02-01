package com.dais.mapper;

import com.dais.model.CoinTradeRankHour;
import com.dais.model.CoinTradeRankHourExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CoinTradeRankHourMapper {
    int countByExample(CoinTradeRankHourExample example);

    int deleteByExample(CoinTradeRankHourExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CoinTradeRankHour record);

    int insertSelective(CoinTradeRankHour record);

    List<CoinTradeRankHour> selectByExample(CoinTradeRankHourExample example);

    CoinTradeRankHour selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CoinTradeRankHour record, @Param("example") CoinTradeRankHourExample example);

    int updateByExample(@Param("record") CoinTradeRankHour record, @Param("example") CoinTradeRankHourExample example);

    int updateByPrimaryKeySelective(CoinTradeRankHour record);

    int updateByPrimaryKey(CoinTradeRankHour record);
}