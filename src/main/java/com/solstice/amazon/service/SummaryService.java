package com.solstice.amazon.service;

import com.solstice.amazon.model.Order;
import com.solstice.amazon.repository.OrderLineItemRepository;
import com.solstice.amazon.summary.AddressSummary;
import com.solstice.amazon.summary.OrderSummary;
import com.solstice.amazon.model.Shipment;
import com.solstice.amazon.repository.OrderRepository;
import com.solstice.amazon.repository.ShipmentRepository;
import com.solstice.amazon.summary.OrderLineSummary;
import com.solstice.amazon.summary.ShipmentSummary;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class SummaryService {

  private OrderRepository orderRepository;
  private ShipmentRepository shipmentRepository;
  private OrderLineItemRepository orderLineItemRepository;

  public SummaryService(OrderRepository orderRepository, ShipmentRepository shipmentRepository,
      OrderLineItemRepository orderLineItemRepository) {
    this.orderRepository = orderRepository;
    this.shipmentRepository = shipmentRepository;
    this.orderLineItemRepository = orderLineItemRepository;
  }

  public List<OrderSummary> getOrderSummary(long accountId) {

    List<Order> orders = orderRepository.findAllByAccountIdOrderByOrderDateAsc(accountId);
    List<OrderSummary> orderSummaryList = new ArrayList<>();

    for (Order order : orders) {
      List<ShipmentSummary> shipmentSummaries = getShipmentSummaryByOrderNumber(order.getOrderNumber());
      List<OrderLineSummary> orderLineSummaries = new ArrayList<>();
      order.getOrderLineItems().forEach(o -> {
        orderLineSummaries.add(orderLineItemRepository.getOrderLineSummary(o.getId()));
      });

      orderSummaryList.add(new OrderSummary(
          order.getOrderNumber(),
          new AddressSummary(order.getShippingAddress()),
          order.getTotalPrice(),
          orderLineSummaries,
          shipmentSummaries));
    }

    return orderSummaryList;
  }

  public List<ShipmentSummary> getShipmentSummaryByOrderNumber(long orderNumber) {
    List<Shipment> shipments = shipmentRepository.findAllByOrderId(orderNumber);
    List<ShipmentSummary> shipmentSummaries = new ArrayList<>();

    shipments.forEach(shipment ->
        shipmentSummaries.add(getShipmentSummaryFromShipment(shipment, orderNumber))
    );

    return shipmentSummaries;
  }

  public List<ShipmentSummary> getShipmentSummary(long accountId) {
    List<Shipment> shipments = shipmentRepository.findAllByAccountIdOrderByDeliveryDate(accountId);
    List<ShipmentSummary> shipmentSummaries = new ArrayList<>();

    for (Shipment shipment : shipments) {
      long orderNumber = shipmentRepository.findOrderId(accountId, shipment.getId());
      shipmentSummaries.add(getShipmentSummaryFromShipment(shipment, orderNumber));
    }

    return shipmentSummaries;
  }

  private ShipmentSummary getShipmentSummaryFromShipment(Shipment shipment, long orderNumber) {
    List<OrderLineSummary> orderLineSummaries = new ArrayList<>();

    shipment.getOrderLineItems().forEach(o ->
        orderLineSummaries.add(orderLineItemRepository.getOrderLineSummary(o.getId()))
    );

    return new ShipmentSummary(
        shipment.getId(),
        orderNumber,
        shipment.getShippedDate(),
        shipment.getDeliveryDate(),
        orderLineSummaries);
  }
}
