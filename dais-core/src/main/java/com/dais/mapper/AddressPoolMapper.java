package com.dais.mapper;

import com.dais.model.AddressPool;
import com.dais.model.AddressPoolExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AddressPoolMapper {
    int insertSelective(AddressPool record);

    List<AddressPool> selectByExample(AddressPoolExample example);

    String getAssignAddress(Integer symbol);

    int countNormal(Integer symbol);
}