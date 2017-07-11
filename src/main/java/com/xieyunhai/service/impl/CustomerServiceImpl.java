package com.xieyunhai.service.impl;

import com.xieyunhai.common.HttpResult;
import com.xieyunhai.entity.Customer;
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
        int row = userMapper.saveUser(customer);
        if (row < 0) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return HttpResultUtil.error();
        }
        row = customerMapper.saveCustomer(customer);
        if (row > 0) {
            return HttpResultUtil.success(customerMapper.getCustomerByPrimaryKey(customer.getId()));
        }
        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        return HttpResultUtil.error();
    }
}
