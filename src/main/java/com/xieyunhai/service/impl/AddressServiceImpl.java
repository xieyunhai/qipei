package com.xieyunhai.service.impl;

import com.xieyunhai.common.HttpResult;
import com.xieyunhai.common.HttpResultCode;
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
        } else {
            return HttpResultUtil.error(HttpResultCode.SERVER_ERROR.getCode());
        }
    }

    @Override
    public HttpResult<Address> updateAddressByPrimaryKey(Address address) {
        int count = addressMapper.updateAddressByPrimaryKeySelective(address);
        if (count > 0) {
            return HttpResultUtil.success(addressMapper.getAddressByPrimaryKey(address.getId()));
        } else {
            return HttpResultUtil.error(HttpResultCode.SERVER_ERROR.getCode());
        }
    }

    @Override
    public HttpResult removeAddressByPrimaryKey(Integer id) {
        int count = addressMapper.removeAddressByPrimaryKey(id);
        if (count > 0) {
            return HttpResultUtil.success();
        } else {
            return HttpResultUtil.error(HttpResultCode.SERVER_ERROR.getCode());
        }
    }



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
    public HttpResult<Address> saveAddressByUserId(Address address, Integer userId) {
        // 判断用户是否横向越权
        address.setUserId(userId);
        int count = addressMapper.saveAddressByUserId(address);
        if (count > 0) {
            return HttpResultUtil.success(addressMapper.getAddressByPrimaryKeyAndUserId(address.getId(), userId));
        } else {
            return HttpResultUtil.error(HttpResultCode.SERVER_ERROR.getCode());
        }
    }

    @Override
    public HttpResult<Address> updateAddressByPrimaryKeyAndUserId(Address address, Integer userId) {
        int count = addressMapper.updateAddressByPrimaryKeyAndUserIdSelective(address, userId);
        if (count > 0) {
            return HttpResultUtil.success(addressMapper.getAddressByPrimaryKeyAndUserId(address.getId(), userId));
        } else {
            return HttpResultUtil.error(HttpResultCode.SERVER_ERROR.getCode());
        }
    }

    @Override
    public HttpResult removeAddressByPrimaryKeyAndUserId(Integer id, Integer userId) {
        int count = addressMapper.removeAddressByPrimaryKeyAndUserId(id, userId);
        if (count > 0) {
            return HttpResultUtil.success();
        } else {
            return HttpResultUtil.error(HttpResultCode.SERVER_ERROR.getCode());
        }
    }
}
