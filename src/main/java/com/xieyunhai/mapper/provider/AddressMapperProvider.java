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
                    SET("name = #{address.name}");
                }
                if (address.getReceiveName() != null) {
                    SET("receive_name = #{address.receiveName}");
                }
                if (address.getAlias() != null) {
                    SET("alias = #{address.alias}");
                }
                if (address.getPostCode() != null) {
                    SET("post_code = #{address.postCode}");
                }
                if (address.getTelephone() != null) {
                    SET("telephone = #{address.telephone}");
                }
                if (address.getCellphone() != null) {
                    SET("cellphone = #{address.cellphone}");
                }
                if (address.getProvince() != null) {
                    SET("province = #{address.province}");
                }
                if (address.getDistrict() != null) {
                    SET("district = #{address.district}");
                }
                if (address.getCity() != null) {
                    SET("city = #{address.city}");
                }
                if (address.getStreet() != null) {
                    SET("street = #{address.street}");
                }
                if (address.getRemarks() != null) {
                    SET("remarks = #{address.remarks}");
                }
                if (address.getStatus() != null) {
                    SET("status = #{address.status}");
                }
                SET("update_time = now()");
                WHERE("id = #{address.id}");
                WHERE("user_id = #{userId}");
            }
        }.toString();
    }
}
