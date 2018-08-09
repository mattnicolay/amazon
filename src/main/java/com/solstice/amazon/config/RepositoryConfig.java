package com.solstice.amazon.config;

import com.solstice.amazon.model.Account;
import com.solstice.amazon.model.Address;
import com.solstice.amazon.model.Order;
import com.solstice.amazon.model.OrderLineItem;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

@Configuration
public class RepositoryConfig extends RepositoryRestConfigurerAdapter {
  @Override
  public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
    config.exposeIdsFor(Account.class);
    config.exposeIdsFor(Address.class);
    config.exposeIdsFor(Order.class);
    config.exposeIdsFor(OrderLineItem.class);
  }
}