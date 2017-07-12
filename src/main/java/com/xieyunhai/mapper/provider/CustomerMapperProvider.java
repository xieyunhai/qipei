package com.xieyunhai.mapper.provider;

import com.xieyunhai.entity.Customer;
import com.xieyunhai.entity.User;
import com.xieyunhai.mapper.UserMapper;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.Map;

import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;

/**
 * Created by noobit on 17-7-10.
 */
@Component
public class CustomerMapperProvider {
    public String saveCustomer(Customer customer) {
        return new SQL() {
            {
                INSERT_INTO("customer");
                if (customer.getId() != null) {
                    VALUES("id", "#{id, jdbcType=INTEGER}");
                }
                if (customer.getManagerId() != null) {
                    VALUES("managerId", "#{managerId, jdbcType=VARCHAR}");
                }
                if (customer.getPoints() != null) {
                    VALUES("points", "#{points, jdbcType=VARCHAR}");
                }
                if (customer.getInvoiceTitle() != null) {
                    VALUES("invoice_title", "#{invoiceTitle, jdbcType=VARCHAR}");
                }
                if (customer.getShopName() != null) {
                    VALUES("shop_name", "#{shopName, jdbcType=VARCHAR}");
                }
                if (customer.getUserSource() != null) {
                    VALUES("user_source", "#{userSource, jdbcType=TINYINT}");
                }
                if (customer.getUserLevel() != null) {
                    VALUES("user_level", "#{userLevel, jdbcType=TINYINT}");
                }
                if (customer.getReferee() != null) {
                    VALUES("referee", "#{referee, jdbcType=INTEGER}");
                }
                VALUES("create_time", "now()");
                VALUES("update_time", "now()");
            }
        }.toString();
    }

    public String updateCustomerSelective(Customer params) {
        return new SQL() {
            {
                // todo 多表更新
//                SELECT("*");
//                FROM("customer customer");
//                SELECT("*");
//                FROM("user user");
//                LEFT_OUTER_JOIN("user user ON customer.id = user.id");
                UPDATE("customer customer, user user");
                if (params.getManagerId() != null) {
                    SET("manager_id = #{managerId, jdbcType=VARCHAR}");
                }
                if (params.getPoints() != null) {
                    SET("points = #{points, jdbcType=INTEGER}");
                }
                if (params.getInvoiceTitle() != null) {
                    SET("invoice_title = #{invoiceTitle, jdbcType=VARCHAR}");
                }
                if (params.getShopName() != null) {
                    SET("shop_name = #{shopName, jdbcType=VARCHAR}");
                }
                if (params.getUserSource() != null) {
                    SET("user_source = #{userSource, jdbcType=TINYINT}");
                }
                if (params.getUserLevel() != null) {
                    SET("user_level = #{userLevel, jdbcType=TINYINT}");
                }
                if (params.getReferee() != null) {
                    SET("referee = #{referee, jdbcType=INTEGER}");
                }
                if (params.getUsername() != null) {
                    SET("username = #{username, jdbcType=VARCHAR}");
                }
                if (params.getPassword() != null) {
                    SET("password = #{password, jdbcType=VARCHAR}");
                }
                if (params.getName() != null) {
                    SET("name = #{name, jdbcType=VARCHAR}");
                }
                if (params.getSex() != null) {
                    SET("sex = #{sex, jdbcType=TINYINT}");
                }
                if (params.getAvatar() != null) {
                    SET("avatar = #{avatar, jdbcType=VARCHAR}");
                }
                if (params.getEmail() != null) {
                    SET("email = #{email, jdbcType=VARCHAR}");
                }
                if (params.getTelephone() != null) {
                    SET("telephone = #{telephone, jdbcType=VARCHAR}");
                }
                if (params.getCellphone() != null) {
                    SET("cellphone = #{cellphone, jdbcType=VARCHAR}");
                }
                if (params.getChecked() != null) {
                    SET("checked = #{checked, jdbcType=TINYINT}");
                }
                if (params.getWxOpenId() != null) {
                    SET("wx_open_id = #{wxOpenId, jdbcType=VARCHAR}");
                }
                if (params.getWxNickname() != null) {
                    SET("wx_nickname = #{wxNickname, jdbcType=VARCHAR}");
                }
                if (params.getLoginTimes() != null) {
                    SET("login_times = #{loginTimes, jdbcType=INTEGER}");
                }
                if (params.getLastLoginIp() != null) {
                    SET("last_login_ip = #{lastLoginIp, jdbcType=VARCHAR}");
                }
                if (params.getLastLoginTime() != null) {
                    SET("last_login_time = #{lastLoginTime, jdbcType=TIMESTAMP}");
                }
                if (params.getRemarks() != null) {
                    SET("remarks = #{remarks, jdbcType=VARCHAR}");
                }
                if (params.getStatus() != null) {
                    SET("status = #{status, jdbcType=TINYINT}");
                }
                SET("user.update_time = now()");
                SET("customer.update_time = now()");
                WHERE("customer.id = user.id");
                WHERE("customer.id = #{id}");
            }
        }.toString();
    }

