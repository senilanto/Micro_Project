package com.account.Repo;

import com.account.Model.Account;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AccountRepository extends CrudRepository<Account,Integer> {

public List<Account> findByCustomerid(Integer id);

}
