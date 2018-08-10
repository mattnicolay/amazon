package com.solstice.amazon.repository;

import com.solstice.amazon.model.OrderLineItem;
import com.solstice.amazon.summary.OrderLineSummary;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface OrderLineItemRepository  extends CrudRepository<OrderLineItem, Long> {

  @Query(value = "select new com.solstice.amazon.summary.OrderLineSummary(o.product.name, o.quantity) "
      + "from OrderLineItem o where o.id = :id")
  OrderLineSummary getOrderLineSummary(@Param(value = "id") long id);
}
