package com.dais.service.impl;

import com.dais.mapper.AddressPoolMapper;
import com.dais.model.AddressPool;
import com.dais.model.AddressPoolExample;
import com.dais.service.AddressPoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author GanZhen
 * @version 2017- 08- 19 11:36
 * @description
 * @copyright www.zhgtrade.com
 */
@Service
public class AddressPoolServiceImpl implements AddressPoolService {

    @Autowired
    private AddressPoolMapper addressPoolMapper;

    @Override
    public int insertAddressPool(AddressPool addressPool) {
        return this.addressPoolMapper.insertSelective(addressPool);
    }

}
