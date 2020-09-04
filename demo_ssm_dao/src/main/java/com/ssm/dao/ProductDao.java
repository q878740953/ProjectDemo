package com.ssm.dao;

import com.ssm.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDao {
    @Select("select * from product where id=#{id}")
    Product findById(int id);
    @Select("select * from product")
    List<Product> finAll() throws Exception;
    @Insert("insert into product(productNum, productName, cityName, DepartureTime, productDesc, productStatus) values(#{productNum}, #{productName}, #{cityName}, #{DepartureTime}, #{productDesc}, #{productStatus})")
    void save(Product product) throws Exception;
}
