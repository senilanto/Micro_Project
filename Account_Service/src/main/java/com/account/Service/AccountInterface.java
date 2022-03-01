package com.account.Service;

import com.account.Model.Account;
import com.account.Model.RequestPut;

import java.util.List;

public interface AccountInterface {
    public List<Account> getAllAccount();
    public Account addAccount(Account account);
    public Account findById(Integer id);
    public List<Account> getCustomerById(Integer id);
    public List<Account> updateAccountBalance(RequestPut requestPut);
    public List<Account> updateActive(Integer id);

}
