package com.solstice.amazon.service;

import com.solstice.amazon.model.Order;
import com.solstice.amazon.model.OrderDetail;
import com.solstice.amazon.model.OrderLineItem;
import com.solstice.amazon.model.Shipment;
import com.solstice.amazon.repository.OrderRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class SummaryService {

  private OrderRepository orderRepository;

  public SummaryService(OrderRepository orderRepository) {
    this.orderRepository = orderRepository;
  }

  public List<OrderDetail> getOrderDetails(long accountId) {

    List<Order> orders = orderRepository.findAllByAccountIdOrderByOrderDateAsc(accountId);
    List<OrderDetail> orderDetailList = new ArrayList<>();

    for (Order order : orders) {
      List<Shipment> shipments = new ArrayList<>();
      for (OrderLineItem orderLineItem : order.getOrderLineItems()) {
        shipments.add(orderLineItem.getShipment());
      }
      orderDetailList.add(new OrderDetail(
          order.getOrderNumber(),
          order.getShippingAddress(),
          order.getTotalPrice(),
          order.getOrderLineItems(),
          shipments));
    }

    return orderDetailList;
  }
}
