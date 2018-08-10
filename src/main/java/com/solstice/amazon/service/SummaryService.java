package com.solstice.amazon.service;

import com.solstice.amazon.model.Order;
import com.solstice.amazon.repository.OrderLineItemRepository;
import com.solstice.amazon.summary.OrderDetail;
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

  public List<OrderDetail> getOrderDetails(long accountId) {

    List<Order> orders = orderRepository.findAllByAccountIdOrderByOrderDateAsc(accountId);
    List<OrderDetail> orderDetailList = new ArrayList<>();

    for (Order order : orders) {
      List<Shipment> shipments = new ArrayList<>();
      order.getOrderLineItems().forEach(o -> shipments.add(o.getShipment()));
      orderDetailList.add(new OrderDetail(
          order.getOrderNumber(),
          order.getShippingAddress(),
          order.getTotalPrice(),
          order.getOrderLineItems(),
          shipments));
    }

    return orderDetailList;
  }

  public List<ShipmentSummary> getShipmentSummary(long accountId) {
    List<Shipment> shipments = shipmentRepository.findAllByAccountIdOrderByDeliveryDate(accountId);
    List<ShipmentSummary> shipmentSummaries = new ArrayList<>();

    for (Shipment shipment : shipments) {
      long orderNumber = shipmentRepository.findOrderId(accountId, shipment.getId());
      List<OrderLineSummary> orderLineSummaries = new ArrayList<>();

      shipment.getOrderLineItems().forEach(o ->
        orderLineSummaries.add(orderLineItemRepository.getOrderLineSummary(o.getId()))
      );
      shipmentSummaries.add(new ShipmentSummary(
          orderNumber,
          shipment.getShippedDate(),
          shipment.getDeliveryDate(),
          orderLineSummaries)
      );
    }

    return shipmentSummaries;
  }
}
