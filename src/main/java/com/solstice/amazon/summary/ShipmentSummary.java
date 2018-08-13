package com.solstice.amazon.summary;

import java.util.Date;
import java.util.List;

public class ShipmentSummary {

  private long shipmentId;
  private long orderNumber;
  private Date shipmentDate;
  private Date deliveryDate;
  private List<OrderLineSummary> orderLineSummaries;

  public ShipmentSummary(long shipmentId, long orderNumber, Date shipmentDate, Date deliveryDate,
      List<OrderLineSummary> orderLineSummaries) {
    this.shipmentId = shipmentId;
    this.orderNumber = orderNumber;
    this.shipmentDate = shipmentDate;
    this.deliveryDate = deliveryDate;
    this.orderLineSummaries = orderLineSummaries;
  }

  public long getShipmentId() {
    return shipmentId;
  }

  public void setShipmentId(long shipmentId) {
    this.shipmentId = shipmentId;
  }

  public long getOrderNumber() {
    return orderNumber;
  }

  public void setOrderNumber(long orderNumber) {
    this.orderNumber = orderNumber;
  }

  public Date getShipmentDate() {
    return shipmentDate;
  }

  public void setShipmentDate(Date shipmentDate) {
    this.shipmentDate = shipmentDate;
  }

  public Date getDeliveryDate() {
    return deliveryDate;
  }

  public void setDeliveryDate(Date deliveryDate) {
    this.deliveryDate = deliveryDate;
  }

  public List<OrderLineSummary> getOrderLineSummaries() {
    return orderLineSummaries;
  }

  public void setOrderLineSummaries(
      List<OrderLineSummary> orderLineSummaries) {
    this.orderLineSummaries = orderLineSummaries;
  }
}
