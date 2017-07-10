package com.xieyunhai.mapper;

import com.xieyunhai.entity.Customer;
import java.util.List;

import com.xieyunhai.mapper.provider.CustomerMapperProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

public interface CustomerMapper {
    @Delete({
        "delete from customer",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @InsertProvider(type = CustomerMapperProvider.class, method = "saveCustomer")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(Customer record);

    @Select({
        "select",
        "id, user_id, manager_id, points, invoice_title, shop_name, user_source, user_level, ",
        "referee, create_time, update_time",
        "from customer",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="manager_id", property="managerId", jdbcType=JdbcType.INTEGER),
        @Result(column="points", property="points", jdbcType=JdbcType.INTEGER),
        @Result(column="invoice_title", property="invoiceTitle", jdbcType=JdbcType.VARCHAR),
        @Result(column="shop_name", property="shopName", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_source", property="userSource", jdbcType=JdbcType.TINYINT),
        @Result(column="user_level", property="userLevel", jdbcType=JdbcType.TINYINT),
        @Result(column="referee", property="referee", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    Customer selectByPrimaryKey(Integer id);

    @Select({
        "select",
        "id, user_id, manager_id, points, invoice_title, shop_name, user_source, user_level, ",
        "referee, create_time, update_time",
        "from customer"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="manager_id", property="managerId", jdbcType=JdbcType.INTEGER),
        @Result(column="points", property="points", jdbcType=JdbcType.INTEGER),
        @Result(column="invoice_title", property="invoiceTitle", jdbcType=JdbcType.VARCHAR),
        @Result(column="shop_name", property="shopName", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_source", property="userSource", jdbcType=JdbcType.TINYINT),
        @Result(column="user_level", property="userLevel", jdbcType=JdbcType.TINYINT),
        @Result(column="referee", property="referee", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Customer> selectAll();

    @Update({
        "update customer",
        "set user_id = #{userId,jdbcType=INTEGER},",
          "manager_id = #{managerId,jdbcType=INTEGER},",
          "points = #{points,jdbcType=INTEGER},",
          "invoice_title = #{invoiceTitle,jdbcType=VARCHAR},",
          "shop_name = #{shopName,jdbcType=VARCHAR},",
          "user_source = #{userSource,jdbcType=TINYINT},",
          "user_level = #{userLevel,jdbcType=TINYINT},",
          "referee = #{referee,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Customer record);

    @Select("SELECT * FROM customer ")
    Customer getCustomerByPrimaryKey(Integer id);
}