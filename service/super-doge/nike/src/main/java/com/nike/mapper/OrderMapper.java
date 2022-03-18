package com.nike.mapper;

import com.nike.models.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderMapper {

    @Select("SELECT * FROM nike_order WHERE mid = #{memberId}")
    @Results({
            @Result(property = "orderId",  column = "id"),
            @Result(property = "memberId", column = "mid"),
            @Result(property = "deliveryCompany", column = "delivery_company"),
            @Result(property = "deliveryTime", column = "delivery_time"),
            @Result(property = "productName", column = "product_name"),
            @Result(property = "costPoints", column = "cost_points")
    })
    List<Order> getOrders(Integer memberId);

    @Select("SELECT COUNT(*) FROM nike_order")
    String getOrderCounts();

    @Insert("INSERT INTO nike_order(id,mid,delivery_company,delivery_time,product_name,cost_points) " +
            "VALUES(#{orderId}, #{memberId}, #{deliveryCompany},#{deliveryTime},#{productName},#{costPoints})")
    void insertNewOrder(Order order);
}
