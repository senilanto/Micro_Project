package com.custom_service.Service;

import com.custom_service.Entity.Customer;

import java.util.List;

public interface CustomerService {

//get list of customers
    public List<Customer> getCustomer();

    //create a customer
    public Customer addCustomer(Customer customer);

    //get by id

    public  Customer findById(Integer id);



}
