package com.demoShop.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Wallet
{

    @Column(name = "wallet_id")
    private int wid;

    @Column(name = "customer_id",insertable = false,updatable = false)
    private int cid;

    private int amount;

    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
