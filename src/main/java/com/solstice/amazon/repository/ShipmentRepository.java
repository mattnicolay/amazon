package com.solstice.amazon.repository;

import com.solstice.amazon.model.Shipment;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ShipmentRepository  extends CrudRepository<Shipment, Long> {
  List<Shipment> findAllByAccountId(@Param(value = "accountId") long id);

  List<Shipment> findAllByAccountIdOrderByDeliveryDate(@Param(value = "accountId") long id);

  @Query("select o.order.orderNumber from Shipment s join "
      + "OrderLineItem o "
      + "on o member of s.orderLineItems "
      + "and s.account.id = :accountId "
      + "and s.id = :shipmentId")
  long findOrderId(
      @Param(value = "accountId") long accountId,
      @Param(value = "shipmentId") long shipmentId);
}
