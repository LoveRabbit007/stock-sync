package com.jing.hang.controller;

import com.jing.hang.po.StockBasic;
import com.jing.hang.service.StockFinanceService;
import com.jing.hang.vo.IncomeVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")

public class StockFinanceController {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    @Autowired
    StockFinanceService stockFinanceService;
    @Autowired
    private MongoTemplate mongoTemplate;

    @PostMapping("/finance/income")
    public void allStockData(@RequestBody IncomeVo incomeVo) {
        stockFinanceService.stockIncome(incomeVo);

    }

    /**
     *
     */
    @GetMapping("/finance/all/income")
    public void allIncome() {
        mongoTemplate.findAll(StockBasic.class).forEach(stockBasic -> {
            IncomeVo incomeVo = new IncomeVo();
            incomeVo.setTs_code(stockBasic.getId());
            stockFinanceService.stockIncome(incomeVo);
        });

    }


}
