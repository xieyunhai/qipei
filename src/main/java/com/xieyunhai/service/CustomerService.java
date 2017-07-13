package com.xieyunhai.service;

import com.xieyunhai.common.HttpResult;
import com.xieyunhai.entity.Customer;
import org.apache.ibatis.annotations.Select;
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

    // backend
    HttpResult<List<Customer>> listCustomers();

    HttpResult<Customer> getCustomerByPrimaryKey(Integer id);

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor =
            TransactionException.class)
    HttpResult<Customer> saveCustomerByCustomer(Customer customer);

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor =
            TransactionException.class)
    HttpResult removeCustomerByPrimaryKey(Integer id);

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor =
            TransactionException.class)
    HttpResult<Customer> updateCustomerSelective(Customer customer);



    // portal
    HttpResult<Customer> getCustomerByPrimaryKeyAndUserId(Integer id, Integer userId);

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor =
            TransactionException.class)
    HttpResult<Customer> updateCustomerByCustomerAndUserIdSelective(Customer customer, Integer userId);

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor =
            TransactionException.class)
    HttpResult removeCustomerByPrimaryKeyAndUserId(Integer id, Integer userId);

    HttpResult<Customer> login(String username, String password);
}
