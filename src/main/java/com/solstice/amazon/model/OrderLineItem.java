package com.solstice.amazon.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity
public class OrderLineItem {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @OneToOne
  @JoinColumn(name = "productId")
  private Product product;
  private int quantity;
  private double price;
  private double totalPrice;
  @ManyToOne
  @JoinColumn(name = "shipmentId")
  private Shipment shipment;
  @ManyToOne
  @JoinColumn(name = "orderId")
  private Order order;

  public OrderLineItem(){}

  public OrderLineItem(Product product, int quantity, double price,
      Shipment shipment, Order order) {
    this.product = product;
    this.quantity = quantity;
    this.price = price;
    setTotalPrice();
    this.shipment = shipment;
    this.order = order;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
    setTotalPrice();
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
    setTotalPrice();
  }

  public double getTotalPrice() {
    return totalPrice;
  }

  public Shipment getShipment() {
    return shipment;
  }

  public void setShipment(Shipment shipment) {
    this.shipment = shipment;
    this.shipment.addOrderLineItem(this);
  }

  @PreUpdate
  @PrePersist
  public void setTotalPrice() {
    totalPrice = price*quantity;
  }

  public Order getOrder() {
    return order;
  }

  public void setOrder(Order order) {
    this.order = order;
    this.order.addOrderLineItem(this);
  }
}
