package com.xieyunhai.controller;

import com.xieyunhai.common.Const;
import com.xieyunhai.common.FieldType;
import com.xieyunhai.common.HttpResult;
import com.xieyunhai.service.UserService;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author noobit
 * @date 17-6-29 下午10:48
 */
@RestController
public class UserController {

    @Resource
    private UserService userService;

}
