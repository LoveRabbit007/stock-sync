package com.jing.hang.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jing.hang.constant.MoFangConstant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class StockJsonUtil {

    public static final List<List> stockJson(JSONObject requestJSON,
                                             Map<String, String> params) {
        List<List> lists = new ArrayList<>();
        boolean tag = true;
        int flag = 1;
        try {
            while (tag) {
                JSONObject result = HttpUtils.doPostJson(MoFangConstant.URL, requestJSON.toString());
                String jsonObject = result.get("data").toString();
                JSONObject jsonObject1 = JSONObject.parseObject(jsonObject);
                List<List> stocks = JSON.parseArray(jsonObject1.get("items").toString(), List.class);

                tag = Boolean.parseBoolean(jsonObject1.get("has_more").toString());
                if (tag) {
                    params.put("end_date", stocks.get(99).get(2).toString());
                    requestJSON.put("params", params);
                }
                if (flag > 1) {
                    stocks.remove(0);
                }
                lists.addAll(stocks);
                flag++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lists;
    }

}
