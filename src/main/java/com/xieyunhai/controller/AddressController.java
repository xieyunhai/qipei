package com.xieyunhai.controller;

import com.xieyunhai.domin.Address;
import com.xieyunhai.service.AddressService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author noobit
 * @date 17-6-29 下午10:46
 */
@RestController
public class AddressController {

    @Resource
    private AddressService addressService;

    @PostMapping("address")
    public void save(Address address) {
        addressService.save(address);
    }
}
