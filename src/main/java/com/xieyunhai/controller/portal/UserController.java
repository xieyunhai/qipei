package com.xieyunhai.controller.portal;

import com.xieyunhai.common.Const;
import com.xieyunhai.common.HttpResult;
import com.xieyunhai.entity.User;
import com.xieyunhai.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @author noobit
 * @date 17-7-1 上午11:22
 */
@RestController
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping("/login")
    public HttpResult login(String username, String password, HttpSession session) {
        HttpResult httpResult = userService.login(username, password);
        if (httpResult.getSuccess()) {
            session.setAttribute(Const.CURRENT_USER, httpResult.getData());
        }
        return httpResult;
    }

    @PutMapping("/register")
    public HttpResult<User> register(User user) {
        // todo 校验数据的合法性
        return userService.saveUser(user);
    }
}
