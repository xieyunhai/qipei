package com.xieyunhai.service;

import com.xieyunhai.common.HttpResult;
import com.xieyunhai.entity.Customer;

/**
 * @author noobit
 * @date 17-6-29 下午8:59
 */
public interface CustomerService {

    HttpResult<Customer> saveCustomer(Customer customer);
}
