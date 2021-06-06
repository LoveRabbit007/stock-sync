package com.jing.hang.vo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

@Data
public class StockBasicVo {
    @JSONField(name = "is_hs")
    private String isHs;
    @JSONField(name = "list_status")
    private String listStatus;
    @JSONField(name = "exchange")
    private String exchange;
    @JSONField(name = "ts_code")
    private String tsCode;
    @JSONField(name = "market")
    private String market;
    @JSONField(name = "limit")
    private String limit;
    @JSONField(name = "offset")
    private String offset;
    @JSONField(name = "name")
    private String name;

}
