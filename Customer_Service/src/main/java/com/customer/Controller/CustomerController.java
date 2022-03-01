package com.customer.Controller;

import com.customer.Model.Customer;
import com.customer.Feign.Feign;

import com.customer.Model.Account;
import com.customer.Model.RequestForPut;
import com.customer.Model.RequiredResponse;
import com.customer.Service.CustomerServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private static Logger logger = LoggerFactory.getLogger(CustomerController.class);
    @Autowired
    private CustomerServices customerServices;

    @Autowired
    private Feign feign;



    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getAllCustomer(){
        logger.info("customers list by get method");
       List<Customer> list=customerServices.getCustomer();

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("/add")
    public  ResponseEntity<Customer> addCustomer(@Valid @RequestBody Customer customer){
       Customer customer1= customerServices.addCustomer(customer);
       return new ResponseEntity<>(customer1,HttpStatus.CREATED);

    }



    @GetMapping("/id/{customer_id}")
    public ResponseEntity<Customer> getById(@PathVariable("customer_id") Integer id){
       Customer one= customerServices.findById(id);
       return  new ResponseEntity<>(one,HttpStatus.OK);
    }


    @GetMapping("/id/ids/{customer_id}")
    public ResponseEntity<RequiredResponse> getAllDataBasedOnCentreId(@Valid  @PathVariable("customer_id") Integer account_id){

        RequiredResponse requiredResponse=new RequiredResponse();


        Customer cus= customerServices.findById(account_id);
        requiredResponse.setCustomer_model(cus);

        try{
      List<Account>  account= feign.getIds(account_id);
        requiredResponse.setAccount_model(account);
        return new ResponseEntity<>(requiredResponse,HttpStatus.OK);
        }
        catch (Exception e){
           // throw new  HystrixException("Account service down");
            requiredResponse.setAccount_model(null);
            return new ResponseEntity<>(requiredResponse,HttpStatus.OK);
        }
    }




    @PatchMapping("/updateActive/{id}")
    public ResponseEntity<Customer> delete(@PathVariable("id") Integer id){

        return new ResponseEntity<>(customerServices.deleteCustomer(id),HttpStatus.ACCEPTED);
    }

    @PatchMapping("/updateLastName")
    public ResponseEntity<Customer> updateLastName(@RequestBody RequestForPut p){
        return new ResponseEntity<>(customerServices.updateLastName(p),HttpStatus.ACCEPTED);
    }

    @PatchMapping("/updateMiddleName")
    public ResponseEntity<Customer> updateMiddleName(@RequestBody RequestForPut p){
        return new ResponseEntity<>(customerServices.updateMiddleName(p),HttpStatus.ACCEPTED);
    }

    @PatchMapping("/updateAddress")
    public ResponseEntity<Customer> updateAddress(@RequestBody RequestForPut p){
        return new ResponseEntity<>(customerServices.updateAddress(p),HttpStatus.ACCEPTED);
    }

    @PatchMapping("/updatePhone")
    public ResponseEntity<Customer> updatePhone(@RequestBody RequestForPut p){
        return new ResponseEntity<>(customerServices.updatePhone(p), HttpStatus.ACCEPTED);
    }

    @PatchMapping("/updateEmail")
    public ResponseEntity<Customer> updateEmail(@RequestBody RequestForPut p){
        return new ResponseEntity<>(customerServices.updateEmail(p),HttpStatus.ACCEPTED);
    }


}
