package com.xieyunhai.controller.portal;

import com.xieyunhai.common.HttpResult;
import com.xieyunhai.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author noobit
 * @date 17-7-1 上午11:22
 */
@RestController
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping("/login")
    public HttpResult login(String username, String password) {

    }
}
