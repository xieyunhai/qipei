package com.xieyunhai.service.impl;

import com.xieyunhai.domin.Address;
import com.xieyunhai.mapper.AddressMapper;
import com.xieyunhai.service.AddressService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author noobit
 * @date 17-6-29 下午9:06
 */
@Service
public class AddressServiceImpl implements AddressService {

    @Resource
    private AddressMapper addressMapper;

    @Override
    public void save(Address address) {
        addressMapper.save(address);
    }
}
