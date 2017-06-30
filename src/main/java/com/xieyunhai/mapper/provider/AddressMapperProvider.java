package com.xieyunhai.mapper.provider;

import com.xieyunhai.entity.Address;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

/**
 * @author admin
 * @since 2017/6/30 9:49
 */
public class AddressMapperProvider {
    public String updateAddressByPrimaryKeySelective(Address address) {
        return new SQL() {
            {
                UPDATE("address");
                if (address.getName() != null) {
                    SET("name = #{name}");
                }
                if (address.getReceiveName() != null) {
                    SET("receive_name = #{receiveName}");
                }
                if (address.getAlias() != null) {
                    SET("alias = #{alias}");
                }
                if (address.getPostCode() != null) {
                    SET("post_code = #{postCode}");
                }
                if (address.getTelephone() != null) {
                    SET("telephone = #{telephone}");
                }
                if (address.getCellphone() != null) {
                    SET("cellphone = #{cellphone}");
                }
                if (address.getProvince() != null) {
                    SET("province = #{province}");
                }
                if (address.getDistrict() != null) {
                    SET("district = #{district}");
                }
                if (address.getCity() != null) {
                    SET("city = #{city}");
                }
                if (address.getStreet() != null) {
                    SET("street = #{street}");
                }
                if (address.getRemarks() != null) {
                    SET("remarks = #{remarks}");
                }
                if (address.getStatus() != null) {
                    SET("status = #{status}");
                }
                SET("update_time = now()");
                WHERE("id = #{id}");
            }
        }.toString();
    }

    public String updateAddressByPrimaryKeyAndUserIdSelective(@Param("address") Address address, @Param("userId") Integer
            userId) {
        return new SQL() {
            {
                UPDATE("address");
                if (address.getName() != null) {
                    SET("name = #{name}");
                }
                if (address.getReceiveName() != null) {
                    SET("receive_name = #{receiveName}");
                }
                if (address.getAlias() != null) {
                    SET("alias = #{alias}");
                }
                if (address.getPostCode() != null) {
                    SET("post_code = #{postCode}");
                }
                if (address.getTelephone() != null) {
                    SET("telephone = #{telephone}");
                }
                if (address.getCellphone() != null) {
                    SET("cellphone = #{cellphone}");
                }
                if (address.getProvince() != null) {
                    SET("province = #{province}");
                }
                if (address.getDistrict() != null) {
                    SET("district = #{district}");
                }
                if (address.getCity() != null) {
                    SET("city = #{city}");
                }
                if (address.getStreet() != null) {
                    SET("street = #{street}");
                }
                if (address.getRemarks() != null) {
                    SET("remarks = #{remarks}");
                }
                if (address.getStatus() != null) {
                    SET("status = #{status}");
                }
                SET("update_time = now()");
                WHERE("id = #{id}");
                WHERE("user_id = #{userId}");
            }
        }.toString();
    }
}
