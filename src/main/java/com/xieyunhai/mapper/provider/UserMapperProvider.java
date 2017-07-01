package com.xieyunhai.mapper.provider;

import com.xieyunhai.entity.User;
import org.apache.ibatis.jdbc.SQL;

/**
 * @author noobit
 * @date 17-6-30 下午10:45
 */
public class UserMapperProvider {
    public String listUsers() {
        return new SQL() {
            {
                SELECT("id, username, password, name, sex, avatar, email, telephone, cellphone, checked, " +
                        "wx_open_id, wx_nickname, login_times, last_login_ip, last_login_time, remarks, status, " +
                        "create_time, update_time");
                FROM("user");
            }
        }.toString();
    }

    public String getUserByPrimaryKey(Integer id) {
        return new SQL() {
            {
                SELECT("id, username, password, name, sex, avatar, email, telephone, cellphone, checked, " +
                                "wx_open_id, wx_nickname, login_times, last_login_ip, last_login_time, remarks, " +
                        "status, create_time, update_time");
                FROM("user");
                WHERE("id = #{id, jdbcType=INTEGER}");
            }
        }.toString();
    }
    
    public String saveUser(User user) {
        return new SQL() {
            {
                INSERT_INTO("user");
                if (user.getUsername() != null) {
                    VALUES("username", "#{username, jdbcType=VARCHAR}");
                }
                if (user.getPassword() != null) {
                    VALUES("password", "#{password, jdbcType=VARCHAR}");
                }
                if (user.getName() != null) {
                    VALUES("name", "#{name, jdbcType=VARCHAR}");
                }
                if (user.getSex() != null) {
                    VALUES("sex", "#{sex, jdbcType=TINYINT}");
                }
                if (user.getAvatar() != null) {
                    VALUES("avatar", "#{avatar, jdbcType=VARCHAR}");
                }
                if (user.getEmail() != null) {
                    VALUES("email", "#{email, jdbcType=VARCHAR}");
                }
                if (user.getTelephone() != null) {
                    VALUES("telephone", "#{telephone, jdbcType=VARCHAR}");
                }
                if (user.getCellphone() != null) {
                    VALUES("cellphone", "#{cellphone, jdbcType=VARCHAR}");
                }
                if (user.getChecked() != null) {
                    VALUES("checked", "#{checked, jdbcType=TINYINT}");
                }
                if (user.getWxOpenId() != null) {
                    VALUES("wx_open_id", "#{wxOpenId, jdbcType=VARCHAR}");
                }
                if (user.getWxNickname() != null) {
                    VALUES("wx_nickname", "#{wxNickname, jdbcType=VARCHAR}");
                }
                if (user.getLoginTimes() != null) {
                    VALUES("login_times", "#{loginTimes, jdbcType=INTEGER}");
                }
                if (user.getLastLoginIp() != null) {
                    VALUES("last_login_ip", "#{lastLoginIp, jdbcType=VARCHAR}");
                }
                if (user.getLastLoginTime() != null) {
                    VALUES("last_login_time", "#{lastLoginTime, jdbcType=TIMESTAMP}");
                }
                if (user.getRemarks() != null) {
                    VALUES("remarks", "#{remarks, jdbcType=VARCHAR}");
                }
                if (user.getStatus() != null) {
                    VALUES("status", "#{status, jdbcType=TINYINT}");
                }
            }
        }.toString();
    }

    public String updateUserByPrimaryKeySelective(User user) {
        return new SQL() {
            {
                UPDATE("user");
                if (user.getUsername() != null) {
                    SET("username = #{username, jdbcType=VARCHAR}");
                }
                if (user.getPassword() != null) {
                    SET("password = #{password, jdbcType=VARCHAR}");
                }
                if (user.getName() != null) {
                    SET("name = #{name, jdbcType=VARCHAR}");
                }
                if (user.getSex() != null) {
                    SET("sex = #{sex, jdbcType=TINYINT}");
                }
                if (user.getAvatar() != null) {
                    SET("avatar = #{avatar, jdbcType=VARCHAR}");
                }
                if (user.getEmail() != null) {
                    SET("email = #{email, jdbcType=VARCHAR}");
                }
                if (user.getTelephone() != null) {
                    SET("telephone = #{telephone, jdbcType=VARCHAR}");
                }
                if (user.getCellphone() != null) {
                    SET("cellphone = #{cellphone, jdbcType=VARCHAR}");
                }
                if (user.getChecked() != null) {
                    SET("checked = #{checked, jdbcType=TINYINT}");
                }
                if (user.getWxOpenId() != null) {
                    SET("wx_open_id = #{wxOpenId, jdbcType=VARCHAR}");
                }
                if (user.getWxNickname() != null) {
                    SET("wx_nickname = #{wxNickname, jdbcType=VARCHAR}");
                }
                if (user.getLoginTimes() != null) {
                    SET("login_times = #{loginTimes, jdbcType=INTEGER}");
                }
                if (user.getLastLoginIp() != null) {
                    SET("last_login_ip = #{lastLoginIp, jdbcType=VARCHAR}");
                }
                if (user.getLastLoginTime() != null) {
                    SET("last_login_time = #{lastLoginTime, jdbcType=TIMESTAMP}");
                }
                if (user.getRemarks() != null) {
                    SET("remarks = #{remarks, jdbcType=VARCHAR}");
                }
                if (user.getStatus() != null) {
                    SET("status = #{status, jdbcType=TINYINT}");
                }
                SET("update_time = now()");
                WHERE("id = #{id}");
            }
        }.toString();
    }
}
