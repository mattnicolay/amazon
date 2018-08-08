package com.solstice.amazon.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AmazonController {

  @GetMapping
  public String home(){
    return "Welcome to the Amazon e-commerce web service!";
  }
}
