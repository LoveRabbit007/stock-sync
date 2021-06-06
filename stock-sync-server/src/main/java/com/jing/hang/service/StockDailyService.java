package com.jing.hang.service;

import com.jing.hang.vo.DailyVo;

public interface StockDailyService {
    void dailyStock(DailyVo dailyVo);

    void dailyBasicStock(DailyVo dailyVo);
}
