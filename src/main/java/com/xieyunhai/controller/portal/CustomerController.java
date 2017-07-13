package com.xieyunhai.controller.portal;

import com.xieyunhai.common.Const;
import com.xieyunhai.common.HttpResult;
import com.xieyunhai.entity.Address;
import com.xieyunhai.entity.Customer;
import com.xieyunhai.entity.User;
import com.xieyunhai.service.AddressService;
import com.xieyunhai.service.CustomerService;
import com.xieyunhai.util.HttpResultUtil;
import com.xieyunhai.util.MD5Util;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author noobit
 * @date 17-7-1 上午11:22
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Resource
    private CustomerService customerService;
    @Resource
    private AddressService addressService;

    @GetMapping("/{id}")
    public HttpResult<Customer> getUserByUserId(@PathVariable("id") Integer id, HttpSession session) {
        User user = User.getUserBySession(session);
        return customerService.getCustomerByPrimaryKeyAndUserId(id, user.getId());
    }

    @PostMapping("/{id}")
    public HttpResult<Customer> updateUserByPrimaryKeyAndUserId(@PathVariable("id") Integer id, Customer customer, HttpSession session) {
        User user = User.getUserBySession(session);
        customer.setId(id);
        if (!ObjectUtils.isEmpty(customer.getPassword())) {
            customer.setPassword(MD5Util.MD5EncodeUtf8(customer.getPassword()));
        }
        return customerService.updateCustomerByCustomerAndUserIdSelective(customer, user.getId());
    }

    @DeleteMapping("/{id}")
    public HttpResult removeUserByPrimaryKeyAndUserId(@PathVariable("id") Integer id, HttpSession session) {
        User user = User.getUserBySession(session);
        return customerService.removeCustomerByPrimaryKeyAndUserId(id, user.getId());
    }

    @GetMapping("/{userId}/address/{addressId}")
    public HttpResult<Address> getAddressByPrimaryKeyAndUserId(
            @PathVariable("addressId") Integer addressId,
            HttpSession session) {
        User user = User.getUserBySession(session);
        return addressService.getAddressByPrimaryKeyAndUserId(addressId, user.getId());
    }

    @GetMapping("/{userId}/address")
    public HttpResult<List<Address>> listAddressesByUserId(HttpSession session) {
        User user = User.getUserBySession(session);
        return addressService.listAddressesByUserId(user.getId());
    }

    @PutMapping("/{userId}/address")
    public HttpResult<Address> saveAddressByAddressAndUserId(Address address, HttpSession session) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        return addressService.saveAddressByAddressAndUserId(address, user.getId());
    }

    @PostMapping("/{userId}/address/{addressId}")
    public HttpResult<Address> updateAddressByAddressAndUserId(
            Address address, @PathVariable("addressId") Integer addressId, HttpSession session) {
        address.setId(addressId);
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        return addressService.updateAddressByAddressAndUserId(address, user.getId());
    }

    @DeleteMapping("/{userId}/address/{addressId}")
    public HttpResult removeAddressByPrimaryKeyAndUserId(@PathVariable("addressId") Integer addressId, HttpSession session) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        return addressService.removeAddressByPrimaryKeyAndUserId(addressId, user.getId());
    }


    @PostMapping("/login")
    public HttpResult login(String username, String password, HttpSession session) {
        HttpResult httpResult = customerService.login(username, MD5Util.MD5EncodeUtf8(password));
        if (httpResult.getSuccess()) {
            session.setAttribute(Const.CURRENT_USER, httpResult.getData());
        }
        return httpResult;
    }

    @PostMapping("/logout")
    public HttpResult logout(HttpSession session) {
        session.removeAttribute(Const.CURRENT_USER);
        return HttpResultUtil.success();
    }

    @PutMapping("/register")
    public HttpResult<Customer> register(Customer customer) {
        // todo 校验数据的合法性
        return customerService.saveCustomerByCustomer(customer);
    }

}
