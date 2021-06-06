package com.jing.hang.controller;

import com.jing.hang.service.StockBasicService;
import com.jing.hang.service.StockCompanyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



/**
 * @author noodles
 * @date 2021/6/4 5:49 下午
 */
@RestController
@RequestMapping("/api")
public class StockBasicController {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    StockBasicService stockBasicService;
    @Autowired
    StockCompanyService stockCompanyService;

    @GetMapping("/all/stocks")
    public void allStockData() {
        stockBasicService.syncAllStocks();

    }


    @GetMapping("/all/stocks/company")
    public void stockCompany() {
        stockCompanyService.stockCompany();

    }
}

