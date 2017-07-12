package com.xieyunhai.mapper;

import com.xieyunhai.entity.Customer;
import java.util.List;

import com.xieyunhai.mapper.provider.CustomerMapperProvider;
import org.apache.ibatis.annotations.*;

public interface CustomerMapper {
    @Select({
            "SELECT * FROM customer, user ",
            "WHERE customer.id = user.id ",
            "AND customer.id = #{id, jdbcType=INTEGER}"
    })
    @ResultMap(value = "com.xieyunhai.mapper.CustomerMapper.customerResult")
    Customer getCustomerByPrimaryKey(Integer id);

    @Select({
            "SELECT * FROM customer, user ",
            "WHERE customer.id = user.id "
    })
    @ResultMap(value = "com.xieyunhai.mapper.CustomerMapper.customerResult")
    List<Customer> listCustomeres();

    @InsertProvider(type = CustomerMapperProvider.class, method = "saveCustomer")
    void saveCustomer(Customer customer);

    @UpdateProvider(type = CustomerMapperProvider.class, method = "updateCustomerSelective")
    void updateCustomerSelective(Customer customer);

    @Delete({
            "delete customer, user from customer LEFT JOIN user",
            "ON customer.id = user.id",
            "WHERE customer.id = #{id, jdbcType=INTEGER}"
    })
    void removeCustomerByPrimaryKey(Integer id);

}