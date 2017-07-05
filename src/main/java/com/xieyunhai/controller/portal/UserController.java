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
    public HttpResult<User> getUserByUserId(@PathVariable("id") Integer id) {
        return userService.getUserByPrimaryKey(id);
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

    @DeleteMapping("/{userId}")
    public HttpResult removeUserByPrimaryKeyAndUserId(HttpSession session, @PathVariable("userId") Integer userId) {
        User curUser = (User) session.getAttribute(Const.CURRENT_USER);
        return userService.removeUserByPrimaryKey(userId);
    }

    @PostMapping("/{userId}")
    public HttpResult<User> updateUserByPrimaryKeyAndUserId(HttpSession session, User user) {
        User curUser = (User) session.getAttribute(Const.CURRENT_USER);
        return userService.updateUserByPrimaryKeyAndUserIdSelective(user, curUser.getId());
    }

    @GetMapping("/{userId}/address/{addressId}")
    public HttpResult<Address> getAddressByPrimaryKeyAndUserId(
            @PathVariable("addressId") Integer addressId,
            @PathVariable("userId") Integer userId) {
        return addressService.getAddressByAddressIdAndUserId(addressId, userId);
    }

    @GetMapping("/{userId}/address")
    public HttpResult<List<Address>> listAddressesByUserId(@PathVariable("userId") Integer userId) {
        return addressService.listAddressesByUserId(userId);
    }
}
