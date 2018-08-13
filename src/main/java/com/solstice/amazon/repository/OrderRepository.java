package com.solstice.amazon.repository;

import com.solstice.amazon.model.Order;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface OrderRepository  extends CrudRepository<Order, Long> {
  List<Order> findAllByAccountIdOrderByOrderDateAsc(@Param("accountId") long id);
}
