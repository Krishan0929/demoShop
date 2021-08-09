package com.demoShop.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="orders")
public class Order
{
    @Id
    @Column(name = "order_id")
    private int oid;

    @Column(name ="customer_id",insertable = false,updatable = false)
    private int cid;
    @Column(name = "product_id",insertable = false,updatable = false)
    private int pid;
    private int buy_quantity;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @JsonIgnore
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonIgnore
    private Product product;

}
