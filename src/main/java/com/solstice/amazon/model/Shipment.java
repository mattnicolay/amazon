package com.solstice.amazon.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Shipment {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @OneToOne
  private Account account;
  @OneToOne
  private Address shippingAddress;
  @OneToOne
  private OrderLineItem orderLineItem;
  @Temporal(TemporalType.TIMESTAMP)
  private Date shippedDate;
  @Temporal(TemporalType.TIMESTAMP)
  private Date deliveryDate;

  public Shipment(){}

  public Shipment(Account account, Address shippingAddress,
      OrderLineItem orderLineItem, Date shippedDate, Date deliveryDate) {
    this.account = account;
    this.shippingAddress = shippingAddress;
    this.orderLineItem = orderLineItem;
    this.shippedDate = shippedDate;
    this.deliveryDate = deliveryDate;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public Account getAccount() {
    return account;
  }

  public void setAccount(Account account) {
    this.account = account;
  }

  public Address getShippingAddress() {
    return shippingAddress;
  }

  public void setShippingAddress(Address shippingAddress) {
    this.shippingAddress = shippingAddress;
  }

  public OrderLineItem getOrderLineItem() {
    return orderLineItem;
  }

  public void setOrderLineItem(OrderLineItem orderLineItem) {
    this.orderLineItem = orderLineItem;
  }

  public Date getShippedDate() {
    return shippedDate;
  }

  public void setShippedDate(Date shippedDate) {
    this.shippedDate = shippedDate;
  }

  public Date getDeliveryDate() {
    return deliveryDate;
  }

  public void setDeliveryDate(Date deliveryDate) {
    this.deliveryDate = deliveryDate;
  }
}
