package com.xieyunhai.service;

import com.xieyunhai.common.HttpResult;
import com.xieyunhai.entity.Customer;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author noobit
 * @date 17-6-29 下午8:59
 */
public interface CustomerService {

    // manage
    HttpResult<List<Customer>> listCustomers();

    HttpResult<Customer> getCustomerByPrimaryKey(Integer id);

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor =
            TransactionException.class)
    HttpResult<Customer> saveCustomer(Customer customer);

    HttpResult removeCustomerByPrimaryKey(Integer id);

    HttpResult<Customer> updateCustomerSelective(Customer customer);



    // portal
    HttpResult<Customer> getCustomerByPrimaryKeyAndUserId(Integer id, Integer userId);

    HttpResult<Customer> updateCustomerByCustomerAndUserIdSelective(Customer customer, Integer userId);

    HttpResult<Customer> login(String username, String password);

    HttpResult removeCustomerByPrimaryKeyAndUserId(Integer id, Integer userId);

    HttpResult<Customer> saveUser(Customer customer);
}
