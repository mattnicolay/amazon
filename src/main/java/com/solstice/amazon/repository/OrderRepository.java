package com.solstice.amazon.repository;

import com.solstice.amazon.model.Order;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface OrderRepository  extends CrudRepository<Order, Long> {
  List<Order> findAllByAccountIdOrderByOrderDateAsc(@Param("accountId") long id);

//  @Query(value = "select new com.solstice.amazon.model.OrderDetail("
//      + "o.orderNumber, o.shippingAddress, o.totalPrice, o.orderLineItems, ol.shipment) "
//      + "from Order o join OrderLineItem ol join Shipment s "
//      + "on o.account.id = :accountId and s.id = ol.shipment.id")
//  OrderDetail getOrderDetails(@Param("accountId") long id);




}
