package com.demoShop.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Wallet
{
    @Id
    @Column(name = "wallet_id")
    private int wid;

    @Column(name = "customer_id",insertable = false,updatable = false)
    private int cid;

    private int amount;

    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public int getWid() {
        return wid;
    }

    public void setWid(int wid) {
        this.wid = wid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
