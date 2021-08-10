package com.demoShop.service;

import com.demoShop.exception.*;
import com.demoShop.model.Customer;
import com.demoShop.model.Order;
import com.demoShop.model.Product;
import com.demoShop.repository.CustomerRepo;
import com.demoShop.repository.OrderRepo;
import com.demoShop.repository.ProductRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static Logger logger=LoggerFactory.getLogger(ShopService.class);

    public List<Customer>  getAllCustomers()
    {
        logger.info("Showing All the Customers");
        return customerRepo.findAll();
    }

    public List<Customer> getAllCustomer(int id)
    {

        return (List<Customer>) customerRepo.findByCid(id);
    }
    public Customer getCustomerById(int id)
    {
        if(customerRepo.findByCid(id)==null)
        {
            logger.error("Customer id not Registerd,Error Thrown");
            throw new CustomerNotFoundException("Customer with given Id not Found");
        }
        logger.info("Showing Customer Details for given Customer Id");
        return customerRepo.findByCid(id);
    }
    public List<Product> getAllProducts()
    {
        logger.info("All Products with Details Shown");
        return productRepo.findAll();
    }
    public Product getProductById(int id)
    {
        if(productRepo.findByPid(id)==null)
        {
            logger.error("product Id not Found,Error Thrown");
            throw new ProductNotFoundException("Product with given Id not Found");
        }
        logger.info(" Showing Product Details for given Product Id");
        return productRepo.findByPid(id);
    }

    public Order checkOutOrder(int orderId,int buyValue)
    {
        if(orderRepo.findOrderByOid(orderId)==null)
        {
            logger.error("order Id Not Found,Error Thrown");
            throw new OrderNotFoundException("Order with this Id not Found");
        }
        Order order=orderRepo.findOrderByOid(orderId);
        int total =order.getProduct().getQuantity_available();
        int sold =order.getProduct().getQuantity_sold();

        if(total==0)
        {
            logger.error("stock is empty,Error Thrown");
            throw  new OutOfStockException("Out of Stock");
        }
        if(total<buyValue)
        {
            logger.error("Less stock Quantity,Error Thrown");
            throw new OutOfStockException("This much Quantity not available");
        }
        int billAmount =order.getProduct().getPrice()*buyValue;
        if(billAmount>order.getCustomer().getWallet().getAmount())
        {
            logger.error("Not sufficient Balance In Wallet,Error Thrown");
            throw new InsufficientAmountException("You Dont have a sufficient balance");
        }
        int updateWalletAmountAfterBuying =order.getCustomer().getWallet().getAmount() - billAmount;
        order.getCustomer().getWallet().setAmount(updateWalletAmountAfterBuying);

        order.setBuy_quantity(order.getBuy_quantity()+buyValue);
        orderRepo.save(order);

       int finalSoldAfterBuying =sold + buyValue;
       int finalQuantityAvailable=total - buyValue;

       Product prod=productRepo.findByPid(order.getPid());
       prod.setQuantity_sold(finalSoldAfterBuying);
       prod.setQuantity_available(finalQuantityAvailable);
       productRepo.save(prod);
      logger.info("Checkout Successful");
       return order;
    }

    public Order returnOrder(int oid,int returnValue)
    {
        if(orderRepo.findOrderByOid(oid)==null)
        {
            logger.error("Order id not Found,Error Thrown");
            throw new OrderNotFoundException("Order with this id not Found");
        }
        int total= orderRepo.findOrderByOid(oid).getProduct().getQuantity_available();
        int sold = orderRepo.findOrderByOid(oid).getProduct().getQuantity_sold();
        int buyQuantity =orderRepo.findOrderByOid(oid).getBuy_quantity();

        if(buyQuantity<returnValue)
        {
            logger.error("Returning more items than bought,Error Thrown");
            throw new ReturnNotValidException("You are returning more than What You Bought");
        }
        if(buyQuantity==0)
        {
            logger.error("Customer bought Nothing but returning,Error Thrown");
            throw new ReturnNotValidException("You donot have anything to return");
        }
        int buyQuantityAferReturn =buyQuantity - returnValue;
        orderRepo.findOrderByOid(oid).setBuy_quantity(buyQuantityAferReturn);

        int amountbeforeReturn =orderRepo.findOrderByOid(oid).getCustomer().getWallet().getAmount();
        int amountAfterReturn =amountbeforeReturn + returnValue*orderRepo.findOrderByOid(oid).getProduct().getPrice();

        orderRepo.findOrderByOid(oid).getCustomer().getWallet().setAmount(amountAfterReturn);

        Product prod= productRepo.findByPid(orderRepo.findOrderByOid(oid).getPid());
        prod.setQuantity_available(total+ returnValue);
        prod.setQuantity_sold(sold - returnValue);
        productRepo.save(prod);
        logger.info("Order return Successful");
        return orderRepo.findOrderByOid(oid);


    }
    public List<Object> ratecardDetailsOfAllProducts()
    {
        logger.info("only RateCard with Product_id,Name,Price is Shrown");
      return productRepo.getSpecificDetaisOfProducts();
    }
    public Object rateCardOfParticularProduct(int id)
    {
        if(productRepo.getSpecificDetailsOnBasisOfProductId(id)==null)
        {
            logger.error("Product Id not Present,Error thrown");
            throw new ProductNotFoundException("Product Id not valid");
        }
        logger.info("RateCard of particular Product Shown");
      return   productRepo.getSpecificDetailsOnBasisOfProductId(id);
    }



}

