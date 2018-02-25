package com.dais.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author xxp
 * @version 2017- 09- 20 14:30
 * @description
 * @copyright www.zhgtrade.com
 */
public interface CommonMapper {
    List<Map> getList(@Param("sql") String sql);
    Integer count(@Param("sql") String sql);
    Integer update(@Param("sql") String sql);
}
