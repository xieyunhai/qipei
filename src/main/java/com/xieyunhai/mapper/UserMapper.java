package com.xieyunhai.mapper;

import com.xieyunhai.entity.User;

import java.util.List;

import com.xieyunhai.mapper.provider.UserMapperProvider;
import com.xieyunhai.util.BaseMapper;
import org.apache.ibatis.annotations.*;

public interface UserMapper extends BaseMapper<User> {

    @SelectProvider(type = UserMapperProvider.class, method = "getUserByPrimaryKey")
    @ResultMap(value = "com.xieyunhai.mapper.UserMapper.userResult")
    User getUserByPrimaryKey(Integer id);

    @SelectProvider(type = UserMapperProvider.class, method = "listUsers")
    @ResultMap(value = "com.xieyunhai.mapper.UserMapper.userResult")
    List<User> listUsers();

    @InsertProvider(type = UserMapperProvider.class, method = "saveUser")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    int saveUser(User user);

    @UpdateProvider(type = UserMapperProvider.class, method = "updateUserByPrimaryKeySelective")
    int updateUserByPrimaryKeySelective(User user);

    @Delete("DELETE FROM user WHERE id = #{id}")
    int removeUserByPrimaryKey(Integer id);

    @Select("SELECT * FROM user WHERE username = #{username} AND password = #{password}")
    @ResultMap(value = "com.xieyunhai.mapper.UserMapper.userResult")
    User getUserByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
}