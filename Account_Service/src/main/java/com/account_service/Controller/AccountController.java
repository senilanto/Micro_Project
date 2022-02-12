package com.account_service.Controller;

import com.account_service.Entity.Account;
import com.account_service.Service.AccountServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
   private AccountServ accountServ;

    @GetMapping("/accounts")
    public ResponseEntity<List<Account>> getAllAccount(){
      List<Account> accountList=  accountServ.getAllAccount();
      return  new ResponseEntity<List<Account>>(accountList, HttpStatus.OK);
    }

    @PostMapping("/add")
    public  ResponseEntity<Account> addAccount(@RequestBody Account account){
      Account account1=  accountServ.addAccount(account);
      return  new ResponseEntity<Account>(account1,HttpStatus.CREATED);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Account> getById(@PathVariable("id") Integer id){
        Account one= accountServ.findById(id);
        return  new ResponseEntity<Account>(one,HttpStatus.OK);
    }

}
