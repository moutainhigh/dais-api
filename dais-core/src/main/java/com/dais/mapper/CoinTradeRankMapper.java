package com.dais.mapper;

import com.dais.model.CoinTradeRank;
import com.dais.model.CoinTradeRankExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CoinTradeRankMapper {
    int countByExample(CoinTradeRankExample example);

    int deleteByExample(CoinTradeRankExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CoinTradeRank record);

    int insertSelective(CoinTradeRank record);

    List<CoinTradeRank> selectByExample(CoinTradeRankExample example);

    CoinTradeRank selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CoinTradeRank record, @Param("example") CoinTradeRankExample example);

    int updateByExample(@Param("record") CoinTradeRank record, @Param("example") CoinTradeRankExample example);

    int updateByPrimaryKeySelective(CoinTradeRank record);

    int updateByPrimaryKey(CoinTradeRank record);
}