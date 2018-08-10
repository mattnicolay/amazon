package com.solstice.amazon.summary;

import com.solstice.amazon.model.Address;
import com.solstice.amazon.model.OrderLineItem;
import com.solstice.amazon.model.Shipment;
import java.util.List;

public class OrderDetail {
  private long orderNumber;
  private Address shippingAddress;
  private double totalPrice;
  private List<OrderLineItem> orderLineItems;
  private List<Shipment> shipments;

  public OrderDetail(){}

  public OrderDetail(long orderNumber, Address shippingAddress, double totalPrice,
      List<OrderLineItem> orderLineItems,
      List<Shipment> shipments) {
    this.orderNumber = orderNumber;
    this.shippingAddress = shippingAddress;
    this.totalPrice = totalPrice;
    this.orderLineItems = orderLineItems;
    this.shipments = shipments;
  }

  public long getOrderNumber() {
    return orderNumber;
  }

  public void setOrderNumber(long orderNumber) {
    this.orderNumber = orderNumber;
  }

  public Address getShippingAddress() {
    return shippingAddress;
  }

  public void setShippingAddress(Address shippingAddress) {
    this.shippingAddress = shippingAddress;
  }

  public double getTotalPrice() {
    return totalPrice;
  }

  public void setTotalPrice(double totalPrice) {
    this.totalPrice = totalPrice;
  }

  public List<OrderLineItem> getOrderLineItems() {
    return orderLineItems;
  }

  public void setOrderLineItems(List<OrderLineItem> orderLineItems) {
    this.orderLineItems = orderLineItems;
  }

  public List<Shipment> getShipments() {
    return shipments;
  }

  public void setShipments(List<Shipment> shipments) {
    this.shipments = shipments;
  }
}
