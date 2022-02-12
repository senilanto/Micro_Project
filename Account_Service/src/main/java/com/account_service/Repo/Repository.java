package com.account_service.Repo;

import com.account_service.Entity.Account;
import org.springframework.data.repository.CrudRepository;

public interface Repository extends CrudRepository<Account,Integer> {
}
