package com.solstice.amazon.repository;

import com.solstice.amazon.model.OrderLineItem;
import org.springframework.data.repository.CrudRepository;

public interface OrderLineItemRepository  extends CrudRepository<OrderLineItem, Long> {

}
