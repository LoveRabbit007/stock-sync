package com.jing.hang.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jing.hang.constant.MoFangConstant;
import com.jing.hang.po.StockDaily;
import com.jing.hang.po.StockDailyBasic;
import com.jing.hang.service.StockDailyService;
import com.jing.hang.utils.HttpUtils;
import com.jing.hang.vo.DailyVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service
public class StockDailyServiceImpl implements StockDailyService {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void dailyStock(DailyVo dailyVo) {
        JSONObject requestJSON = new JSONObject();
        requestJSON.put("api_name", "daily");
        requestJSON.put("token", MoFangConstant.TOKEN);
        Map<String, String> params = new HashMap<>();
        params.put("ts_code", dailyVo.getTsCode());
        params.put("trade_date", dailyVo.getTradeDate());
        params.put("start_date", dailyVo.getStartDate());
        params.put("end_date", dailyVo.getEndDate());
        requestJSON.put("params", params);
        requestJSON.put("fields", "ts_code,trade_date,open,high,low,close,pre_close,change," +
            "pct_chg,vol,amount");
        JSONObject result = HttpUtils.doPostJson(MoFangConstant.URL, requestJSON.toString());
        String jsonObject = result.get("data").toString();
        JSONObject jsonObject1 = JSONObject.parseObject(jsonObject);
        List<List> stocks = JSON.parseArray(jsonObject1.get("items").toString(), List.class);
        List<StockDaily> stockDailies = new ArrayList<>();
        for (List<Object> stock : stocks) {
            StockDaily stockDaily = new StockDaily();
            Optional.ofNullable(stock.get(0)).ifPresent(s -> {
                stockDaily.setTsCode(stock.get(0).toString());
            });

            Optional.ofNullable(stock.get(1)).ifPresent(s -> {
                stockDaily.setTradeDate(stock.get(1).toString());
            });

            Optional.ofNullable(stock.get(2)).ifPresent(s -> {
                stockDaily.setOpen(new BigDecimal(stock.get(2).toString()));

            });

            Optional.ofNullable(stock.get(3)).ifPresent(s -> {
                stockDaily.setHigh(new BigDecimal(stock.get(3).toString()));
            });

            Optional.ofNullable(stock.get(4)).ifPresent(s -> {
                stockDaily.setLow(new BigDecimal(stock.get(4).toString()));
            });

            Optional.ofNullable(stock.get(5)).ifPresent(s -> {
                stockDaily.setClose(new BigDecimal(stock.get(5).toString()));
            });

            Optional.ofNullable(stock.get(6)).ifPresent(s -> {
                stockDaily.setPreClose(new BigDecimal(stock.get(6).toString()));
            });

            Optional.ofNullable(stock.get(7)).ifPresent(s -> {
                stockDaily.setChange(new BigDecimal(stock.get(7).toString()));
            });
            Optional.ofNullable(stock.get(8)).ifPresent(s -> {
                stockDaily.setPctChg(new BigDecimal(stock.get(8).toString()));
            });

            Optional.ofNullable(stock.get(9)).ifPresent(s -> {
                stockDaily.setVol(new BigDecimal(stock.get(9).toString()).multiply(new BigDecimal(100)));
            });
            Optional.ofNullable(stock.get(10)).ifPresent(s -> {
                stockDaily.setAmount(new BigDecimal(stock.get(10).toString()).multiply(new BigDecimal(1000)));
            });
            stockDaily.setId(stockDaily.getTradeDate() + "-" + stockDaily.getTsCode());
            stockDailies.add(stockDaily);
        }
        mongoTemplate.insertAll(stockDailies);
    }

