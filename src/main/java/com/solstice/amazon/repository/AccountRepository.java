package com.solstice.amazon.repository;

import com.solstice.amazon.model.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Long> {

}
