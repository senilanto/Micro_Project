package com.account_service.Service;

import com.account_service.Entity.Account;
import com.account_service.Repo.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService implements AccountServ{
    @Autowired
    private Repository repository;


    @Override
    public List<Account> getAllAccount() {
        return (List<Account>) repository.findAll();
    }

    @Override
    public Account addAccount(Account account) {
        return repository.save(account);
    }
    @Override
    public Account findById(Integer id) {
        return repository.findById(id).get();
    }
}

