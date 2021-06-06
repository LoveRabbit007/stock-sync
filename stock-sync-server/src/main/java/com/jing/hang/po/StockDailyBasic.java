package com.jing.hang.po;

import lombok.Data;

import java.math.BigDecimal;

/**
 * ts_code	str	TS股票代码
 * trade_date	str	交易日期
 * close	float	当日收盘价
 * turnover_rate	float	换手率（%）
 * turnover_rate_f	float	换手率（自由流通股）
 * volume_ratio	float	量比
 * pe	float	市盈率（总市值/净利润， 亏损的PE为空）
 * pe_ttm	float	市盈率（TTM，亏损的PE为空）
 * pb	float	市净率（总市值/净资产）
 * ps	float	市销率
 * ps_ttm	float	市销率（TTM）
 * dv_ratio	float	股息率 （%）
 * dv_ttm	float	股息率（TTM）（%）
 * total_share	float	总股本 （万股）
 * float_share	float	流通股本 （万股）
 * free_share	float	自由流通股本 （万）
 * total_mv	float	总市值 （万元）
 * circ_mv	float	流通市值（万元）
 */
@Data
public class StockDailyBasic {
    private String id;
    private String trade_date;
    private BigDecimal close;
    private BigDecimal turnover_rate;
    private BigDecimal turnover_rate_f;

    private BigDecimal volume_ratio;
    private BigDecimal pe;
    private BigDecimal pe_ttm;
    private BigDecimal pb;
    private BigDecimal ps;

    private BigDecimal ps_ttm;
    private BigDecimal dv_ratio;
    private BigDecimal dv_ttm;
    private BigDecimal total_share;
    private BigDecimal float_share;

    private BigDecimal free_share;
    private BigDecimal total_mv;
    private BigDecimal circ_mv;
    private String ts_code;
}
