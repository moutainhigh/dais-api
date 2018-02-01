package com.dais.mapper;

import com.dais.model.PrivatechatMsg;
import com.dais.model.PrivatechatMsgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PrivatechatMsgMapper {
    int countByExample(PrivatechatMsgExample example);

    int deleteByExample(PrivatechatMsgExample example);

    int deleteByPrimaryKey(String id);

    int insert(PrivatechatMsg record);

    int insertSelective(PrivatechatMsg record);

    List<PrivatechatMsg> selectByExampleWithBLOBs(PrivatechatMsgExample example);

    List<PrivatechatMsg> selectByExample(PrivatechatMsgExample example);

    PrivatechatMsg selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") PrivatechatMsg record, @Param("example") PrivatechatMsgExample example);

    int updateByExampleWithBLOBs(@Param("record") PrivatechatMsg record, @Param("example") PrivatechatMsgExample example);

    int updateByExample(@Param("record") PrivatechatMsg record, @Param("example") PrivatechatMsgExample example);

    int updateByPrimaryKeySelective(PrivatechatMsg record);

    int updateByPrimaryKeyWithBLOBs(PrivatechatMsg record);

    int updateByPrimaryKey(PrivatechatMsg record);
}