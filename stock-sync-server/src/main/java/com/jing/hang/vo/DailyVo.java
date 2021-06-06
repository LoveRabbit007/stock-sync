package com.jing.hang.vo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

@Data
public class DailyVo {
    /**
     * ts_code	str	N	股票代码（支持多个股票同时提取，逗号分隔）
     * trade_date	str	N	交易日期（YYYYMMDD）
     * start_date	str	N	开始日期(YYYYMMDD)
     * end_date	str	N	结束日期(YYYYMMDD)
     */
    @JSONField(name = "ts_code")
    private String tsCode;
    @JSONField(name = "trade_date")
    private String tradeDate;
    @JSONField(name = "start_date")
    private String startDate;
    @JSONField(name = "end_date")
    private String endDate;
}
