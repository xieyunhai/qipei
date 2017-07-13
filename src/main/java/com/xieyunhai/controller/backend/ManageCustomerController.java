package com.xieyunhai.controller.backend;


import com.xieyunhai.common.HttpResult;
import com.xieyunhai.entity.Customer;
import com.xieyunhai.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author admin
 * @since 2017/7/11 14:28
 */
@RestController
@RequestMapping("/manage/customer")
public class ManageCustomerController {
    @Resource
    private CustomerService customerService;

    @GetMapping("")
    public HttpResult<List<Customer>> listCustomers() {
        return customerService.listCustomers();
    }

    @GetMapping("/{id}")
    public HttpResult<Customer> getCustomerById(@PathVariable("id") Integer id) {
        return customerService.getCustomerByPrimaryKey(id);
    }

    @DeleteMapping("/{id}")
    public HttpResult deleteCustomerById(@PathVariable("id") Integer id) {
        return customerService.removeCustomerByPrimaryKey(id);
    }

    @PostMapping("/{id}")
    public HttpResult<Customer> updateCustomerById(Customer customer, @PathVariable("id") Integer id) {
        customer.setId(id);
        return customerService.updateCustomerSelective(customer);
    }

    @PutMapping("/register")
    public HttpResult<Customer> register(Customer customer) {
        // todo 校验数据的合法性
        return customerService.saveCustomerByCustomer(customer);
    }
}
