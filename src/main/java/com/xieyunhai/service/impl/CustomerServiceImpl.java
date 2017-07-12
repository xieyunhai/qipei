package com.xieyunhai.service.impl;

import com.xieyunhai.common.HttpResult;
import com.xieyunhai.common.HttpResultEnum;
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

import javax.annotation.Resource;
import java.util.List;

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
    public HttpResult<List<Customer>> listCustomers() {
        return HttpResultUtil.success(customerMapper.listCustomers());
    }

    // backend
    @Override
    public HttpResult<Customer> getCustomerByPrimaryKey(Integer id) {
        return HttpResultUtil.success(customerMapper.getCustomerByPrimaryKey(id));
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor =
            TransactionException.class)
    public HttpResult<Customer> saveCustomer(Customer customer) {
        customer.setPassword(MD5Util.MD5EncodeUtf8(customer.getPassword()));
        customer.setClassKey((short) 1);
        userMapper.saveUserByUser(customer);
        customerMapper.saveCustomerByCustomer(customer);
        return HttpResultUtil.success(customerMapper.getCustomerByPrimaryKey(customer.getId()));
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor =
            TransactionException.class)
    public HttpResult<Customer> updateCustomerSelective(Customer customer) {
        customerMapper.updateCustomerByCustomerSelective(customer);
        return getCustomerByPrimaryKey(customer.getId());
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor =
            TransactionException.class)
    public HttpResult removeCustomerByPrimaryKey(Integer id) {
        customerMapper.removeCustomerByPrimaryKey(id);
        return HttpResultUtil.success(HttpResultEnum.SUCCESS_DELETE);
    }


    // portal
    @Override
    public HttpResult<Customer> getCustomerByPrimaryKeyAndUserId(Integer id, Integer userId) {
        return HttpResultUtil.success(customerMapper.getCustomerByPrimaryKeyAndUserId(id, userId));
    }

    @Override
    public HttpResult<Customer> updateCustomerByCustomerAndUserIdSelective(Customer customer, Integer userId) {
        customerMapper.updateCustomerByCustomerAndUserIdSelective(customer, userId);
        return HttpResultUtil.success(customerMapper.getCustomerByPrimaryKey(customer.getId()));
    }

    @Override
    public HttpResult<Customer> login(String username, String password) {
        return HttpResultUtil.success(customerMapper.getCustomerByUsernameAndPassword(username, password));
    }

    @Override
    public HttpResult removeCustomerByPrimaryKeyAndUserId(Integer id, Integer userId) {
        customerMapper.removeCustomerByPrimaryKeyAndUserId(id, userId);
        return HttpResultUtil.success(HttpResultEnum.SUCCESS_DELETE);
    }

    @Override
    public HttpResult<Customer> saveUser(Customer customer) {
        customerMapper.saveCustomerByCustomer(customer);
        return HttpResultUtil.success(customerMapper.getCustomerByPrimaryKey(customer.getId()));
    }
}
