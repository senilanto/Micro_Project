package com.customer.Service;

import com.customer.Model.Customer;
import com.customer.Exception.CustomerNotFoundException;
import com.customer.Feign.Feign;
import com.customer.Model.Account;
import com.customer.Model.RequestForPut;
import com.customer.Repo.CustomerRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServices implements  CustomerInterface{

    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private Feign feign;

    @Override
    public List<Customer> getCustomer() {
        if (customerRepo.findAll().isEmpty())
            throw new CustomerNotFoundException("No customers found for this id ");
        return customerRepo.findAll();
    }




    @Override
    public Customer addCustomer(Customer customer) {
        if (!customerRepo.findById(customer.getCustomer_id()).isPresent()) {


            Account accountModel = feign.createAccount(customer.getAccountModel());


            return customerRepo.save(customer);
        } else {
            Customer customerModel = customerRepo.findById(customer.getCustomer_id()).get();
            if (customerModel.getIsActive() == true) {
                Account accountModel = feign.createAccount(customer.getAccountModel());
                return customerRepo.save(customer);
            } else {
                throw new CustomerNotFoundException("Customer is already inactive,cannnot create account");
            }
}
        }

  @Override
        public Customer findById (Integer id){
            if (!customerRepo.findById(id).isPresent())
                throw new CustomerNotFoundException("id doesnt exist");
            return customerRepo.findById(id).get();
        }



    @Override
        public Customer deleteCustomer (Integer id){
            Customer customer =findById(id);
            if (customer.getIsActive() == false) {
                throw new CustomerNotFoundException("Customer is already inactive");
            }
            customer.setIsActive(false);
            customerRepo.save(customer);
            List<Account> accountLists = (List<Account>) feign.updateActive(id);
            customer = findById(id);
            return customer;
        }

    @Override
        public Customer updateLastName (RequestForPut p){
            Customer customer = findById(p.getId());
            customer.setCustomerLastName(p.getLastname());
            customerRepo.save(customer);
            return customer = findById(p.getId());

        }
    @Override
        public Customer updateMiddleName (RequestForPut p){

            Customer customer = findById(p.getId());
            customer.setCustomerMiddleName(p.getMiddlename());
            customerRepo.save(customer);
            return customer = findById(p.getId());

        }
    @Override
        public Customer updateAddress (RequestForPut p){
            Customer customer = findById(p.getId());
            customer.setAddress(p.getAddress());
            customerRepo.save(customer);
            return customer ;

        }
    @Override
        public Customer updatePhone (RequestForPut p){
            Customer customer = findById(p.getId());
            customer.setPhonenumber(p.getPhone());
            customerRepo.save(customer);
            return customer = findById(p.getId());

        }
    @Override
        public Customer updateEmail (RequestForPut p){
            Customer customer = findById(p.getId());
            customer.setEmail(p.getEmail());
            customerRepo.save(customer);
            return customer = findById(p.getId());

        }

    }
