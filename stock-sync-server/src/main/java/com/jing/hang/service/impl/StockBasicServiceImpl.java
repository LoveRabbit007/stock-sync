package com.jing.hang.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jing.hang.constant.MoFangConstant;
import com.jing.hang.po.StockBasic;
import com.jing.hang.service.StockBasicService;
import com.jing.hang.utils.HttpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StockBasicServiceImpl implements StockBasicService {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void syncAllStocks() {
        JSONObject requestJSON = new JSONObject();
        requestJSON.put("api_name", "stock_basic");
        requestJSON.put("token", MoFangConstant.TOKEN);
        Map<String, String> params = new HashMap<>();
        params.put("exchange", "");
        params.put("start_date", "20180901");
        params.put("end_date", "20181001");
        params.put("is_open", "0");
        requestJSON.put("params", params);
        requestJSON.put("fields", "ts_code,symbol,name,area,industry," +
            "fullname,enname,cnspell,market,exchange,curr_type,"
            + "list_status,list_date,delist_date,is_hs,industry,area");
        JSONObject result = HttpUtils.doPostJson(MoFangConstant.URL, requestJSON.toString());
        String jsonObject = result.get("data").toString();
        JSONObject jsonObject1 = JSONObject.parseObject(jsonObject);
        List<List> stocks = JSON.parseArray(jsonObject1.get("items").toString(), List.class);
        List<StockBasic> stockBasics = new ArrayList<>();
        for (List<String> stock : stocks) {
            StockBasic stockBasic = new StockBasic();
            stockBasic.setId(stock.get(0));
            stockBasic.setSymbol(stock.get(1));
            stockBasic.setName(stock.get(2));
            stockBasic.setArea(stock.get(3));
            stockBasic.setIndustry(stock.get(4));
            stockBasic.setFullName(stock.get(5));
            stockBasic.setEnName(stock.get(6));
            stockBasic.setCnSpell(stock.get(7));
            stockBasic.setMarket(stock.get(8));
            stockBasic.setExchange(stock.get(9));
            stockBasic.setCurrType(stock.get(10));
            stockBasic.setListStatus(stock.get(11));
            switch (stock.get(11)) {
                case "L":
                    stockBasic.setListName("上市");
                    break;
                case "D":
                    stockBasic.setListName("退市");
                    break;
                case "P":
                    stockBasic.setListName("暂停上市");
                    break;
            }
            stockBasic.setListDate(stock.get(12));
            stockBasic.setDeListDate(stock.get(13));
            stockBasic.setIsHs(stock.get(14));
            Optional.ofNullable(stock.get(14)).ifPresent(s -> {
                switch (stock.get(14)) {
                    case "N":
                        stockBasic.setHsName("未开通");
                        break;
                    case "H":
                        stockBasic.setHsName("沪股通");
                        break;
                    case "S":
                        stockBasic.setHsName("深股通");
                        break;
                }
            });

            stockBasics.add(stockBasic);
        }
        mongoTemplate.insertAll(stockBasics);

    }
}
