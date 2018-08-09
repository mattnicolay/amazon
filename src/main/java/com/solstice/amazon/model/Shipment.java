package com.solstice.amazon.model;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Shipment {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @OneToOne
  @JoinColumn(name = "accountId")
  private Account account;
  @OneToOne
  @JoinColumn(name = "shippingAddressId")
  private Address shippingAddress;
  @OneToMany
  @JoinColumn(name = "shipmentId")
  private List<OrderLineItem> orderLineItems;
  @Temporal(TemporalType.TIMESTAMP)
  private Date shippedDate;
  @Temporal(TemporalType.TIMESTAMP)
  private Date deliveryDate;

  public Shipment(){}

  public Shipment(Account account, Address shippingAddress,
      List<OrderLineItem> orderLineItems, Date shippedDate, Date deliveryDate) {
    this.account = account;
    this.shippingAddress = shippingAddress;
    this.orderLineItems = orderLineItems;
    this.shippedDate = shippedDate;
    this.deliveryDate = deliveryDate;
  }

  public void addOrderLineItem(OrderLineItem orderLineItem) {
    orderLineItems.add(orderLineItem);
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

  public List<OrderLineItem> getOrderLineItems() {
    return orderLineItems;
  }

  public void setOrderLineItems(List<OrderLineItem> orderLineItems) {
    this.orderLineItems = orderLineItems;
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
