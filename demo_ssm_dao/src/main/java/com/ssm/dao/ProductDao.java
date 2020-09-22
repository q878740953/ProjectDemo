package com.ssm.dao;

import com.ssm.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDao {
    // 根据产品id查询产品信息
    @Select("select * from product where id=#{id}")
    Product findById(int id);
    // 查询出所有的产品信息
    @Select("select * from product")
    List<Product> finAll() throws Exception;
    // 插入产品信息
    @Insert("insert into product(productNum, productName, cityName, DepartureTime, productDesc, productStatus) values(#{productNum}, #{productName}, #{cityName}, #{DepartureTime}, #{productDesc}, #{productStatus})")
    void save(Product product) throws Exception;
}