    public String updateCustomerByCustomerAndUserIdSelective(Map<String, Object> params) {
        Customer c = (Customer) params.get("customer");
        return new SQL() {
            {
                // todo 多表更新
                UPDATE("customer customer, user user");
                if (c.getManagerId() != null) {
                    SET("manager_id = #{managerId, jdbcType=VARCHAR}");
                }
                if (c.getPoints() != null) {
                    SET("points = #{points, jdbcType=INTEGER}");
                }
                if (c.getInvoiceTitle() != null) {
                    SET("invoice_title = #{invoiceTitle, jdbcType=VARCHAR}");
                }
                if (c.getShopName() != null) {
                    SET("shop_name = #{shopName, jdbcType=VARCHAR}");
                }
                if (c.getUserSource() != null) {
                    SET("user_source = #{userSource, jdbcType=TINYINT}");
                }
                if (c.getUserLevel() != null) {
                    SET("user_level = #{userLevel, jdbcType=TINYINT}");
                }
                if (c.getReferee() != null) {
                    SET("referee = #{referee, jdbcType=INTEGER}");
                }
                if (c.getUsername() != null) {
                    SET("username = #{username, jdbcType=VARCHAR}");
                }
                if (c.getPassword() != null) {
                    SET("password = #{password, jdbcType=VARCHAR}");
                }
                if (c.getName() != null) {
                    SET("name = #{name, jdbcType=VARCHAR}");
                }
                if (c.getSex() != null) {
                    SET("sex = #{sex, jdbcType=TINYINT}");
                }
                if (c.getAvatar() != null) {
                    SET("avatar = #{avatar, jdbcType=VARCHAR}");
                }
                if (c.getEmail() != null) {
                    SET("email = #{email, jdbcType=VARCHAR}");
                }
                if (c.getTelephone() != null) {
                    SET("telephone = #{telephone, jdbcType=VARCHAR}");
                }
                if (c.getCellphone() != null) {
                    SET("cellphone = #{cellphone, jdbcType=VARCHAR}");
                }
                if (c.getChecked() != null) {
                    SET("checked = #{checked, jdbcType=TINYINT}");
                }
                if (c.getWxOpenId() != null) {
                    SET("wx_open_id = #{wxOpenId, jdbcType=VARCHAR}");
                }
                if (c.getWxNickname() != null) {
                    SET("wx_nickname = #{wxNickname, jdbcType=VARCHAR}");
                }
                if (c.getLoginTimes() != null) {
                    SET("login_times = #{loginTimes, jdbcType=INTEGER}");
                }
                if (c.getLastLoginIp() != null) {
                    SET("last_login_ip = #{lastLoginIp, jdbcType=VARCHAR}");
                }
                if (c.getLastLoginTime() != null) {
                    SET("last_login_time = #{lastLoginTime, jdbcType=TIMESTAMP}");
                }
                if (c.getRemarks() != null) {
                    SET("remarks = #{remarks, jdbcType=VARCHAR}");
                }
                if (c.getStatus() != null) {
                    SET("status = #{status, jdbcType=TINYINT}");
                }
                SET("user.update_time = now()");
                SET("customer.update_time = now()");
                WHERE("customer.id = user.id");
                WHERE("customer.id = #{id}");
                WHERE("user_id = #{params.userId}");
            }
        }.toString();
    }
}
