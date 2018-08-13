package com.solstice.amazon.controller;


import com.solstice.amazon.summary.OrderSummary;
import com.solstice.amazon.service.SummaryService;
import com.solstice.amazon.summary.ShipmentSummary;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/summary")
public class SummaryController {

  private SummaryService summaryService;

  public SummaryController(SummaryService summaryService) {
    this.summaryService = summaryService;
  }

  @GetMapping("/ordersByAccount/{accountId}")
  public List<OrderSummary> getOrderSummary(@PathVariable(value = "accountId") long accountId) {
    return summaryService.getOrderSummary(accountId);
  }

  @GetMapping("/shipmentsByAccount/{accountId}")
  public List<ShipmentSummary> getShipments(@PathVariable("accountId") long accountId) {
    return summaryService.getShipmentSummary(accountId);
  }
}