    @Override
    public void dailyBasicStock(DailyVo dailyVo) {
        JSONObject requestJSON = new JSONObject();
        requestJSON.put("api_name", "daily_basic");
        requestJSON.put("token", MoFangConstant.TOKEN);
        Map<String, String> params = new HashMap<>();
        params.put("ts_code", dailyVo.getTsCode());
        params.put("trade_date", dailyVo.getTradeDate());
        params.put("start_date", dailyVo.getStartDate());
        params.put("end_date", dailyVo.getEndDate());
        requestJSON.put("params", params);
        requestJSON.put("fields", "ts_code,trade_date,close,turnover_rate,turnover_rate_f,volume_ratio,pe,pe_ttm," +
            "pb,ps,ps_ttm,dv_ratio,dv_ttm,total_share,float_share,free_share,total_mv,circ_mv");
        JSONObject result = HttpUtils.doPostJson(MoFangConstant.URL, requestJSON.toString());
        List<StockDailyBasic> stockDailyBasics = new ArrayList<>();
        try {
            String jsonObject = result.get("data").toString();
            JSONObject jsonObject1 = JSONObject.parseObject(jsonObject);
            List<List> stocks = JSON.parseArray(jsonObject1.get("items").toString(), List.class);

            for (List<Object> stock : stocks) {
                StockDailyBasic stockDailyBasic = new StockDailyBasic();
                Optional.ofNullable(stock.get(0)).ifPresent(s -> {
                    stockDailyBasic.setTs_code(stock.get(0).toString());
                });
                Optional.ofNullable(stock.get(1)).ifPresent(s -> {
                    stockDailyBasic.setTrade_date(stock.get(1).toString());
                });
                Optional.ofNullable(stock.get(2)).ifPresent(s -> {
                    stockDailyBasic.setClose(new BigDecimal(stock.get(2).toString()));
                });
                Optional.ofNullable(stock.get(3)).ifPresent(s -> {
                    stockDailyBasic.setTurnover_rate(new BigDecimal(stock.get(3).toString()));
                });
                Optional.ofNullable(stock.get(4)).ifPresent(s -> {
                    stockDailyBasic.setTurnover_rate_f(new BigDecimal(stock.get(4).toString()));
                });

                Optional.ofNullable(stock.get(5)).ifPresent(s -> {
                    stockDailyBasic.setVolume_ratio(new BigDecimal(stock.get(5).toString()));
                });
                Optional.ofNullable(stock.get(6)).ifPresent(s -> {
                    stockDailyBasic.setPe(new BigDecimal(stock.get(6).toString()));
                });
                Optional.ofNullable(stock.get(7)).ifPresent(s -> {
                    stockDailyBasic.setPe_ttm(new BigDecimal(stock.get(7).toString()));
                });
                Optional.ofNullable(stock.get(8)).ifPresent(s -> {
                    stockDailyBasic.setPb(new BigDecimal(stock.get(8).toString()));
                });
                Optional.ofNullable(stock.get(9)).ifPresent(s -> {
                    stockDailyBasic.setPs(new BigDecimal(stock.get(9).toString()));
                });


                Optional.ofNullable(stock.get(10)).ifPresent(s -> {
                    stockDailyBasic.setPs_ttm(new BigDecimal(stock.get(10).toString()));
                });
                Optional.ofNullable(stock.get(11)).ifPresent(s -> {
                    stockDailyBasic.setDv_ratio(new BigDecimal(stock.get(11).toString()));
                });
                Optional.ofNullable(stock.get(12)).ifPresent(s -> {
                    stockDailyBasic.setDv_ttm(new BigDecimal(stock.get(12).toString()));
                });
                Optional.ofNullable(stock.get(13)).ifPresent(s -> {
                    stockDailyBasic.setTotal_share(new BigDecimal(stock.get(13).toString()).multiply(new BigDecimal(10000)));
                });
                Optional.ofNullable(stock.get(14)).ifPresent(s -> {
                    stockDailyBasic.setFloat_share(new BigDecimal(stock.get(14).toString()).multiply(new BigDecimal(10000)));
                });


                Optional.ofNullable(stock.get(15)).ifPresent(s -> {
                    stockDailyBasic.setFree_share(new BigDecimal(stock.get(15).toString()).multiply(new BigDecimal(10000)));
                });

                Optional.ofNullable(stock.get(16)).ifPresent(s -> {
                    stockDailyBasic.setTotal_mv(new BigDecimal(stock.get(16).toString()).multiply(new BigDecimal(10000)));
                });
                Optional.ofNullable(stock.get(17)).ifPresent(s -> {
                    stockDailyBasic.setCirc_mv(new BigDecimal(stock.get(17).toString()).multiply(new BigDecimal(10000)));
                });

                stockDailyBasic.setId(stockDailyBasic.getTrade_date() + "-" + stockDailyBasic.getTs_code());
                stockDailyBasics.add(stockDailyBasic);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        mongoTemplate.insertAll(stockDailyBasics);
    }
}
