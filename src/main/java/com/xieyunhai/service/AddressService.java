package com.xieyunhai.service;

import com.xieyunhai.common.HttpResult;
import com.xieyunhai.entity.Address;

import java.util.List;

/**
 * @author noobit
 * @date 17-6-29 下午8:58
 */
public interface AddressService {

    // backend
    HttpResult<List<Address>> listAddresses();

    HttpResult<Address> getAddressByPrimaryKey(Integer id);

    HttpResult<Address> saveAddress(Address address);

    HttpResult<Address> updateAddress(Address address);

    HttpResult removeAddressByPrimaryKey(Integer id);


    // portal
    HttpResult<List<Address>> listAddressesByUserId(Integer userId);

    HttpResult<Address> getAddressByPrimaryKeyAndUserId(Integer id, Integer userId);

    HttpResult<Address> saveAddressByAddressAndUserId(Address address, Integer userId);

    HttpResult<Address> updateAddressByAddressAndUserId(Address address, Integer userId);

    HttpResult removeAddressByPrimaryKeyAndUserId(Integer id, Integer userId);
}
