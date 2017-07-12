package com.xieyunhai.controller.portal;

import com.xieyunhai.common.Const;
import com.xieyunhai.common.HttpResult;
import com.xieyunhai.entity.Address;
import com.xieyunhai.entity.User;
import com.xieyunhai.service.AddressService;
import com.xieyunhai.service.UserService;
import com.xieyunhai.util.HttpResultUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author noobit
 * @date 17-7-1 上午11:22
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;
    @Resource
    private AddressService addressService;

    @GetMapping("/{id}")
    public HttpResult<User> getUserByUserId(@PathVariable("id") Integer id, HttpSession session) {
        User curUser = User.getUserBySession(session);
        return userService.getUserByPrimaryKeyAndUserId(id, curUser.getId());
    }

    @DeleteMapping("/{id}")
    public HttpResult removeUserByPrimaryKeyAndUserId(@PathVariable("id") Integer id, HttpSession session) {
        User curUser = User.getUserBySession(session);
        return userService.removeUserByPrimaryKeyAndUserId(id, curUser.getId());
    }

    @PostMapping("/{id}")
    public HttpResult<User> updateUserByPrimaryKeyAndUserId(User user, HttpSession session) {
        User curUser = User.getUserBySession(session);
        return userService.updateUserByPrimaryKeyAndUserIdSelective(user, curUser.getId());
    }

    @GetMapping("/{userId}/address/{addressId}")
    public HttpResult<Address> getAddressByPrimaryKeyAndUserId(
            @PathVariable("addressId") Integer addressId,
            HttpSession session) {
        User curUser = User.getUserBySession(session);
        return addressService.getAddressByAddressIdAndUserId(addressId, curUser.getId());
    }

    @GetMapping("/{userId}/address")
    public HttpResult<List<Address>> listAddressesByUserId(HttpSession session) {
        User curUser = User.getUserBySession(session);
        return addressService.listAddressesByUserId(curUser.getId());
    }

    @PutMapping("/{userId}/address")
    public void saveAddress(Address address, HttpSession session) {
        User curUser = (User) session.getAttribute(Const.CURRENT_USER);
        addressService.saveAddressByUserId(address, curUser.getId());
    }

    @PostMapping("/{addressId}")
    public HttpResult<Address> updateAddressByPrimaryKeyAndUserId(
            Address address, @PathVariable("addressId") Integer addressId, HttpSession session) {
        address.setId(addressId);
        User curUser = (User) session.getAttribute(Const.CURRENT_USER);
        return addressService.updateAddressByPrimaryKeyAndUserId(address, curUser.getId());
    }

    @DeleteMapping("/{addressId}")
    public HttpResult removeAddressByPrimaryKeyAndUserId(@PathVariable("addressId") Integer addressId, HttpSession session) {
        User curUser = (User) session.getAttribute(Const.CURRENT_USER);
        return addressService.removeAddressByPrimaryKeyAndUserId(addressId, curUser.getId());
    }


    @PostMapping("/login")
    public HttpResult login(String username, String password, HttpSession session) {
        HttpResult httpResult = userService.login(username, password);
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
    public HttpResult<User> register(User user) {
        // todo 校验数据的合法性
        return userService.saveUser(user);
    }

}
