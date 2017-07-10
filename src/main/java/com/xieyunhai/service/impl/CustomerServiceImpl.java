package com.xieyunhai.service.impl;

import com.xieyunhai.common.HttpResult;
import com.xieyunhai.entity.Customer;
import com.xieyunhai.entity.User;
import com.xieyunhai.mapper.CustomerMapper;
import com.xieyunhai.mapper.UserMapper;
import com.xieyunhai.service.CustomerService;
import com.xieyunhai.util.HttpResultUtil;
import com.xieyunhai.util.MD5Util;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author noobit
 * @date 17-6-29 下午9:08
 */
@Service
public class CustomerServiceImpl implements CustomerService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private CustomerMapper customerMapper;

    @Override
    public HttpResult<User> saveUser(Customer customer) {
        customer.setPassword(MD5Util.MD5EncodeUtf8(customer.getPassword()));
        customerMapper.saveCustomer(customer);
        return HttpResultUtil.success(customerMapper.getCustomerByPrimaryKey(customer.getId()));
    }
}
