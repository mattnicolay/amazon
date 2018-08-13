package com.solstice.amazon.summary;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class OrderSummary {
  private long orderNumber;
  private AddressSummary shippingAddress;
  private double totalPrice;
  @JsonProperty("orderLineItems")
  private List<OrderLineSummary> orderLineSummaries;
  @JsonProperty("shipments")
  private List<ShipmentSummary> shipmentSummaries;

  public OrderSummary(){}

  public OrderSummary(long orderNumber, AddressSummary shippingAddress, double totalPrice,
      List<OrderLineSummary> orderLineSummaries,
      List<ShipmentSummary> shipmentSummaries) {
    this.orderNumber = orderNumber;
    this.shippingAddress = shippingAddress;
    this.totalPrice = totalPrice;
    this.orderLineSummaries = orderLineSummaries;
    this.shipmentSummaries = shipmentSummaries;
  }

  public long getOrderNumber() {
    return orderNumber;
  }

  public void setOrderNumber(long orderNumber) {
    this.orderNumber = orderNumber;
  }

  public AddressSummary getShippingAddress() {
    return shippingAddress;
  }

  public void setShippingAddress(AddressSummary shippingAddress) {
    this.shippingAddress = shippingAddress;
  }

  public double getTotalPrice() {
    return totalPrice;
  }

  public void setTotalPrice(double totalPrice) {
    this.totalPrice = totalPrice;
  }

  public List<OrderLineSummary> getOrderLineSummaries() {
    return orderLineSummaries;
  }

  public void setOrderLineSummaries(List<OrderLineSummary> orderLineSummaries) {
    this.orderLineSummaries = orderLineSummaries;
  }

  public List<ShipmentSummary> getShipmentSummaries() {
    return shipmentSummaries;
  }

  public void setShipmentSummaries(List<ShipmentSummary> shipmentSummaries) {
    this.shipmentSummaries = shipmentSummaries;
  }
}
