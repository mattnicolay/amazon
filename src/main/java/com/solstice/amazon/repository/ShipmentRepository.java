package com.solstice.amazon.repository;

import com.solstice.amazon.model.Shipment;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ShipmentRepository  extends CrudRepository<Shipment, Long> {
  List<Shipment> findAllByAccountId(@Param(value = "accountId") long id);
}
