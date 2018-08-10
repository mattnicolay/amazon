package com.solstice.amazon.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "orderNumber")
@Entity
@Table(name="orders")
public class Order {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long orderNumber;
  @ManyToOne
  @JoinColumn(name = "accountId")
  private Account account;
  @Temporal(TemporalType.TIMESTAMP)
  private Date orderDate;
  @ManyToOne
  @JoinColumn(name = "shippingAddressId")
  private Address shippingAddress;
  @OneToMany
  @JoinColumn(name = "orderId")
  private List<OrderLineItem> orderLineItems;
  @Transient
  private double totalPrice;

  public Order(){}

  public Order(Account account, Date orderDate, Address shippingAddress,
      List<OrderLineItem> orderLineItems) {
    this.account = account;
    this.orderDate = orderDate;
    this.shippingAddress = shippingAddress;
    this.orderLineItems = orderLineItems;
    setTotalPrice();
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
//    this.account.addOrder(this);
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
    setTotalPrice();
  }

  public void addOrderLineItem(OrderLineItem orderLineItem) {
    orderLineItems.add(orderLineItem);
    setTotalPrice();
  }

  public void removeOrderLineItem(OrderLineItem orderLineItem) {
    orderLineItems.remove(orderLineItem);
    setTotalPrice();
  }

  public double getTotalPrice() {
    return totalPrice;
  }

  @PreUpdate
  @PrePersist
  private void setTotalPrice() {
    totalPrice = 0;
    this.orderLineItems.forEach(o -> totalPrice += o.getTotalPrice());
  }
}
