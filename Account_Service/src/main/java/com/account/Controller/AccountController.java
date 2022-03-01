package com.account.Controller;

import com.account.Model.Account;

import com.account.Model.EmptyInputException;
import com.account.Model.RequestPut;
import com.account.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/accounts")
    public ResponseEntity<List<Account>> getAllAccount() {
        List<Account> accountList = accountService.getAllAccount();
        return new ResponseEntity<>(accountList, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Account> addAccount(@Valid @RequestBody Account account) {

        Account account1 = accountService.addAccount(account);
        return new ResponseEntity<>(account1, HttpStatus.CREATED);
    }

    @GetMapping("/id/{account_id}")
    public ResponseEntity<Account> getById(@PathVariable("account_id") Integer id) {

        Account one = accountService.findById(id);
        return new ResponseEntity<>(one, HttpStatus.OK);
    }

    @GetMapping("/cus/id/{customerid}")
    public ResponseEntity <List<Account>> getByCustomerId(@PathVariable("customerid") Integer id)  {
        List<Account> a = accountService.getCustomerById(id);
        if(a.isEmpty()){
            throw new EmptyInputException("500","input fields are empty");
        }
        return new ResponseEntity<>(a, HttpStatus.OK);
    }

    @PatchMapping("/addmoney")
    public ResponseEntity <List<Account>> updateMoney(@RequestBody RequestPut requestPut){
        return new ResponseEntity<>(accountService.updateAccountBalance(requestPut),HttpStatus.ACCEPTED);
    }
    @PatchMapping("/disableisActive/{id}")
    public ResponseEntity <List<Account>> updateActive(@PathVariable("id") Integer ids){
        return new ResponseEntity<>(accountService.updateActive(ids),HttpStatus.ACCEPTED);
    }





}

