package com.xieyunhai.controller.backend;


import com.xieyunhai.common.HttpResult;
import com.xieyunhai.entity.Customer;
import com.xieyunhai.entity.User;
import com.xieyunhai.service.CustomerService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author admin
 * @since 2017/7/11 14:28
 */
@RestController
@RequestMapping("/manage/customer")
public class ManageCustomerController {
    @Resource
    private CustomerService customerService;

    @PutMapping("/register")
    public HttpResult<Customer> register(Customer customer) {
        // todo 校验数据的合法性
        return customerService.saveCustomer(customer);
    }


}
