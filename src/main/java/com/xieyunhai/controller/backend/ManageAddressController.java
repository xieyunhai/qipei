package com.xieyunhai.controller.backend;

import com.xieyunhai.common.HttpResult;
import com.xieyunhai.entity.Address;
import com.xieyunhai.service.AddressService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author admin
 * @since 2017/6/30 10:56
 */
@RestController
@RequestMapping("/manage/address")
public class ManageAddressController {
    @Resource
    private AddressService addressService;

    @GetMapping("/")
    public HttpResult<List<Address>> listAddresses() {
        return addressService.listAddresses();
    }

    @GetMapping("/{id}")
    public HttpResult<Address> getAddress(@PathVariable("id") Integer id) {
        return addressService.getAddressByPrimaryKey(id);
    }

    @PostMapping("/{id}")
    public HttpResult<Address> updateAddressById(Address address, @PathVariable("id") int id) {
        address.setId(id);
        return addressService.updateAddress(address);
    }

    @PutMapping("/")
    public HttpResult<Address> addAddress(Address address) {
        return addressService.saveAddress(address);
    }

    @DeleteMapping("/{id}")
    public HttpResult deleteAddressById(@PathVariable("id") Integer id) {
        return addressService.removeAddressByPrimaryKey(id);
    }

}
