package com.xieyunhai.mapper.provider;

import com.xieyunhai.entity.Customer;
import org.apache.ibatis.jdbc.SQL;

import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;

/**
 * Created by noobit on 17-7-10.
 */
public class CustomerMapperProvider {
    private UserMapperProvider userMapperProvider;

    public String saveCustomer(Customer customer) {
        String userSql = userMapperProvider.saveUser(customer);
        SQL customerSql = new SQL() {
            {
                INSERT_INTO("customer");
                if (customer.getUserId() != null) {
                    VALUES("user_id", "#{userId, jdbcType=VARCHAR}");
                }
                if (customer.getManagerId() != null) {
                    VALUES("managerId", "#{managerId, jdbcType=VARCHAR}");
                }
                if (customer.getPoints() != null) {
                    VALUES("points", "#{points, jdbcType=VARCHAR}");
                }
                if (customer.getInvoiceTitle() != null) {
                    VALUES("sex", "#{sex, jdbcType=TINYINT}");
                }
                if (customer.getShopName() != null) {
                    VALUES("avatar", "#{avatar, jdbcType=VARCHAR}");
                }
                if (customer.getUserSource() != null) {
                    VALUES("avatar", "#{avatar, jdbcType=VARCHAR}");
                }
                if (customer.getUserLevel() != null) {
                    VALUES("avatar", "#{avatar, jdbcType=VARCHAR}");
                }
                if (customer.getReferee() != null) {
                    VALUES("avatar", "#{avatar, jdbcType=VARCHAR}");
                }
                VALUES("create_time", "now()");
                VALUES("update_time", "now()");
            }
        };
        return userSql + customerSql.toString();
    }
}
