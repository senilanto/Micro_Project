package com.customer.Feign;


import com.customer.Model.Account;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name="ACCOUNT-SERVICE",fallbackFactory = HystrixFallBackFactory.class)
public interface Feign {
    @GetMapping(value = "/account/cus/id/{customerid}")
    List<Account> getIds(@PathVariable Integer customerid);



    @PatchMapping("/account/disableisActive/{id}")
    List<Account> updateActive(@PathVariable Integer id);

    @PostMapping("/account/add")
    Account createAccount(@RequestBody Account accountModel);



}
