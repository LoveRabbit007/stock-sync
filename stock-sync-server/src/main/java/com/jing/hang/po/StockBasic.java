package com.jing.hang.po;


import lombok.*;
import lombok.experimental.Accessors;


@Getter
@Setter
@ToString
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class StockBasic {
    private String id;
    private String symbol;
    private String name;
    private String area;
    private String industry;
    private String fullName;
    private String enName;
    private String cnSpell;
    private String market;
    private String exchange;
    private String currType;
    private String listStatus;
    private String listName;
    private String  listDate;
    private String deListDate;
    private String isHs;
    private String hsName;

}
