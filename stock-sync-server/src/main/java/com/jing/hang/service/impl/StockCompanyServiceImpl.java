package com.jing.hang.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jing.hang.constant.MoFangConstant;
import com.jing.hang.po.StockCompany;
import com.jing.hang.service.StockCompanyService;
import com.jing.hang.utils.HttpUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service
public class StockCompanyServiceImpl implements StockCompanyService {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void stockCompany() {
        JSONObject requestJSON = new JSONObject();
        requestJSON.put("api_name", "stock_company");
        requestJSON.put("token", MoFangConstant.TOKEN);
        Map<String, String> params = new HashMap<>();
        params.put("ts_code", "");
//        params.put("start_date", "20180901");
//        params.put("end_date", "20181001");
        params.put("exchange", "");
        requestJSON.put("params", params);
        requestJSON.put("fields", "ts_code,exchange,chairman,manager,secretary,reg_capital,setup_date,province," +
            "city,introduction,website,email,office,employees,main_business,business_scope");
        JSONObject result = HttpUtils.doPostJson(MoFangConstant.URL, requestJSON.toString());
        String jsonObject = result.get("data").toString();
        JSONObject jsonObject1 = JSONObject.parseObject(jsonObject);
        List<List> stocks = JSON.parseArray(jsonObject1.get("items").toString(), List.class);
        List<StockCompany> stockCompanies = new ArrayList<>();
        for (List<Object> stock : stocks) {
            StockCompany stockCompany = new StockCompany();
            Optional.ofNullable(stock.get(0)).ifPresent(s->{
                stockCompany.setTsCode(stock.get(0).toString());
            });

            Optional.ofNullable(stock.get(1)).ifPresent(s->{
                stockCompany.setExchange(stock.get(1).toString());
            });

            Optional.ofNullable(stock.get(2)).ifPresent(s->{
                stockCompany.setChairman(stock.get(2).toString());
            });

            Optional.ofNullable(stock.get(3)).ifPresent(s->{
                stockCompany.setManager(stock.get(3).toString());
            });
            Optional.ofNullable(stock.get(4)).ifPresent(s->{
                stockCompany.setSecretary(stock.get(4).toString());
            });


            Optional.ofNullable(stock.get(5)).ifPresent(s->{
                stockCompany.setRegCapital(new BigDecimal(stock.get(5).toString()).floatValue());
            });


            Optional.ofNullable(stock.get(6)).ifPresent(s->{
                stockCompany.setSetupDate(stock.get(6).toString());
            });


            Optional.ofNullable(stock.get(7)).ifPresent(s->{
                stockCompany.setProvince(stock.get(7).toString());
            });


            Optional.ofNullable(stock.get(8)).ifPresent(s->{
                stockCompany.setCity(stock.get(8).toString());
            });


            Optional.ofNullable(stock.get(9)).ifPresent(s->{
                stockCompany.setIntroduction(stock.get(9).toString());
            });


            Optional.ofNullable(stock.get(10)).ifPresent(s->{
                stockCompany.setWebsite(stock.get(10).toString());
            });
            Optional.ofNullable(stock.get(11)).ifPresent(s->{
                stockCompany.setEmail(stock.get(11).toString());
            });
            Optional.ofNullable(stock.get(12)).ifPresent(s->{
                stockCompany.setOffice(stock.get(12).toString());
            });

            Optional.ofNullable(stock.get(14)).ifPresent(s->{
                stockCompany.setEmployees(Integer.valueOf(stock.get(14).toString()).intValue());
            });

            Optional.ofNullable(stock.get(13)).ifPresent(s->{
                stockCompany.setMainBusiness(stock.get(13).toString());
            });

            Optional.ofNullable(stock.get(15)).ifPresent(s->{
                stockCompany.setBusinessScope(stock.get(15).toString());
            });
            stockCompany.setId(stockCompany.getTsCode());
            stockCompanies.add(stockCompany);
        }

        mongoTemplate.insertAll(stockCompanies);
    }
}
