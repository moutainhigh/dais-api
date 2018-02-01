package com.dais.mapper;

import com.dais.model.GoodfriendRelationship;
import com.dais.model.GoodfriendRelationshipExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface GoodfriendRelationshipMapper {
    int countByExample(GoodfriendRelationshipExample example);

    int deleteByExample(GoodfriendRelationshipExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GoodfriendRelationship record);

    int insertSelective(GoodfriendRelationship record);

    List<GoodfriendRelationship> selectByExample(GoodfriendRelationshipExample example);

    GoodfriendRelationship selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GoodfriendRelationship record, @Param("example") GoodfriendRelationshipExample example);

    int updateByExample(@Param("record") GoodfriendRelationship record, @Param("example") GoodfriendRelationshipExample example);

    int updateByPrimaryKeySelective(GoodfriendRelationship record);

    int updateByPrimaryKey(GoodfriendRelationship record);

    List<Map> getGoodFriendList(@Param("sql") String sql);
}