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
     * @return success: HttpResult
     */
    HttpResult removeUserByPrimaryKey(Integer id);

    /**
     * 保存用户 - 管理员用户使用
     * @param user User
     * @return success: HttpResult<User>
     */
    HttpResult<User> saveUser(User user);

    /**
     * 获取用户 - 管理员用户调用
     * @param id primary key
     * @return success: HttpResult<User>
     */
    HttpResult<User> getUserByPrimaryKey(Integer id);

    /**
     * 显示所有用户 - 管理员用户调用
     * @return success: HttpResult<List<User>>
     */
    HttpResult<List<User>> listUsers();

    /**
     * 更新用户 - 管理员调用
     * @param user User
     * @return success: HttpResult<User>
     */
    HttpResult<User> updateUserByPrimaryKeySelective(User user);

    /**
     * 用户登陆 - 前端和后端共用
     * @param username username
     * @param password password
     * @return success: HttpResult<User>
     */
    HttpResult<User> login(String username, String password);

    /**
     * 更新用户 - 当前用户调用
     * @param user User
     * @param userId Integer
     * @return success: HttpResult<User>
     */
    HttpResult<User> updateUserByPrimaryKeyAndUserIdSelective(User user, Integer userId);

    /**
     * 验证字段是否可用
     * @param string string
     * @param type type
     * @return success: HttpResult<Boolean>
     */
    HttpResult<Boolean> checkValid(String string, FieldType type);

    /**
     * 验证用户的权限
     * @param user User
     * @return success: HttpResult<Boolean>
     */
    HttpResult<Boolean> checkUserPrivilege(User user);
}
