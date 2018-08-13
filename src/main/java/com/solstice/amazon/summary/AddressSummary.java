package com.solstice.amazon.summary;

import com.solstice.amazon.model.Address;

public class AddressSummary {
  private String street;
  private String apartment;
  private String city;
  private String state;
  private String zip;
  private String country;

  public AddressSummary(Address address) {
    this(address.getStreet(), address.getApartment(), address.getCity(), address.getState(),
        address.getZip(), address.getCountry());
  }

  public AddressSummary(String street, String apartment, String city, String state,
      String zip, String country) {
    this.street = street;
    this.apartment = apartment;
    this.city = city;
    this.state = state;
    this.zip = zip;
    this.country = country;
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public String getApartment() {
    return apartment;
  }

  public void setApartment(String apartment) {
    this.apartment = apartment;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getZip() {
    return zip;
  }

  public void setZip(String zip) {
    this.zip = zip;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }
}
