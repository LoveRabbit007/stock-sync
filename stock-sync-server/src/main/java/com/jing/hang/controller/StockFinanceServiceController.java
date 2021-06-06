package com.jing.hang.controller;

import com.jing.hang.service.StockFinanceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")

public class StockFinanceServiceController {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    @Autowired
    StockFinanceService stockFinanceService;

    @GetMapping("/stocks/finance/income")
    public void allStockData() {
        stockFinanceService.stockIncome();

    }
}
