package com.jing.hang.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.jing.hang.constant.MoFangConstant;
import com.jing.hang.po.StockDailyBasic;
import com.jing.hang.po.StockInCome;
import com.jing.hang.service.StockFinanceService;
import com.jing.hang.utils.HttpUtils;
import com.jing.hang.utils.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StockFinanceServiceImpl implements StockFinanceService {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Override
    public void stockIncome() {
        JSONObject requestJSON = new JSONObject();
        requestJSON.put("api_name", "income");
        requestJSON.put("token", MoFangConstant.TOKEN);
        Map<String, String> params = new HashMap<>();
        params.put("ts_code", "300085.SZ");
        requestJSON.put("params", params);
        String fields = StringUtil.handRequestParams(new StockInCome().toString());
        requestJSON.put("fields", fields);
        JSONObject result = HttpUtils.doPostJson(MoFangConstant.URL, requestJSON.toString());
        StockDailyBasic stockDailyBasic = new StockDailyBasic();
        stockDailyBasic.toString();
        LOGGER.info(StringUtil.handRequestParams(stockDailyBasic.toString()));
        List<StockDailyBasic> stockDailyBasics = new ArrayList<>();
    }

}
