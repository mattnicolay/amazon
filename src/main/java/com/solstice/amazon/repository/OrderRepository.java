package com.solstice.amazon.repository;

import com.solstice.amazon.model.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository  extends CrudRepository<Order, Long> {

}
