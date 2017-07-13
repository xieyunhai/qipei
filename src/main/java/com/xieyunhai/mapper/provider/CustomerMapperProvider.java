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

    // backend
    public String saveCustomerByCustomer(Customer customer) {
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

    public String updateCustomerByCustomerSelective(Customer params) {
        return new SQL() {
            {
                // todo 多表更新
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

    // portal
    public String updateCustomerByCustomerAndUserIdSelective(Map<String, Object> map) {
        Customer customer = (Customer) map.get("param1");
        Integer userId = (Integer) map.get("param2");
        return new SQL() {
            {
                // todo 多表更新
                UPDATE("customer customer, user user");
                if (customer.getManagerId() != null) {
                    SET("manager_id = #{param1.managerId, jdbcType=VARCHAR}");
                }
                if (customer.getPoints() != null) {
                    SET("points = #{param1.points, jdbcType=INTEGER}");
                }
                if (customer.getInvoiceTitle() != null) {
                    SET("invoice_title = #{param1.invoiceTitle, jdbcType=VARCHAR}");
                }
                if (customer.getShopName() != null) {
                    SET("shop_name = #{param1.shopName, jdbcType=VARCHAR}");
                }
                if (customer.getUserSource() != null) {
                    SET("user_source = #{param1.userSource, jdbcType=TINYINT}");
                }
                if (customer.getUserLevel() != null) {
                    SET("user_level = #{param1.userLevel, jdbcType=TINYINT}");
                }
                if (customer.getReferee() != null) {
                    SET("referee = #{param1.referee, jdbcType=INTEGER}");
                }
                if (customer.getUsername() != null) {
                    SET("username = #{param1.username, jdbcType=VARCHAR}");
                }
                if (customer.getPassword() != null) {
                    SET("password = #{param1.password, jdbcType=VARCHAR}");
                }
                if (customer.getName() != null) {
                    SET("name = #{param1.name, jdbcType=VARCHAR}");
                }
                if (customer.getSex() != null) {
                    SET("sex = #{param1.sex, jdbcType=TINYINT}");
                }
                if (customer.getAvatar() != null) {
                    SET("avatar = #{param1.avatar, jdbcType=VARCHAR}");
                }
                if (customer.getEmail() != null) {
                    SET("email = #{param1.email, jdbcType=VARCHAR}");
                }
                if (customer.getTelephone() != null) {
                    SET("telephone = #{param1.telephone, jdbcType=VARCHAR}");
                }
                if (customer.getCellphone() != null) {
                    SET("cellphone = #{param1.cellphone, jdbcType=VARCHAR}");
                }
                if (customer.getChecked() != null) {
                    SET("checked = #{param1.checked, jdbcType=TINYINT}");
                }
                if (customer.getWxOpenId() != null) {
                    SET("wx_open_id = #{param1.wxOpenId, jdbcType=VARCHAR}");
                }
                if (customer.getWxNickname() != null) {
                    SET("wx_nickname = #{param1.wxNickname, jdbcType=VARCHAR}");
                }
                if (customer.getLoginTimes() != null) {
                    SET("login_times = #{param1.loginTimes, jdbcType=INTEGER}");
                }
                if (customer.getLastLoginIp() != null) {
                    SET("last_login_ip = #{param1.lastLoginIp, jdbcType=VARCHAR}");
                }
                if (customer.getLastLoginTime() != null) {
                    SET("last_login_time = #{param1.lastLoginTime, jdbcType=TIMESTAMP}");
                }
                if (customer.getRemarks() != null) {
                    SET("remarks = #{param1.remarks, jdbcType=VARCHAR}");
                }
                if (customer.getStatus() != null) {
                    SET("status = #{param1.status, jdbcType=TINYINT}");
                }
                SET("user.update_time = now()");
                SET("customer.update_time = now()");
                WHERE("customer.id = user.id");
                WHERE("customer.id = #{param1.id}");
                WHERE("customer.id = #{param2}");
            }
        }.toString();
    }
}
