package com.solstice.amazon.controller;

import com.solstice.amazon.model.Account;
import com.solstice.amazon.service.AccountService;
import java.io.IOException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {

  private AccountService accountService;

  public AccountController(AccountService accountService) {
    this.accountService = accountService;
  }

  @GetMapping("/{accountId}")
  public Account get(@PathVariable long accountId) {

    return accountService.findById(accountId);
  }

  @PostMapping(value = "/save",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Account> save(@RequestBody String json) throws IOException {

    return new ResponseEntity<>(accountService.saveAccount(json), HttpStatus.CREATED);
  }

  @PostMapping(value = "/update",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Account> update(@RequestBody String json) throws IOException {

    return new ResponseEntity<>(accountService.updateAccount(json), HttpStatus.OK);
  }

  @PostMapping("/delete/{accountId}")
  public void delete(@PathVariable long accountId) {
    accountService.deleteById(accountId);
  }
}
