package com.demoShop.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Customer
{
    @Id
    @Column(name = "customer_id")
    private int cid;

    private String customer_name;

    private String gender;

    private int age;

    @ManyToMany
    @JsonIgnore
    @JoinTable(name = "orders",
            joinColumns ={@JoinColumn(name = "customer_id") },
            inverseJoinColumns = {@JoinColumn(name = "product_id")}
    )
    private List<Product> products;

    @OneToMany(mappedBy = "customer" )
    private List<Order> orders;

    @OneToOne(mappedBy = "customer")
    private Wallet wallet;

}
