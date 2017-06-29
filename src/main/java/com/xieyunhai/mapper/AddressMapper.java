package com.xieyunhai.mapper;

import com.xieyunhai.domin.Address;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;

/**
 * @author noobit
 * @date 17-6-29 下午9:16
 */
public interface AddressMapper {

    @Insert("insert into address (user_id, name, receive_name, alias, post_code, telephone, " +
            "cellphone, province, district, city, street, remarks, status, create_time, update_time) " +
            "value(#{userId}, #{name}, #{receiveName}, #{alias}, #{postCode}, #{telephone}, " +
            "#{cellphone}, #{province}, #{district}, #{city}, #{street}, #{remarks}, #{status}, now(), now())")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    void save(Address address);
}
