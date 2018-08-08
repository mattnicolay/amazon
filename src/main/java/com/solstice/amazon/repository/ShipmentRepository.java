package com.solstice.amazon.repository;

import com.solstice.amazon.model.Shipment;
import org.springframework.data.repository.CrudRepository;

public interface ShipmentRepository  extends CrudRepository<Shipment, Long> {

}
