package com.berserker.server.vo.tools;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class IdentificationCardModel {
    private int id;             //银行ID
    private String bankName;    //银行名称
}
