package com.dais.mapper;

import com.dais.model.ChatRoomMsg;
import com.dais.model.ChatRoomMsgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ChatRoomMsgMapper {
    int countByExample(ChatRoomMsgExample example);

    int deleteByExample(ChatRoomMsgExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ChatRoomMsg record);

    int insertSelective(ChatRoomMsg record);

    List<ChatRoomMsg> selectByExampleWithBLOBs(ChatRoomMsgExample example);

    List<ChatRoomMsg> selectByExample(ChatRoomMsgExample example);

    ChatRoomMsg selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ChatRoomMsg record, @Param("example") ChatRoomMsgExample example);

    int updateByExampleWithBLOBs(@Param("record") ChatRoomMsg record, @Param("example") ChatRoomMsgExample example);

    int updateByExample(@Param("record") ChatRoomMsg record, @Param("example") ChatRoomMsgExample example);

    int updateByPrimaryKeySelective(ChatRoomMsg record);

    int updateByPrimaryKeyWithBLOBs(ChatRoomMsg record);

    int updateByPrimaryKey(ChatRoomMsg record);
}