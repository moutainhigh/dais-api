package com.dais.mapper;

import com.dais.model.CoinTradeRankMin5;
import com.dais.model.CoinTradeRankMin5Example;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CoinTradeRankMin5Mapper {
    int countByExample(CoinTradeRankMin5Example example);

    int deleteByExample(CoinTradeRankMin5Example example);

    int deleteByPrimaryKey(Integer id);

    int insert(CoinTradeRankMin5 record);

    int insertSelective(CoinTradeRankMin5 record);

    List<CoinTradeRankMin5> selectByExample(CoinTradeRankMin5Example example);

    CoinTradeRankMin5 selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CoinTradeRankMin5 record, @Param("example") CoinTradeRankMin5Example example);

    int updateByExample(@Param("record") CoinTradeRankMin5 record, @Param("example") CoinTradeRankMin5Example example);

    int updateByPrimaryKeySelective(CoinTradeRankMin5 record);

    int updateByPrimaryKey(CoinTradeRankMin5 record);
}