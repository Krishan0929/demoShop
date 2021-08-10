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



    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getBuy_quantity() {
        return buy_quantity;
    }

    public void setBuy_quantity(int buy_quantity) {
        this.buy_quantity = buy_quantity;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public Order(int oid, int cid, int pid, int buy_quantity, Customer customer, Product product) {
        this.oid = oid;
        this.cid = cid;
        this.pid = pid;
        this.buy_quantity = buy_quantity;
        this.customer = customer;
        this.product = product;
    }

    public Order() {
    }

  /*  @Override
    public String toString() {
        return "Order{" +
                "oid=" + oid +
                ", cid=" + cid +
                ", pid=" + pid +
                ", buy_quantity=" + buy_quantity +
                ", customer=" + customer +
                ", product=" + product +
                '}';*/
    }

