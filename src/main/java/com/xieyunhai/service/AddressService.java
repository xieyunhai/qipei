package com.xieyunhai.service;

import com.xieyunhai.common.HttpResult;
import com.xieyunhai.entity.Address;

import java.util.List;

/**
 * @author noobit
 * @date 17-6-29 下午8:58
 */
public interface AddressService {

    /**
     * list all address
     * @return success: addresses
     */
    HttpResult<List<Address>> listAddresses();

    /**
     * get address
     * @param id primary key
     * @return success: address or null
     */
    HttpResult<Address> getAddressByPrimaryKey(Integer id);

    /**
     * 保存地址
     * @param address address
     * @return success: address, fail: error
     */
    HttpResult<Address> saveAddress(Address address);

    /**
     * 更新地址
     * @param address address
     * @return success: address, fail: error
     */
    HttpResult<Address> updateAddress(Address address);

    /**
     * 删除地址
     * @param id primary key
     * @return success: null, fail: error
     */
    HttpResult removeAddressByPrimaryKey(Integer id);

    HttpResult<List<Address>> listAddressesByUserId(Integer userId);

    HttpResult<Address> getAddressByAddressIdAndUserId(Integer id, Integer userId);

    HttpResult<Address> saveAddressByUserId(Address address, Integer userId);

    HttpResult<Address> updateAddressByPrimaryKeyAndUserId(Address address, Integer userId);

    HttpResult removeAddressByPrimaryKeyAndUserId(Integer id, Integer userId);
}
