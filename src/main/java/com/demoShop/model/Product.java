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

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public int getQuantity_available() {
        return quantity_available;
    }

    public void setQuantity_available(int quantity_available) {
        this.quantity_available = quantity_available;
    }

    public int getQuantity_sold() {
        return quantity_sold;
    }

    public void setQuantity_sold(int quantity_sold) {
        this.quantity_sold = quantity_sold;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Product() {
    }

    public Product(int pid, String product_name, int quantity_available, int quantity_sold, int price, List<Customer> customers, List<Order> orders) {
        this.pid = pid;
        this.product_name = product_name;
        this.quantity_available = quantity_available;
        this.quantity_sold = quantity_sold;
        this.price = price;
        this.customers = customers;
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Product{" +
                "pid=" + pid +
                ", product_name='" + product_name + '\'' +
                ", quantity_available=" + quantity_available +
                ", quantity_sold=" + quantity_sold +
                ", price=" + price +
                ", customers=" + customers +
                ", orders=" + orders +
                '}';
    }
}
