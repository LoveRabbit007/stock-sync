package com.jing.hang.po;

import lombok.Data;

import java.math.BigDecimal;

/**
 * ts_code	str	Y	TS代码
 * ann_date	str	Y	公告日期
 * f_ann_date	str	Y	实际公告日期
 * end_date	str	Y	报告期
 * report_type	str	Y	报告类型 1合并报表 2单季合并 3调整单季合并表 4调整合并报表 5调整前合并报表 6母公司报表 7母公司单季表 8 母公司调整单季表 9母公司调整表 10母公司调整前报表 11调整前合并报表 12母公司调整前报表
 * comp_type	str	Y	公司类型(1一般工商业2银行3保险4证券)
 * basic_eps	float	Y	基本每股收益
 * diluted_eps	float	Y	稀释每股收益
 * total_revenue	float	Y	营业总收入
 * revenue	float	Y	营业收入
 * int_income	float	Y	利息收入
 * prem_earned	float	Y	已赚保费
 * comm_income	float	Y	手续费及佣金收入
 * n_commis_income	float	Y	手续费及佣金净收入
 * n_oth_income	float	Y	其他经营净收益
 * n_oth_b_income	float	Y	加:其他业务净收益
 * prem_income	float	Y	保险业务收入
 * out_prem	float	Y	减:分出保费
 * une_prem_reser	float	Y	提取未到期责任准备金
 * reins_income	float	Y	其中:分保费收入
 * n_sec_tb_income	float	Y	代理买卖证券业务净收入
 * n_sec_uw_income	float	Y	证券承销业务净收入
 * n_asset_mg_income	float	Y	受托客户资产管理业务净收入
 * oth_b_income	float	Y	其他业务收入
 * fv_value_chg_gain	float	Y	加:公允价值变动净收益
 * invest_income	float	Y	加:投资净收益
 * ass_invest_income	float	Y	其中:对联营企业和合营企业的投资收益
 * forex_gain	float	Y	加:汇兑净收益
 * total_cogs	float	Y	营业总成本
 * oper_cost	float	Y	减:营业成本
 * int_exp	float	Y	减:利息支出
 * comm_exp	float	Y	减:手续费及佣金支出
 * biz_tax_surchg	float	Y	减:营业税金及附加
 * sell_exp	float	Y	减:销售费用
 * admin_exp	float	Y	减:管理费用
 * fin_exp	float	Y	减:财务费用
 * assets_impair_loss	float	Y	减:资产减值损失
 * prem_refund	float	Y	退保金
 * compens_payout	float	Y	赔付总支出
 * reser_insur_liab	float	Y	提取保险责任准备金
 * div_payt	float	Y	保户红利支出
 * reins_exp	float	Y	分保费用
 * oper_exp	float	Y	营业支出
 * compens_payout_refu	float	Y	减:摊回赔付支出
 * insur_reser_refu	float	Y	减:摊回保险责任准备金
 * reins_cost_refund	float	Y	减:摊回分保费用
 * other_bus_cost	float	Y	其他业务成本
 * operate_profit	float	Y	营业利润
 * non_oper_income	float	Y	加:营业外收入
 * non_oper_exp	float	Y	减:营业外支出
 * nca_disploss	float	Y	其中:减:非流动资产处置净损失
 * total_profit	float	Y	利润总额
 * income_tax	float	Y	所得税费用
 * n_income	float	Y	净利润(含少数股东损益)
 * n_income_attr_p	float	Y	净利润(不含少数股东损益)
 * minority_gain	float	Y	少数股东损益
 * oth_compr_income	float	Y	其他综合收益
 * t_compr_income	float	Y	综合收益总额
 * compr_inc_attr_p	float	Y	归属于母公司(或股东)的综合收益总额
 * compr_inc_attr_m_s	float	Y	归属于少数股东的综合收益总额
 * ebit	float	Y	息税前利润
 * ebitda	float	Y	息税折旧摊销前利润
 * insurance_exp	float	Y	保险业务支出
 * undist_profit	float	Y	年初未分配利润
 * distable_profit	float	Y	可分配利润
 * update_flag	str	N	更新标识，0未修改1更正过
 * 主要报表类型说明
 * <p>
 * 代码	类型	说明
 * 1	合并报表	上市公司最新报表（默认）
 * 2	单季合并	单一季度的合并报表
 * 3	调整单季合并表	调整后的单季合并报表（如果有）
 * 4	调整合并报表	本年度公布上年同期的财务报表数据，报告期为上年度
 * 5	调整前合并报表	数据发生变更，将原数据进行保留，即调整前的原数据
 * 6	母公司报表	该公司母公司的财务报表数据
 * 7	母公司单季表	母公司的单季度表
 * 8	母公司调整单季表	母公司调整后的单季表
 * 9	母公司调整表	该公司母公司的本年度公布上年同期的财务报表数据
 * 10	母公司调整前报表	母公司调整之前的原始财务报表数据
 * 11	调整前合并报表	调整之前合并报表原数据
 * 12	母公司调整前报表	母公司报表发生变更前保留的原数据
 */
@Data
public class StockInCome {

    private String ts_code;
    private String ann_date;
    private String f_ann_date;
    private String end_date;
    private String report_type;
    private String comp_type;
    private BigDecimal basic_eps;
    private BigDecimal diluted_eps;
    private BigDecimal total_revenue;
    private BigDecimal revenue;
    private BigDecimal int_income;
    private BigDecimal prem_earned;
    private BigDecimal comm_income;
    private BigDecimal n_commis_income;
    private BigDecimal n_oth_income;
    private BigDecimal n_oth_b_income;
    private BigDecimal prem_income;
    private BigDecimal out_prem;
    private BigDecimal une_prem_reser;
    private BigDecimal reins_income;
    private BigDecimal n_sec_tb_income;
    private BigDecimal n_sec_uw_income;
    private BigDecimal n_asset_mg_income;
    private BigDecimal oth_b_income;
    private BigDecimal fv_value_chg_gain;
    private BigDecimal invest_income;
    private BigDecimal ass_invest_income;
    private BigDecimal forex_gain;
    private BigDecimal total_cogs;
    private BigDecimal oper_cost;
    private BigDecimal int_exp;
    private BigDecimal comm_exp;
    private BigDecimal biz_tax_surchg;
    private BigDecimal sell_exp;
    private BigDecimal admin_exp;
    private BigDecimal fin_exp;
    private BigDecimal assets_impair_loss;
    private BigDecimal prem_refund;
    private BigDecimal compens_payout;
    private BigDecimal reser_insur_liab;
    private BigDecimal div_payt;
    private BigDecimal reins_exp;
    private BigDecimal oper_exp;
    private BigDecimal compens_payout_refu;
    private BigDecimal insur_reser_refu;
    private BigDecimal reins_cost_refund;
    private BigDecimal other_bus_cost;
    private BigDecimal operate_profit;
    private BigDecimal non_oper_income;
    private BigDecimal non_oper_exp;
    private BigDecimal nca_disploss;
    private BigDecimal total_profit;
    private BigDecimal income_tax;
    private BigDecimal n_income;
    private BigDecimal n_income_attr_p;
    private BigDecimal minority_gain;
    private BigDecimal oth_compr_income;
    private BigDecimal t_compr_income;
    private BigDecimal compr_inc_attr_p;
    private BigDecimal compr_inc_attr_m_s;
    private BigDecimal ebit;
    private BigDecimal ebitda;
    private BigDecimal insurance_exp;
    private BigDecimal undist_profit;
    private BigDecimal distable_profit;
    private String update_flag;
}
