package com.xieyunhai.mapper;

import com.xieyunhai.entity.User;

import java.util.List;

import com.xieyunhai.mapper.provider.UserMapperProvider;
import com.xieyunhai.util.BaseMapper;
import org.apache.ibatis.annotations.*;
@Mapper
public interface UserMapper extends BaseMapper<User> {

    @SelectProvider(type = UserMapperProvider.class, method = "getUserByPrimaryKey")
    @ResultMap(value = "com.xieyunhai.mapper.UserMapper.userResult")
    User getUserByPrimaryKey(Integer id);

    @SelectProvider(type = UserMapperProvider.class, method = "listUsers")
    @ResultMap(value = "com.xieyunhai.mapper.UserMapper.userResult")
    List<User> listUsers();

    @InsertProvider(type = UserMapperProvider.class, method = "saveUser")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    void saveUserByUser(User user);

    @UpdateProvider(type = UserMapperProvider.class, method = "updateUserByPrimaryKeySelective")
    void updateUserUserSelective(User user);

    @Delete("DELETE FROM user WHERE id = #{id}")
    void removeUserByPrimaryKey(Integer id);

    @Select("SELECT * FROM user WHERE username = #{username} AND password = #{password}")
    @ResultMap(value = "com.xieyunhai.mapper.UserMapper.userResult")
    User getUserByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
}