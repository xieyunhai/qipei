package com.xieyunhai.service.impl;

import com.xieyunhai.common.FieldType;
import com.xieyunhai.common.HttpResult;
import com.xieyunhai.entity.User;
import com.xieyunhai.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author noobit
 * @date 17-6-29 下午9:15
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public HttpResult removeUserByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public HttpResult<User> saveUser(User user) {
        return null;
    }

    @Override
    public HttpResult<User> getUserByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public HttpResult<List<User>> listUsers() {
        return null;
    }

    @Override
    public HttpResult<User> updateUserByPrimaryKeySelective(User user) {
        return null;
    }

    @Override
    public HttpResult<Boolean> checkValid(String string, FieldType type) {
        return null;
    }
}
