package com.demoShop.controller;


import com.demoShop.model.Customer;
import com.demoShop.model.Order;
import com.demoShop.model.Product;
import com.demoShop.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class shopController
{
    @Autowired
   private ShopService shopService;

    @GetMapping("/customers")
    public List<Customer> getAllCustomers()
    {
        return shopService.getAllCustomers();
    }

    @GetMapping("/customers/{custId}")
    public List<Customer> getCustomerById(@PathVariable (name = "custId")int id)
    {
        return (List<Customer>)shopService.getCustomerById(id);
    }

    @GetMapping("/products")
    public List<Product> getAllproducts()
    {
        return shopService.getAllProducts();
    }

    @GetMapping("/products/{pid}")
    public Product getProductById(@PathVariable (name = "pid")int id)
    {
        return shopService.getProductById(id);
    }

    @GetMapping("/checkout/{orderId}/{buyValue}")
    public Order checkOutOrder(@PathVariable(name = "orderId")int oid,
                               @PathVariable(name = "buyValue")int buyValue)
    {
        return shopService.checkOutOrder(oid,buyValue);
    }
    @GetMapping("/return/{orderId}/{returnValue}")
    public Order returnOrder(@PathVariable(name = "orderId")int oid,
                               @PathVariable(name = "returnValue")int returnValue)
    {
        return shopService.checkOutOrder(oid,returnValue);
    }

    @GetMapping("/ratecard")
    public Object rateCard()
    {
        return shopService.ratecardDetailsOfAllProducts();
    }

    @GetMapping("/ratecard/{pid}")
    public Object rateCardById(@PathVariable(name = "pid")int pid)
    {
        return shopService.rateCardOfParticularProduct(pid);
    }
}
