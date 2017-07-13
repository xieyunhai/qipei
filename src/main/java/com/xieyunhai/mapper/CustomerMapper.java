package com.xieyunhai.mapper;

import com.xieyunhai.entity.Customer;
import java.util.List;

import com.xieyunhai.mapper.provider.CustomerMapperProvider;
import org.apache.ibatis.annotations.*;

public interface CustomerMapper {

    // backend
    @Select({
            "SELECT customer.*, user.* FROM customer",
            "LEFT JOIN user ON customer.id = user.id"
    })
    @ResultMap(value = "com.xieyunhai.mapper.CustomerMapper.customerResult")
    List<Customer> listCustomers();

    @Select({
            "SELECT customer.*, user.* FROM customer",
            "LEFT JOIN user ON customer.id = user.id",
            "WHERE customer.id = #{id, jdbcType=INTEGER}"
    })
    @ResultMap(value = "com.xieyunhai.mapper.CustomerMapper.customerResult")
    Customer getCustomerByPrimaryKey(@Param("id") Integer id);

    @InsertProvider(type = CustomerMapperProvider.class, method = "saveCustomerByCustomer")
    void saveCustomerByCustomer(Customer customer);

    @UpdateProvider(type = CustomerMapperProvider.class, method = "updateCustomerByCustomerSelective")
    void updateCustomerByCustomerSelective(Customer customer);

    @Delete({
            "DELETE customer, user FROM customer",
            "LEFT JOIN user ON customer.id = user.id",
            "WHERE customer.id = #{id, jdbcType=INTEGER}"
    })
    void removeCustomerByPrimaryKey(Integer id);


    // portal
    @Select({
            "SELECT * FROM customer, user ",
            "WHERE customer.id = user.id ",
            "AND customer.id = #{id, jdbcType=INTEGER}",
            "AND customer.id = #{userId, jdbcType=INTEGER}"
    })
    @ResultMap(value = "com.xieyunhai.mapper.CustomerMapper.customerResult")
    Customer getCustomerByPrimaryKeyAndUserId(@Param("id") Integer id, @Param("userId") Integer userId);

    @UpdateProvider(type = CustomerMapperProvider.class, method = "updateCustomerByCustomerAndUserIdSelective")
    void updateCustomerByCustomerAndUserIdSelective(Customer customer, Integer userId);

    @Delete({
            "DELETE customer, user FROM customer LEFT JOIN user",
            "ON customer.id = user.id",
            "WHERE customer.id = #{id, jdbcType=INTEGER}",
            "AND customer.id = #{userId, jdbcType=INTEGER}"
    })
    void removeCustomerByPrimaryKeyAndUserId(Integer id, Integer userId);

    // 因为有相同字段, 要取 customer 中, 所以 结果 customer.* 放在前面 -> 别的数据库可能会有 bug
    @Select({
            "SELECT customer.*, user.* FROM customer customer",
            "LEFT OUTER JOIN user user ON user.id = customer.id",
            "WHERE user.username = #{username, jdbcType=VARCHAR} AND user.password = #{password, jdbcType=VARCHAR}"
    })
    @ResultMap(value = "com.xieyunhai.mapper.CustomerMapper.customerResult")
    Customer getCustomerByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

}