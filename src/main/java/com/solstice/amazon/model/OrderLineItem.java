package com.solstice.amazon.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

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
  @OneToOne
  @JoinColumn(name = "shipmentId")
  private Shipment shipment;

  public OrderLineItem(){}

  public OrderLineItem(Product product, int quantity, double price, double totalPrice,
      Shipment shipment) {
    this.product = product;
    this.quantity = quantity;
    this.price = price;
    this.totalPrice = totalPrice;
    this.shipment = shipment;
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
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public double getTotalPrice() {
    return totalPrice;
  }

  public void setTotalPrice(double totalPrice) {
    this.totalPrice = totalPrice;
  }

  public Shipment getShipment() {
    return shipment;
  }

  public void setShipment(Shipment shipment) {
    this.shipment = shipment;
  }
}
