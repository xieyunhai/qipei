package com.xieyunhai.service.impl;

import com.xieyunhai.common.HttpResult;
import com.xieyunhai.common.HttpResultEnum;
import com.xieyunhai.entity.Address;
import com.xieyunhai.mapper.AddressMapper;
import com.xieyunhai.service.AddressService;
import com.xieyunhai.util.HttpResultUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author noobit
 * @date 17-6-29 下午9:06
 */
@Service
public class AddressServiceImpl implements AddressService {

    @Resource
    private AddressMapper addressMapper;

    @Override
    public HttpResult<List<Address>> listAddresses() {
        return HttpResultUtil.success(addressMapper.listAddresses());
    }

    @Override
    public HttpResult<Address> getAddressByPrimaryKey(Integer id) {
        return HttpResultUtil.success(addressMapper.getAddressByPrimaryKey(id));
    }

    @Override
    public HttpResult<Address> saveAddress(Address address) {
        int count = addressMapper.saveAddress(address);
        if (count > 0) {
            return HttpResultUtil.success(addressMapper.getAddressByPrimaryKey(address.getId()));
        }
        return HttpResultUtil.error(HttpResultEnum.SERVER_ERROR);
    }

    @Override
    public HttpResult<Address> updateAddressByPrimaryKey(Address address) {
        addressMapper.updateAddressByPrimaryKeySelective(address);
        return HttpResultUtil.success(addressMapper.getAddressByPrimaryKey(address.getId()));
    }

    @Override
    public HttpResult removeAddressByPrimaryKey(Integer id) {
        int count = addressMapper.removeAddressByPrimaryKey(id);
        if (count > 0) {
            return HttpResultUtil.success();
        }
        return HttpResultUtil.error(HttpResultEnum.SERVER_ERROR);
    }


    @Override
    public HttpResult<List<Address>> listAddressesByUserId(Integer userId) {
        List<Address> addressList = addressMapper.listAddressesByUserId(userId);
        return HttpResultUtil.success(addressList);
    }

    @Override
    public HttpResult<Address> getAddressByAddressIdAndUserId(Integer id, Integer userId) {
        return HttpResultUtil.success(addressMapper.getAddressByPrimaryKeyAndUserId(id, userId));
    }

    @Override
    public HttpResult<Address> saveAddressByUserId(Address address, Integer userId) {
        address.setUserId(userId);
        int count = addressMapper.saveAddressByUserId(address);
        if (count > 0) {
            return HttpResultUtil.success(addressMapper.getAddressByPrimaryKeyAndUserId(address.getId(), userId));
        }
        return HttpResultUtil.error(HttpResultEnum.SERVER_ERROR);
    }

    @Override
    public HttpResult<Address> updateAddressByPrimaryKeyAndUserId(Address address, Integer userId) {
        int count = addressMapper.updateAddressByPrimaryKeyAndUserIdSelective(address, userId);
        if (count > 0) {
            return HttpResultUtil.success(addressMapper.getAddressByPrimaryKeyAndUserId(address.getId(), userId));
        }
        return HttpResultUtil.error(HttpResultEnum.SERVER_ERROR);
    }

    @Override
    public HttpResult removeAddressByPrimaryKeyAndUserId(Integer id, Integer userId) {

        return null;
    }

}
