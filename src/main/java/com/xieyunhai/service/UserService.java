package com.xieyunhai.service;

import com.xieyunhai.common.FieldType;
import com.xieyunhai.common.HttpResult;
import com.xieyunhai.entity.User;

import java.util.List;

/**
 * @author noobit
 * @date 17-6-29 下午9:01
 */
public interface UserService {

    /**
     * 删除用户 - 管理员使用
     * @param id primary key
     * @return success: null
     */
    HttpResult removeUserByPrimaryKey(Integer id);

    /**
     * 保存用户 - 管理员用户使用
     * @param user
     * @return
     */
    HttpResult<User> saveUser(User user);

    HttpResult<User> getUserByPrimaryKey(Integer id);

    HttpResult<List<User>> listUsers();

    HttpResult<User> updateUserByPrimaryKeySelective(User user);

    /**
     * 用户登陆 - 前端和后端共用
     * @param username
     * @param password
     * @return
     */
    HttpResult<User> login(String username, String password);

    /**
     * 验证
     * @param string
     * @param type
     * @return
     */
    HttpResult<Boolean> checkValid(String string, FieldType type);

    /**
     * 验证用户的权限
     * @param user user
     * @return success: true or false
     */
    HttpResult<Boolean> checkUserPrivilege(User user);
}
