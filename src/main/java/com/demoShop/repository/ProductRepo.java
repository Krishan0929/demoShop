package com.demoShop.repository;

import com.demoShop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product,Integer>
{
    Product findByPid(int id);

    @Query(value = "select product_id,product_name,price from product",nativeQuery = true)
    List<Object> getSpecificDetaisOfProducts();

    @Query(value = "select product_id,product_name,price from product where product_id = : product_id",nativeQuery = true)
    Object getSpecificDetailsOnBasisOfProductId(@Param(value = "product_id")int id);

}
