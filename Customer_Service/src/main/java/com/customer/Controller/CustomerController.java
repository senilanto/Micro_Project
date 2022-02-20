package com.customer.Controller;

import com.customer.Entity.Customer;
import com.customer.Feign.Feign;

import com.customer.Model.Account;
import com.customer.Model.RequestForPut;
import com.customer.Model.RequiredResponse;
import com.customer.Service.CustomerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerServices customerServices;

    @Autowired
    private Feign feign;



    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getAllCustomer(){
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
      List<Account>  account= (List<Account>) feign.getIds(account_id);
        requiredResponse.setAccount_model(account);
        return new ResponseEntity<>(requiredResponse,HttpStatus.OK);
    }




    @PatchMapping("/updateActive/{id}")
    public ResponseEntity<Customer> delete(@PathVariable("id") Integer id){

        return new ResponseEntity<Customer>(customerServices.deleteCustomer(id),HttpStatus.ACCEPTED);
    }

    @PatchMapping("/updateLastName")
    public ResponseEntity<Customer> updateLastName(@RequestBody RequestForPut p){
        return new ResponseEntity<Customer>(customerServices.updateLastName(p),HttpStatus.ACCEPTED);
    }

    @PatchMapping("/updateMiddleName")
    public ResponseEntity<Customer> updateMiddleName(@RequestBody RequestForPut p){
        return new ResponseEntity<Customer>(customerServices.updateMiddleName(p),HttpStatus.ACCEPTED);
    }

    @PatchMapping("/updateAddress")
    public ResponseEntity<Customer> updateAddress(@RequestBody RequestForPut p){
        return new ResponseEntity<Customer>(customerServices.updateAddress(p),HttpStatus.ACCEPTED);
    }

    @PatchMapping("/updatePhone")
    public ResponseEntity<Customer> updatePhone(@RequestBody RequestForPut p){
        return new ResponseEntity<Customer>(customerServices.updatePhone(p),HttpStatus.ACCEPTED);
    }

    @PatchMapping("/updateEmail")
    public ResponseEntity<Customer> updateEmail(@RequestBody RequestForPut p){
        return new ResponseEntity<Customer>(customerServices.updateEmail(p),HttpStatus.ACCEPTED);
    }



}
