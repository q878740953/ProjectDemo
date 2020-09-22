package com.ssm.dao;

import com.ssm.domain.Member;
import com.ssm.domain.Order;
import com.ssm.domain.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface OrdersDao {
    @Select("select * from orders")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "orderNum", column = "orderNum"),
            @Result(property = "orderTime", column = "orderTime"),
            @Result(property = "orderTimeStr", column = "orderTimeStr"),
            @Result(property = "peopleCount", column = "peopleCount"),
            @Result(property = "payType", column = "payType"),
            @Result(property = "payTypeStr", column = "payTypeStr"),
            @Result(property = "orderStatus", column = "orderStatus"),
//            // one = @One(select = "com.ssm.dao.ProduceDao.finById") 可以通过外部方法的形式查询所有数据
            @Result(property = "product", column = "productId", one = @One(select = "com.ssm.dao.ProductDao.findById")),
//            @Result(property = "member", column = "memberId", javaType = Member.class, one = @One(select = "select * from member where id=#{memberId}")),
//            @Result(property = "travellers", column = "travellers"),
    })
    List<Order> findAll();
    @Select("select * from orders where id=#{id}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "orderNum", column = "orderNum"),
            @Result(property = "orderTime", column = "orderTime"),
            @Result(property = "product", column = "productId", javaType = Product.class, one = @One(select = "com.ssm.dao.ProductDao.findById")),
            @Result(property = "member", column = "memberId", javaType = Member.class, one = @One(select = "com.ssm.dao.MemberDao.findById")),
            @Result(property = "travellers", column = "id", javaType = java.util.List.class, many = @Many(select = "com.ssm.dao.travellerDao.findByOrderId"))
    })
    Order findById(int id);
}
