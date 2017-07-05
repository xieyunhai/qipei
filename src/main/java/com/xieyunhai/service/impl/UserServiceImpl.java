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
import java.util.Objects;

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
            return HttpResultUtil.success(null, HttpResultEnum.SUCCESS_DELETE.getCode());
        }
        return HttpResultUtil.success();
    }

    @Override
    public HttpResult<User> saveUser(User user) {
        user.setPassword(MD5Util.MD5EncodeUtf8(user.getPassword()));
        userMapper.saveUser(user);
        return HttpResultUtil.success(userMapper.getUserByPrimaryKey(user.getId()));
    }

    @Override
    public HttpResult<User> getUserByPrimaryKey(Integer id) {
        return HttpResultUtil.success(userMapper.getUserByPrimaryKey(id));
    }

    @Override
    public HttpResult<List<User>> listUsers() {
        return HttpResultUtil.success(userMapper.listUsers());
    }

    @Override
    public HttpResult<User> updateUserByPrimaryKeySelective(User user) {
        int row = userMapper.updateUserByPrimaryKeySelective(user);
        if (row > 0) {
            return HttpResultUtil.success(userMapper.getUserByPrimaryKey(user.getId()), HttpResultEnum.SUCCESS_UPDATE.getCode());
        }
        return HttpResultUtil.error(HttpResultEnum.NOT_EXIST.getCode());
    }

    @Override
    public HttpResult<User> login(String username, String password) {
        User user = userMapper.getUserByUsernameAndPassword(username, MD5Util.MD5EncodeUtf8(password));
        if (ObjectUtils.isEmpty(user)) {
            return HttpResultUtil.error(HttpResultEnum.ERROR_FIELD.getCode(), "用户名或密码错误");
        }
        return HttpResultUtil.success(user);
    }

    @Override
    public HttpResult<User> updateUserByPrimaryKeyAndUserIdSelective(User user, Integer userId) {
        if (user.getId().intValue() != userId.intValue()) {
            return HttpResultUtil.error(HttpResultEnum.PERMISSION_DENIED.getCode());
        }
        // 加密密码
        user.setId(userId);
        if (!ObjectUtils.isEmpty(user.getPassword())) {
            user.setPassword(MD5Util.MD5EncodeUtf8(user.getPassword()));
        }
        int row = userMapper.updateUserByPrimaryKeySelective(user);
        if (row > 0) {
            return HttpResultUtil.success(userMapper.getUserByPrimaryKey(user.getId()), HttpResultEnum.SUCCESS_UPDATE.getCode());
        }
        return HttpResultUtil.error(HttpResultEnum.NOT_EXIST.getCode());
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
