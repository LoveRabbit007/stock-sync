package com.jing.hang.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.jing.hang.constant.MoFangConstant;
import com.jing.hang.po.StockCompany;
import com.jing.hang.po.StockDailyBasic;
import com.jing.hang.po.StockInCome;
import com.jing.hang.service.StockFinanceService;
import com.jing.hang.utils.HttpUtils;
import com.jing.hang.utils.StockJsonUtil;
import com.jing.hang.utils.StringUtil;
import com.jing.hang.vo.IncomeVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service
public class StockFinanceServiceImpl implements StockFinanceService {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void stockIncome(IncomeVo incomeVo) {
        JSONObject requestJSON = new JSONObject();
        requestJSON.put("api_name", "income");
        requestJSON.put("token", MoFangConstant.TOKEN);
        Map<String, String> params = new HashMap<>();
        params.put("ts_code", incomeVo.getTs_code());
        requestJSON.put("params", params);
        requestJSON.put("fields", StringUtil.handRequestParams(new StockInCome().toString()));
        List<List> stocks = StockJsonUtil.stockJson(requestJSON, params);
        List<StockInCome> stockInComes = new ArrayList<>();
        for (List<Object> stock : stocks) {
            StockInCome stockInCome = new StockInCome();
            Optional.ofNullable(stock.get(0)).ifPresent(s -> {
                stockInCome.setTs_code(s.toString());
            });

            Optional.ofNullable(stock.get(1)).ifPresent(s -> {
                stockInCome.setAnn_date(s.toString());
            });

            Optional.ofNullable(stock.get(2)).ifPresent(s -> {
                stockInCome.setF_ann_date(s.toString());
            });

            Optional.ofNullable(stock.get(3)).ifPresent(s -> {
                stockInCome.setEnd_date(s.toString());
            });

            Optional.ofNullable(stock.get(4)).ifPresent(s -> {
                stockInCome.setReport_type(s.toString());
            });

            Optional.ofNullable(stock.get(5)).ifPresent(s -> {
                stockInCome.setComp_type(s.toString());
            });

            Optional.ofNullable(stock.get(6)).ifPresent(s -> {
                stockInCome.setBasic_eps(new BigDecimal(s.toString()));
            });

            Optional.ofNullable(stock.get(7)).ifPresent(s -> {
                stockInCome.setDiluted_eps(new BigDecimal(s.toString()));
            });

            Optional.ofNullable(stock.get(8)).ifPresent(s -> {
                stockInCome.setTotal_revenue(new BigDecimal(s.toString()));
            });

            Optional.ofNullable(stock.get(9)).ifPresent(s -> {
                stockInCome.setRevenue(new BigDecimal(s.toString()));
            });

            Optional.ofNullable(stock.get(10)).ifPresent(s -> {
                stockInCome.setInt_income(new BigDecimal(s.toString()));
            });

            Optional.ofNullable(stock.get(11)).ifPresent(s -> {
                stockInCome.setPrem_earned(new BigDecimal(s.toString()));
            });

            Optional.ofNullable(stock.get(12)).ifPresent(s -> {
                stockInCome.setComm_income(new BigDecimal(s.toString()));
            });

            Optional.ofNullable(stock.get(13)).ifPresent(s -> {
                stockInCome.setN_commis_income(new BigDecimal(s.toString()));
            });

            Optional.ofNullable(stock.get(14)).ifPresent(s -> {
                stockInCome.setN_oth_income(new BigDecimal(s.toString()));
            });

            Optional.ofNullable(stock.get(15)).ifPresent(s -> {
                stockInCome.setN_oth_b_income(new BigDecimal(s.toString()));
            });
            Optional.ofNullable(stock.get(16)).ifPresent(s -> {
                stockInCome.setPrem_earned(new BigDecimal(s.toString()));
            });

            Optional.ofNullable(stock.get(17)).ifPresent(s -> {
                stockInCome.setOut_prem(new BigDecimal(s.toString()));
            });

            Optional.ofNullable(stock.get(18)).ifPresent(s -> {
                stockInCome.setUne_prem_reser(new BigDecimal(s.toString()));
            });

            Optional.ofNullable(stock.get(19)).ifPresent(s -> {
                stockInCome.setReins_income(new BigDecimal(s.toString()));
            });

            Optional.ofNullable(stock.get(20)).ifPresent(s -> {
                stockInCome.setN_sec_tb_income(new BigDecimal(s.toString()));
            });

            Optional.ofNullable(stock.get(21)).ifPresent(s -> {
                stockInCome.setN_sec_uw_income(new BigDecimal(s.toString()));
            });

            Optional.ofNullable(stock.get(22)).ifPresent(s -> {
                stockInCome.setN_asset_mg_income(new BigDecimal(s.toString()));
            });

            Optional.ofNullable(stock.get(23)).ifPresent(s -> {
                stockInCome.setOth_b_income(new BigDecimal(s.toString()));
            });

            Optional.ofNullable(stock.get(24)).ifPresent(s -> {
                stockInCome.setFv_value_chg_gain(new BigDecimal(s.toString()));
            });

            /**
             * 投资收入
             */
            Optional.ofNullable(stock.get(25)).ifPresent(s -> {
                stockInCome.setInvest_income(new BigDecimal(s.toString()));
            });
            Optional.ofNullable(stock.get(26)).ifPresent(s -> {
                stockInCome.setAss_invest_income(new BigDecimal(s.toString()));
            });

            Optional.ofNullable(stock.get(27)).ifPresent(s -> {
                stockInCome.setForex_gain(new BigDecimal(s.toString()));
            });

            Optional.ofNullable(stock.get(28)).ifPresent(s -> {
                stockInCome.setTotal_cogs(new BigDecimal(s.toString()));
            });

            Optional.ofNullable(stock.get(29)).ifPresent(s -> {
                stockInCome.setOper_cost(new BigDecimal(s.toString()));
            });


            Optional.ofNullable(stock.get(30)).ifPresent(s -> {
                stockInCome.setInt_exp(new BigDecimal(s.toString()));
            });

            Optional.ofNullable(stock.get(31)).ifPresent(s -> {
                stockInCome.setComm_exp(new BigDecimal(s.toString()));
            });

            Optional.ofNullable(stock.get(32)).ifPresent(s -> {
                stockInCome.setBiz_tax_surchg(new BigDecimal(s.toString()));
            });


            Optional.ofNullable(stock.get(33)).ifPresent(s -> {
                stockInCome.setSell_exp(new BigDecimal(s.toString()));
            });

            Optional.ofNullable(stock.get(34)).ifPresent(s -> {
                stockInCome.setAdmin_exp(new BigDecimal(s.toString()));
            });

            Optional.ofNullable(stock.get(35)).ifPresent(s -> {
                stockInCome.setFin_exp(new BigDecimal(s.toString()));
            });
            Optional.ofNullable(stock.get(36)).ifPresent(s -> {
                stockInCome.setAssets_impair_loss(new BigDecimal(s.toString()));
            });

            Optional.ofNullable(stock.get(37)).ifPresent(s -> {
                stockInCome.setPrem_refund(new BigDecimal(s.toString()));
            });

            Optional.ofNullable(stock.get(38)).ifPresent(s -> {
                stockInCome.setCompens_payout(new BigDecimal(s.toString()));
            });

            Optional.ofNullable(stock.get(39)).ifPresent(s -> {
                stockInCome.setReser_insur_liab(new BigDecimal(s.toString()));
            });

            Optional.ofNullable(stock.get(40)).ifPresent(s -> {
                stockInCome.setDiv_payt(new BigDecimal(s.toString()));
            });

            Optional.ofNullable(stock.get(41)).ifPresent(s -> {
                stockInCome.setReins_exp(new BigDecimal(s.toString()));
            });

            Optional.ofNullable(stock.get(42)).ifPresent(s -> {
                stockInCome.setOper_exp(new BigDecimal(s.toString()));
            });


            Optional.ofNullable(stock.get(43)).ifPresent(s -> {
                stockInCome.setCompens_payout_refu(new BigDecimal(s.toString()));
            });

            Optional.ofNullable(stock.get(44)).ifPresent(s -> {
                stockInCome.setInsur_reser_refu(new BigDecimal(s.toString()));
            });

            Optional.ofNullable(stock.get(45)).ifPresent(s -> {
                stockInCome.setReins_cost_refund(new BigDecimal(s.toString()));
            });

            Optional.ofNullable(stock.get(46)).ifPresent(s -> {
                stockInCome.setOther_bus_cost(new BigDecimal(s.toString()));
            });

            Optional.ofNullable(stock.get(47)).ifPresent(s -> {
                stockInCome.setOperate_profit(new BigDecimal(s.toString()));
            });

            Optional.ofNullable(stock.get(48)).ifPresent(s -> {
                stockInCome.setNon_oper_income(new BigDecimal(s.toString()));
            });
            Optional.ofNullable(stock.get(49)).ifPresent(s -> {
                stockInCome.setNon_oper_exp(new BigDecimal(s.toString()));
            });

            Optional.ofNullable(stock.get(50)).ifPresent(s -> {
                stockInCome.setNca_disploss(new BigDecimal(s.toString()));
            });

            Optional.ofNullable(stock.get(51)).ifPresent(s -> {
                stockInCome.setTotal_profit(new BigDecimal(s.toString()));
            });

            Optional.ofNullable(stock.get(52)).ifPresent(s -> {
                stockInCome.setIncome_tax(new BigDecimal(s.toString()));
            });

            Optional.ofNullable(stock.get(53)).ifPresent(s -> {
                stockInCome.setN_income(new BigDecimal(s.toString()));
            });

            Optional.ofNullable(stock.get(54)).ifPresent(s -> {
                stockInCome.setN_income_attr_p(new BigDecimal(s.toString()));
            });

            Optional.ofNullable(stock.get(55)).ifPresent(s -> {
                stockInCome.setMinority_gain(new BigDecimal(s.toString()));
            });

            Optional.ofNullable(stock.get(56)).ifPresent(s -> {
                stockInCome.setOth_compr_income(new BigDecimal(s.toString()));
            });

            Optional.ofNullable(stock.get(57)).ifPresent(s -> {
                stockInCome.setT_compr_income(new BigDecimal(s.toString()));
            });

            Optional.ofNullable(stock.get(58)).ifPresent(s -> {
                stockInCome.setCompr_inc_attr_p(new BigDecimal(s.toString()));
            });

            Optional.ofNullable(stock.get(59)).ifPresent(s -> {
                stockInCome.setCompr_inc_attr_m_s(new BigDecimal(s.toString()));
            });


            Optional.ofNullable(stock.get(60)).ifPresent(s -> {
                stockInCome.setEbit(new BigDecimal(s.toString()));
            });

            Optional.ofNullable(stock.get(61)).ifPresent(s -> {
                stockInCome.setEbitda(new BigDecimal(s.toString()));
            });


            Optional.ofNullable(stock.get(62)).ifPresent(s -> {
                stockInCome.setInsurance_exp(new BigDecimal(s.toString()));
            });

            Optional.ofNullable(stock.get(63)).ifPresent(s -> {
                stockInCome.setUndist_profit(new BigDecimal(s.toString()));
            });

            Optional.ofNullable(stock.get(64)).ifPresent(s -> {
                stockInCome.setDistable_profit(new BigDecimal(s.toString()));
            });
            Optional.ofNullable(stock.get(65)).ifPresent(s -> {
                stockInCome.setUpdate_flag(s.toString());
            });
        }
        mongoTemplate.insertAll(stockInComes);
    }

}
