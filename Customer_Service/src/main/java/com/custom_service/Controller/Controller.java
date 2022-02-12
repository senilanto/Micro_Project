package com.custom_service.Controller;

import com.custom_service.Entity.Customer;
import com.custom_service.Model.Account;
import com.custom_service.Model.RequiredResponse;
import com.custom_service.Service.CustomerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class Controller {
    @Autowired
    private CustomerServices customerServices;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getAllCustomer(){
       List<Customer> list=customerServices.getCustomer();

        return new ResponseEntity<List<Customer>>(list, HttpStatus.OK);
    }

    @PostMapping("/add")
    public  ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
       Customer customer1= customerServices.addCustomer(customer);
       return new ResponseEntity<Customer>(customer1,HttpStatus.CREATED);

    }



    @GetMapping("/id/{id}")
    public ResponseEntity<Customer> getById(@PathVariable("id") Integer id){
       Customer one= customerServices.findById(id);
       return  new ResponseEntity<Customer>(one,HttpStatus.OK);
    }

    @GetMapping("/id/ids/{id}")
    public ResponseEntity<RequiredResponse> getAllDataBasedOnCentreId(@PathVariable("id") Integer id){
        RequiredResponse requiredResponse=new RequiredResponse();


        Customer cus= customerServices.findById(id);
        requiredResponse.setCustomer_model(cus);

        Account accounts=  restTemplate.getForObject("http://ACCOUNT-SERVICE/account/id/"+id, Account.class);
        requiredResponse.setAccount_model((Account) accounts);
        return new ResponseEntity<RequiredResponse>(requiredResponse,HttpStatus.OK);
    }


}
