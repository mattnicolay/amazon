package com.solstice.amazon.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.solstice.amazon.model.Account;
import com.solstice.amazon.repository.AccountRepository;
import java.io.IOException;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

  private AccountRepository accountRepository;

  public AccountService(AccountRepository accountRepository) {
    this.accountRepository = accountRepository;
  }

  public Account findById(long id) {
    return accountRepository.findById(id);
  }

  private void save(Account account) {
    accountRepository.save(account);
  }

  private Account getAccountFromJson(String json) throws IOException {
    ObjectMapper jsonMapper = new ObjectMapper();

    return jsonMapper.readValue(json, Account.class);
  }

  public Account saveAccount(String json) throws IOException {
    Account account = getAccountFromJson(json);
    save(account);
    return account;
  }

  public Account updateAccount(String json) throws IOException {
    Account newAccount = getAccountFromJson(json);
    Account oldAccount = findById(newAccount.getId());

    oldAccount.setFirstName(newAccount.getFirstName());
    oldAccount.setLastName(newAccount.getLastName());
    oldAccount.setEmail(newAccount.getEmail());
    oldAccount.setAddresses(newAccount.getAddresses());

    save(oldAccount);
    return oldAccount;
  }

  public void deleteById(long id) {
    accountRepository.deleteById(id);
  }
}
