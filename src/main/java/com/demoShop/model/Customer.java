package com.demoShop.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Getter
@Setter
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

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public Customer(int cid, String customer_name, String gender, int age, List<Product> products, List<Order> orders, Wallet wallet) {
        this.cid = cid;
        this.customer_name = customer_name;
        this.gender = gender;
        this.age = age;
        this.products = products;
        this.orders = orders;
        this.wallet = wallet;
    }

    public Customer() {
    }

    @Override
    public String toString() {
        return "Customer{" +
                "cid=" + cid +
                ", customer_name='" + customer_name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", products=" + products +
                ", orders=" + orders +
                ", wallet=" + wallet +
                '}';
    }
}
