package com.account.Service;

import com.account.Model.Account;
import com.account.Model.RequestPut;
import com.account.Repo.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService implements AccountInterface {
    @Autowired
    private AccountRepository repository;

@Override
    public List<Account> getAllAccount() {
        return (List<Account>) repository.findAll();
    }

    @Override
    public Account addAccount(Account account) {

        return repository.save(account);
    }

    @Override
    public Account findById(Integer id){

    return repository.findById(id).get();
    }

    @Override
    public List<Account> getCustomerById(Integer id) {
        return repository.findByCustomerid(id);
    }

    @Override
    public List<Account> updateAccountBalance(RequestPut requestPut) {
        List<Account> a = repository.findByCustomerid(requestPut.getUnquie_id());
        List<Account> b = repository.findByCustomerid(requestPut.getUnquie_id());
        for (Account c : a) {
            if (c.getAccountType().compareTo(requestPut.getAccountType()) == 0) {
                Float f = c.getAccountBalance();
                Float res = f + requestPut.getCash();
                c.setAccountBalance(res);
                repository.save(c);
            } else
                b.remove(c);
        }
            return b;


        }

    @Override
    public List<Account> updateActive(Integer id){
        List<Account> ca = repository.findByCustomerid(id);

        for(Account i :ca){
            i.setIsActive(false);
            repository.save(i);
        }
        List<Account> ca1 = repository.findByCustomerid(id);
        return  ca1;

    }


}