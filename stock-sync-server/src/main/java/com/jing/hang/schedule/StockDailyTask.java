package com.jing.hang.schedule;

import com.jing.hang.service.StockDailyService;
import com.jing.hang.vo.DailyVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class StockDailyTask {
    @Autowired
    StockDailyService stockDailyService;


    // @Scheduled(cron="0/15 * * * * ?")
    public void dailyStockTask() {
        DailyVo dailyVo = new DailyVo();
        stockDailyService.dailyStock(dailyVo);
    }

}
