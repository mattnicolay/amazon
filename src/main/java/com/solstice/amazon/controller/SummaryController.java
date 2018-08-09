package com.solstice.amazon.controller;


import com.solstice.amazon.model.OrderDetail;
import com.solstice.amazon.service.SummaryService;
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

  @GetMapping("/orderDetails/{accountId}")
  public List<OrderDetail> getOrderDetails(@PathVariable(value = "accountId") long accountId) {
    return summaryService.getOrderDetails(accountId);
  }
}
