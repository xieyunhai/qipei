package com.xieyunhai.mapper.provider;

import com.xieyunhai.entity.Customer;
import com.xieyunhai.entity.User;
import com.xieyunhai.mapper.UserMapper;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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

    public String updateByPrimaryKey(Customer customer) {
        return null;
    }
}
