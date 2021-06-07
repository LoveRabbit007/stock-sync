package com.jing.hang.controller;


import com.jing.hang.service.StockDailyService;
import com.jing.hang.utils.DateHandUtil;
import com.jing.hang.vo.DailyVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;

@RestController
@RequestMapping("/api")
public class StockDailyController {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    StockDailyService stockDailyService;


    @PostMapping("/daily/stocks")
    public void dailyStock(@RequestBody DailyVo dailyVo) throws InterruptedException {
        String begin = "1990-12-01";
        Date date = DateHandUtil.parse(begin);
        Date date1 = new Date();
        while (date.getTime() < date1.getTime()) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            dailyVo.setTradeDate(DateHandUtil.formatDate(date).replaceAll("-", ""));
            stockDailyService.dailyStock(dailyVo);
            date = DateHandUtil.plusTime(cal, Calendar.DAY_OF_MONTH, -1);
            Thread.sleep(1000);
        }
    }

    @PostMapping("/daily/basic/stocks")
    public void dailyBasicStock(@RequestBody DailyVo dailyVo) throws InterruptedException {
        String begin = "1990-12-01";
        Date date = DateHandUtil.parse(begin);
        Date date1 = new Date();
        while (date.getTime() < date1.getTime()) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            dailyVo.setTradeDate(DateHandUtil.formatDate(date).replaceAll("-", ""));
            stockDailyService.dailyBasicStock(dailyVo);
            date = DateHandUtil.plusTime(cal, Calendar.DAY_OF_MONTH, -1);
            Thread.sleep(1000);
        }
    }


}
