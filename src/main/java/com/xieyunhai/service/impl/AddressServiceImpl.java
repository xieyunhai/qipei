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

    // backend
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
        addressMapper.saveAddress(address);
        return HttpResultUtil.success(addressMapper.getAddressByPrimaryKey(address.getId()));

    }

    @Override
    public HttpResult<Address> updateAddress(Address address) {
        addressMapper.updateAddressSelective(address);
        return HttpResultUtil.success(addressMapper.getAddressByPrimaryKey(address.getId()));
    }

    @Override
    public HttpResult removeAddressByPrimaryKey(Integer id) {
        addressMapper.removeAddressByPrimaryKey(id);
        return HttpResultUtil.success(HttpResultEnum.SUCCESS_DELETE);
    }



    // portal
    @Override
    public HttpResult<List<Address>> listAddressesByUserId(Integer userId) {
        List<Address> addressList = addressMapper.listAddressesByUserId(userId);
        return HttpResultUtil.success(addressList);
    }

    @Override
    public HttpResult<Address> getAddressByPrimaryKeyAndUserId(Integer id, Integer userId) {
        return HttpResultUtil.success(addressMapper.getAddressByPrimaryKeyAndUserId(id, userId));
    }

    @Override
    public HttpResult<Address> saveAddressByAddressAndUserId(Address address, Integer userId) {
        address.setUserId(userId);
        addressMapper.saveAddressByUserId(address);
        return HttpResultUtil.success(addressMapper.getAddressByPrimaryKeyAndUserId(address.getId(), userId));
    }

    @Override
    public HttpResult<Address> updateAddressByAddressAndUserId(Address address, Integer userId) {
        addressMapper.updateAddressByUserIdSelective(address, userId);
        return HttpResultUtil.success(addressMapper.getAddressByPrimaryKeyAndUserId(address.getId(), userId));
    }

    @Override
    public HttpResult removeAddressByPrimaryKeyAndUserId(Integer id, Integer userId) {
        addressMapper.removeAddressByPrimaryKeyAndUserId(id, userId);
        return HttpResultUtil.success(HttpResultEnum.SUCCESS_DELETE);
    }

}
