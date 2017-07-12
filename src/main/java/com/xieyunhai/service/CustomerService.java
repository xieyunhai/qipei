package com.xieyunhai.service;

import com.xieyunhai.common.HttpResult;
import com.xieyunhai.entity.Customer;
import com.xieyunhai.entity.User;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author noobit
 * @date 17-6-29 下午8:59
 */
public interface CustomerService {


    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor =
            TransactionException.class)
    HttpResult<Customer> saveCustomer(Customer customer);

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor =
            TransactionException.class)
    HttpResult removeCustomer(Integer id);

    HttpResult<User> getCustomerByPrimaryKey(Integer id);

    HttpResult removeCustomerByPrimaryKey(Integer id);

    HttpResult<User> updateCustomerSelective(Customer customer);
}
