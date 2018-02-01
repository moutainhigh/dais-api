package com.dais.mapper;

import com.dais.model.FvitualCoinTradeRank;
import com.dais.model.FvitualCoinTradeRankExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FvitualCoinTradeRankMapper {
    int countByExample(FvitualCoinTradeRankExample example);

    int deleteByExample(FvitualCoinTradeRankExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FvitualCoinTradeRank record);

    int insertSelective(FvitualCoinTradeRank record);

    List<FvitualCoinTradeRank> selectByExample(FvitualCoinTradeRankExample example);

    FvitualCoinTradeRank selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FvitualCoinTradeRank record, @Param("example") FvitualCoinTradeRankExample example);

    int updateByExample(@Param("record") FvitualCoinTradeRank record, @Param("example") FvitualCoinTradeRankExample example);

    int updateByPrimaryKeySelective(FvitualCoinTradeRank record);

    int updateByPrimaryKey(FvitualCoinTradeRank record);
}