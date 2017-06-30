package com.xieyunhai.mapper;

import com.xieyunhai.common.HttpResult;
import com.xieyunhai.entity.Address;
import com.xieyunhai.mapper.provider.AddressMapperProvider;
import com.xieyunhai.util.BaseMapper;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author noobit
 * @date 17-6-29 下午9:16
 */
@Mapper
public interface AddressMapper extends BaseMapper<Address> {

    /**
     * 获取所有地址 - 管理员用户调用
     * @return addresses
     */
    @Select("SELECT * FROM address")
    @ResultMap(value = "com.xieyunhai.mapper.AddressMapper.addressResult")
    List<Address> listAddresses();

    /**
     * 获取单个地址 - 管理员用户调用
     * @param id primary key
     * @return address
     */
    @Select("SELECT * FROM address WHERE id = #{id}")
    @ResultMap(value = "com.xieyunhai.mapper.AddressMapper.addressResult")
    Address getAddressByPrimaryKey(Integer id);

    /**
     * 增加地址 - 管理员用户和当前用户共用
     * @param address address
     * @return count
     */
    @Insert("INSERT INTO address (user_id, name, receive_name, alias, post_code, telephone, " +
            "cellphone, province, district, city, street, remarks, status, create_time, update_time) " +
            "VALUES (#{userId}, #{name}, #{receiveName}, #{alias}, #{postCode}, #{telephone}, " +
            "#{cellphone}, #{province}, #{district}, #{city}, #{street}, #{remarks}, #{status}, now(), now())")
    @Options(useGeneratedKeys = true, keyColumn = "id")
    int saveAddress(Address address);

    /**
     * 更新地址全部内容 - 管理员用户调用
     * @param address address
     * @return count
     */
    @Update("UPDATE address SET name = #{name}, receive_name = #{receiveName}, alias = #{alias}, " +
            "post_code = #{postCode}, telephone = #{telephone}, cellphone = #{cellphone}, " +
            "province = #{province}, district = #{district}, city = #{city}, street = #{street}, " +
            "remarks = #{remarks}, status = #{status}, update_time = now() WHERE id = #{id}")
    int updateAddressByPrimaryKey(Address address);

    /**
     * 选择性更新地址内容 - 管理员用户调用
     * @param address address
     * @return count
     */
    @UpdateProvider(type = AddressMapperProvider.class, method = "updateAddressByPrimaryKeySelective")
    int updateAddressByPrimaryKeySelective(Address address);

    /**
     * 删除地址 - 管理员用户调用
     * @param id primary key
     * @return count
     */
    @Delete("DELETE FROM address WHERE id = #{id}")
    int removeAddressByPrimaryKey(Integer id);

    /**
     * 根据用户 id 获取所有地址 - 当前用户调用
     * @param userId userId
     * @return addresses
     */
    @Select("SELECT * FROM address WHERE user_id = #{userId}")
    @ResultMap(value = "com.xieyunhai.mapper.AddressMapper.addressResult")
    List<Address> listAddressesByUserId(Integer userId);

    /**
     * 根据用户 id 和 id 获取地址 - 当前用户调用
     * @param id primary key
     * @param userId userId
     * @return address
     */
    @Select("SELECT * FROM address WHERE id = #{id} AND user_id = #{userId}")
    Address getAddressByPrimaryKeyAndUserId(@Param("id") Integer id, @Param("userId") Integer userId);

    /**
     * 根据用户 id 和 id 更新地址全部内容 - 当前用户调用
     * @param address address
     * @param userId userId
     * @return count
     */
    @Update("UPDATE address SET name = #{name}, receive_name = #{receiveName}, alias = #{alias}, " +
            "post_code = #{postCode}, telephone = #{telephone}, cellphone = #{cellphone}, " +
            "province = #{province}, district = #{district}, city = #{city}, street = #{street}, " +
            "remarks = #{remarks}, status = #{status}, update_time = now() WHERE id = #{id} " +
            "AND user_id = #{userId}")
    int updateAddressByPrimaryKeyAndUserId(@Param("address") Address address, @Param("userId") int userId);

    /**
     * 根据用户 id 和 id 更新地址部分内容 - 当前用户调用
     * @param address address
     * @param userId userId
     * @return count
     */
    @UpdateProvider(type = AddressMapperProvider.class, method = "updateAddressByPrimaryKeyAndUserIdSelective")
    int updateAddressByPrimaryKeyAndUserIdSelective(@Param("address") Address address, @Param("userId") Integer userId);


    /**
     * 根据用户 id 和 id 删除地址 - 当前用户调用
     * @param id primary key
     * @param userId user
     */
    @Delete("DELETE FROM address WHERE id = #{id} AND user_id = #{userId}")
    int removeAddressByPrimaryKeyAndUserId(Integer id, Integer userId);
}
