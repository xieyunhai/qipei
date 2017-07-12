package com.xieyunhai.mapper;

import com.xieyunhai.entity.Customer;
import java.util.List;

import com.xieyunhai.mapper.provider.CustomerMapperProvider;
import org.apache.ibatis.annotations.*;

public interface CustomerMapper {

    // backend
    @Select({
            "SELECT * FROM customer, user ",
            "WHERE customer.id = user.id "
    })
    @ResultMap(value = "com.xieyunhai.mapper.CustomerMapper.customerResult")
    List<Customer> listCustomers();

    @Select({
            "SELECT * FROM customer, user ",
            "WHERE customer.id = #{id, jdbcType=INTEGER}"
    })
    @ResultMap(value = "com.xieyunhai.mapper.CustomerMapper.customerResult")
    Customer getCustomerByPrimaryKey(Integer id);

    @InsertProvider(type = CustomerMapperProvider.class, method = "saveCustomer")
    void saveCustomerByCustomer(Customer customer);

    @UpdateProvider(type = CustomerMapperProvider.class, method = "updateCustomerSelective")
    void updateCustomerByCustomerSelective(Customer customer);

    @Delete({
            "delete customer, user from customer LEFT JOIN user",
            "ON customer.id = user.id",
            "WHERE customer.id = #{id, jdbcType=INTEGER}"
    })
    void removeCustomerByPrimaryKey(Integer id);

    // portal
    @Select({
            "SELECT * FROM customer, user ",
            "WHERE customer.id = user.id ",
            "AND customer.id = #{id, jdbcType=INTEGER}"
    })
    Customer getCustomerByPrimaryKeyAndUserId(Integer id, Integer userId);

    @UpdateProvider(type = CustomerMapperProvider.class, method = "updateCustomerByCustomerAndUserIdSelective")
    void updateCustomerByCustomerAndUserIdSelective(Customer customer, Integer id);

    @Delete({
            "DELETE customer, user FROM customer LEFT JOIN user",
            "ON customer.id = user.id",
            "WHERE customer.id = #{id, jdbcType=INTEGER}",
            "AND customer.id = #{userId, jdbcType=INTEGER}"
    })
    void removeCustomerByPrimaryKeyAndUserId(Integer id, Integer userId);

    @Select({
            "SELECT customer, user FROM customer LEFT JOIN user",
            "ON customer.id = user.id",
            "WHERE username = #{username, jdbcType=VARCHAR}",
            "AND password = #{password, jdbcType=VARCHAR}"
    })
    Customer getCustomerByUsernameAndPassword(String username, String password);

}