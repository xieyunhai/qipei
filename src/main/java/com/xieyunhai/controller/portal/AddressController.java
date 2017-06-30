package com.xieyunhai.controller.portal;

import com.xieyunhai.common.HttpResult;
import com.xieyunhai.entity.Address;
import com.xieyunhai.service.AddressService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author noobit
 * @date 17-6-29 下午10:46
 */
@RestController
@RequestMapping("/address")
public class AddressController {

    @Resource
    private AddressService addressService;

    @GetMapping("/")
    public HttpResult<List<Address>> listAddressesByUserId() {
        // todo 通过 session 获得 userId
        HttpResult<List<Address>> httpResult = addressService.listAddressesByUserId(1);
        return httpResult;
    }

    @GetMapping("/{id}")
    public HttpResult<Address> getAddressByPrimaryKeyAndUserId(@PathVariable("id") Integer id) {
        return addressService.getAddressByPrimaryKeyAndUserId(id, 1);
    }

    @PutMapping("/")
    public void saveAddress(Address address) {
         addressService.saveAddressByUserId(address, 1);
    }

    @PostMapping("/{id}")
    public HttpResult<Address> updateAddressByPrimaryKeyAndUserId(Address address, @PathVariable("id") Integer id) {
        address.setId(id);
        return addressService.updateAddressByPrimaryKeyAndUserId(address, 1);
    }

    @DeleteMapping("/{id}")
    public HttpResult removeAddressByPrimaryKeyAndUserId(@PathVariable("id") Integer id) {
        return addressService.removeAddressByPrimaryKeyAndUserId(id, 1);
    }
}
