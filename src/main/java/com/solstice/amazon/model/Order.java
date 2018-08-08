package com.solstice.amazon.model;

import java.sql.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Order {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long orderNumber;
  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "accountId")
  private Account account;
  @Temporal(TemporalType.TIMESTAMP)
  private Date orderDate;
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "shippingAddressId")
  private Address shippingAddress;
  @OneToMany(cascade = CascadeType.ALL)
  private List<OrderLineItem> orderLineItems;
  private double totalPrice;

  public Order(){}

  public Order(Account account, Date orderDate, Address shippingAddress,
      List<OrderLineItem> orderLineItems, double totalPrice) {
    this.account = account;
    this.orderDate = orderDate;
    this.shippingAddress = shippingAddress;
    this.orderLineItems = orderLineItems;
    this.totalPrice = totalPrice;
  }

  public long getOrderNumber() {
    return orderNumber;
  }

  public void setOrderNumber(long orderNumber) {
    this.orderNumber = orderNumber;
  }

  public Account getAccount() {
    return account;
  }

  public void setAccount(Account account) {
    this.account = account;
  }

  public Date getOrderDate() {
    return orderDate;
  }

  public void setOrderDate(Date orderDate) {
    this.orderDate = orderDate;
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

  public double getTotalPrice() {
    return totalPrice;
  }

  public void setTotalPrice(double totalPrice) {
    this.totalPrice = totalPrice;
  }
}
