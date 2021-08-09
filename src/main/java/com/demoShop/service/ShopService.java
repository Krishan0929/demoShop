package com.demoShop.service;

import com.demoShop.exception.OrderNotFoundException;
import com.demoShop.model.Customer;
import com.demoShop.model.Order;
import com.demoShop.model.Product;
import com.demoShop.repository.CustomerRepo;
import com.demoShop.repository.OrderRepo;
import com.demoShop.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopService
{
    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private OrderRepo orderRepo;

    public List<Customer>  getAllCustomers()
    {
        return customerRepo.findAll();
    }

    public Customer getCustomer(int id)
    {
        return customerRepo.findByCid(id);
    }

    public List<Product> getAllProducts()
    {
        return productRepo.findAll();
    }
    public Product getProductById(int id)
    {
        return productRepo.findByPid(id);
    }

    public Order checkOutOrder(int orderId,int buyValue)
    {
        if(orderRepo.findOrderByOid(orderId)==null)
        {
            throw new OrderNotFoundException("Order with this Id not Found");
        }
        Order order=orderRepo.findOrderByOid(orderId);
        int total =order.
    }
}
