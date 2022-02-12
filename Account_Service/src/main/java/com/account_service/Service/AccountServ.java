package com.account_service.Service;

import com.account_service.Entity.Account;

import java.util.List;

public interface AccountServ {
    public List<Account> getAllAccount();

    public Account addAccount(Account account);
    public Account findById(Integer id);
}
