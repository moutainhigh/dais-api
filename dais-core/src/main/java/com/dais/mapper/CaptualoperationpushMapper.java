package com.dais.mapper;

import com.dais.model.Captualoperationpush;
import com.dais.model.CaptualoperationpushExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CaptualoperationpushMapper {
    int countByExample(CaptualoperationpushExample example);

    int deleteByExample(CaptualoperationpushExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Captualoperationpush record);

    int insertSelective(Captualoperationpush record);

    List<Captualoperationpush> selectByExample(CaptualoperationpushExample example);

    Captualoperationpush selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Captualoperationpush record, @Param("example") CaptualoperationpushExample example);

    int updateByExample(@Param("record") Captualoperationpush record, @Param("example") CaptualoperationpushExample example);

    int updateByPrimaryKeySelective(Captualoperationpush record);

    int updateByPrimaryKey(Captualoperationpush record);
}