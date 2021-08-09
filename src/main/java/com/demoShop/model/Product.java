package com.demoShop.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Product
{
    @Id
    @Column(name = "product_id")
    private  int  pid;

    private String product_name;

    private  int quantity_available;
    private  int quantity_sold;
    private  int price;

    @ManyToMany(mappedBy = "products")
    @JsonIgnore
    private List<Customer> customers;

    @OneToMany(mappedBy = "product")
    @JsonIgnore
    private List<Order> orders;



}
