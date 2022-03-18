package com.nike.mapper;

import com.nike.models.Order;
import com.nike.models.Product;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProductMapper {

    @Select("SELECT * FROM product")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "category", column = "category"),
            @Result(property = "price", column = "price"),
            @Result(property = "photo_path", column = "photo_path")
    })
    List<Product> getAllProducts();

}