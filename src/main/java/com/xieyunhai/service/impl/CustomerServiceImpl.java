package com.xieyunhai.service.impl;

import com.xieyunhai.common.HttpResult;
import com.xieyunhai.common.HttpResultEnum;
import com.xieyunhai.entity.Customer;
import com.xieyunhai.entity.User;
import com.xieyunhai.mapper.CustomerMapper;
import com.xieyunhai.mapper.UserMapper;
import com.xieyunhai.service.CustomerService;
import com.xieyunhai.util.HttpResultUtil;
import com.xieyunhai.util.MD5Util;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

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
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor =
            TransactionException.class)
    public HttpResult<Customer> saveCustomer(Customer customer) {
        customer.setPassword(MD5Util.MD5EncodeUtf8(customer.getPassword()));
        customer.setClassKey((short) 1);
        userMapper.saveUser(customer);
        customerMapper.saveCustomer(customer);
        return HttpResultUtil.success(customerMapper.getCustomerByPrimaryKey(customer.getId()));
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor =
            TransactionException.class)
    public HttpResult removeCustomer(Integer id) {
        customerMapper.removeCustomerByPrimaryKey(id);
        return HttpResultUtil.success();
    }

    @Override
    public HttpResult<User> getCustomerByPrimaryKey(Integer id) {
        return HttpResultUtil.success(customerMapper.getCustomerByPrimaryKey(id));
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor =
            TransactionException.class)
    public HttpResult removeCustomerByPrimaryKey(Integer id) {
        customerMapper.removeCustomerByPrimaryKey(id);
        return HttpResultUtil.success(HttpResultEnum.SUCCESS_DELETE);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor =
            TransactionException.class)
    public HttpResult<User> updateCustomerSelective(Customer customer) {
        customerMapper.updateCustomerSelective(customer);
        return getCustomerByPrimaryKey(customer.getId());
    }
}
