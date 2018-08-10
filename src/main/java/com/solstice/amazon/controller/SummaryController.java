package com.solstice.amazon.controller;


import com.solstice.amazon.summary.OrderDetail;
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

  @GetMapping("/orders/{accountId}")
  public List<OrderDetail> getOrderDetails(@PathVariable(value = "accountId") long accountId) {
    return summaryService.getOrderDetails(accountId);
  }

  @GetMapping("/shipments/{accountId}")
  public List<ShipmentSummary> getShipments(@PathVariable("accountId") long accountId) {
    return summaryService.getShipmentSummary(accountId);
  }
}
