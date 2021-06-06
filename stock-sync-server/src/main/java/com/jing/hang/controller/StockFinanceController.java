package com.jing.hang.controller;

import com.jing.hang.service.StockFinanceService;
import com.jing.hang.vo.IncomeVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")

public class StockFinanceController {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    @Autowired
    StockFinanceService stockFinanceService;

    @PostMapping("/finance/income")
    public void allStockData(@RequestBody IncomeVo incomeVo) {
        stockFinanceService.stockIncome(incomeVo);

    }
}
