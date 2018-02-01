package com.dais.service.impl;

import com.common.utils.CollectionUtils;
import com.dais.mapper.PublicBlockAccountMapper;
import com.dais.model.PublicBlockAccount;
import com.dais.model.PublicBlockAccountExample;
import com.dais.service.PublicBlockAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xxp
 * @version 2017- 10- 10 19:35
 * @description
 * @copyright www.zhgtrade.com
 *
 */
@Service
public class PublicBlockAccountServiceImpl implements PublicBlockAccountService{

    @Autowired
    private PublicBlockAccountMapper publicBlockAccountMapper;

    @Override
    public PublicBlockAccount getPublicBlockAccount(String address) {
        PublicBlockAccountExample example = new PublicBlockAccountExample();
        example.createCriteria().andAddressEqualTo(address);
        List<PublicBlockAccount> list = this.publicBlockAccountMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)){
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<PublicBlockAccount> getPublicBlockAccount(int symbol) {
        PublicBlockAccountExample example = new PublicBlockAccountExample();
        example.createCriteria().andSymbolEqualTo(symbol);
        List<PublicBlockAccount> list = this.publicBlockAccountMapper.selectByExample(example);
        return list;
    }
}
