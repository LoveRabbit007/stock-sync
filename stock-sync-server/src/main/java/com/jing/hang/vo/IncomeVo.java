package com.jing.hang.vo;

import lombok.Data;

/**
 * ts_code	str	Y	股票代码
 * ann_date	str	N	公告日期
 * start_date	str	N	公告开始日期
 * end_date	str	N	公告结束日期
 * period	str	N	报告期(每个季度最后一天的日期，比如20171231表示年报)
 * report_type	str	N	报告类型： 参考下表说明
 * comp_type	str	N	公司类型：1一般工商业 2银行 3保险 4证券
 */


@Data
public class IncomeVo {
    private String ts_code;
    private String ann_date;
    private String start_date;
    private String end_date;
    private String period;
    private String report_type;
    private String comp_type;

}
