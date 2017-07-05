package com.xieyunhai.service.impl;

import com.xieyunhai.common.FieldType;
import com.xieyunhai.common.HttpResult;
import com.xieyunhai.common.HttpResultEnum;
import com.xieyunhai.entity.User;
import com.xieyunhai.mapper.UserMapper;
import com.xieyunhai.service.UserService;
import com.xieyunhai.util.HttpResultUtil;
import com.xieyunhai.util.MD5Util;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author noobit
 * @date 17-6-29 下午9:15
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public HttpResult removeUserByPrimaryKey(Integer id) {
        int row = userMapper.removeUserByPrimaryKey(id);
        if (row > 0) {
            return HttpResultUtil.success(HttpResultEnum.SUCCESS_DELETE);
        } else {
            return HttpResultUtil.error();
        }
    }

    @Override
    public HttpResult<User> saveUser(User user) {
        user.setPassword(MD5Util.MD5EncodeUtf8(user.getPassword()));
        int row = userMapper.saveUser(user);
        if (row > 0) {
            return HttpResultUtil.success(userMapper.getUserByPrimaryKey(user.getId()));
        } else {
            return HttpResultUtil.error();
        }
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
    public HttpResult login(String username, String password) {
        User user = userMapper.getUserByUsernameAndPassword(username, MD5Util.MD5EncodeUtf8(password));
        if (ObjectUtils.isEmpty(user)) {
            return HttpResultUtil.error(HttpResultEnum.ERROR_FIELD.getCode(), "用户名或密码错误");
        } else {
            return HttpResultUtil.success(user);
        }
    }

    @Override
    public HttpResult<Boolean> checkValid(String string, FieldType type) {
        return null;
    }

    @Override
    public HttpResult<Boolean> checkUserPrivilege(User user) {
        return null;
    }
}
