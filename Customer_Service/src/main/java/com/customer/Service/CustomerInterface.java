package com.customer.Service;

import com.customer.Model.Customer;
import com.customer.Model.RequestForPut;

import java.util.List;

public interface CustomerInterface {


    public List<Customer> getCustomer();
    public Customer addCustomer(Customer customer);
    public Customer findById (Integer id);
    public Customer deleteCustomer (Integer id);
    public Customer updateLastName (RequestForPut p);
    public Customer updateMiddleName (RequestForPut p);
    public Customer updateAddress (RequestForPut p);
    public Customer updatePhone (RequestForPut p);
    public Customer updateEmail (RequestForPut p);
}
