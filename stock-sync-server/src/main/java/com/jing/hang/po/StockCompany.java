package com.jing.hang.po;

import lombok.Data;

@Data
public class StockCompany {
    /**
     * ts_code	str	Y	股票代码
     * exchange	str	Y	交易所代码 ，SSE上交所 SZSE深交所
     * chairman	str	Y	法人代表
     * manager	str	Y	总经理
     * secretary	str	Y	董秘
     * reg_capital	float	Y	注册资本
     * setup_date	str	Y	注册日期
     * province	str	Y	所在省份
     * city	str	Y	所在城市
     * introduction	str	N	公司介绍
     * website	str	Y	公司主页
     * email	str	Y	电子邮件
     * office	str	N	办公室
     * employees	int	Y	员工人数
     * main_business	str	N	主要业务及产品
     * business_scope	str	N	经营范围
     */
    private String tsCode;
    private String exchange;
    private String chairman;
    private String manager;
    private String secretary;
    private float regCapital;
    private String setupDate;
    private String province;
    private String city;
    private String introduction;
    private String website;
    private String email;
    private String office;
    private int employees;
    private String mainBusiness;
    private String businessScope;

}
