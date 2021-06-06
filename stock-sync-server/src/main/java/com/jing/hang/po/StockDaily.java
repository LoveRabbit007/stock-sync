package com.jing.hang.po;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class StockDaily {
    /**
     * ts_code	str	股票代码
     * trade_date	str	交易日期
     * open	float	开盘价
     * high	float	最高价
     * low	float	最低价
     * close	float	收盘价
     * pre_close	float	昨收价
     * change	float	涨跌额
     * pct_chg	float	涨跌幅 （未复权，如果是复权请用 通用行情接口 ）
     * vol	float	成交量 （手）
     * amount	float	成交额 （千元）
     */
    private String id;
    private String tsCode;
    private String tradeDate;
    private BigDecimal open;
    private BigDecimal high;
    private BigDecimal low;
    private BigDecimal close;
    private BigDecimal preClose;
    private BigDecimal change;
    private BigDecimal pctChg;
    private BigDecimal vol;
    private BigDecimal amount;

}
