package com.berserker.server.enums;

import vo.tools.IdentificationCardModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by klien on 2016/9/21.
 */
public enum  BankEnum {
    中国银行(1, "621661", "中国银行",12),
    农业银行(2, "622848", "农业银行",12),
    工商银行(3, "622202", "工商银行",12),
    建设银行(4, "622700", "建设银行",12),
    交通银行(5, "622262", "交通银行",12),
//    中国邮政储蓄(6, "", "中国邮政储蓄"),
    招商银行(7, "622588", "招商银行",12),
    浦发银行(8, "621717", "浦发银行",12),
    兴业银行(9, "622908", "兴业银行",12),
    光大银行(10, "622666", "光大银行",9),
    广发银行(11, "622556", "广发银行",12),
    华夏银行(12, "622630", "华夏银行",12),
    民生银行(13, "622622", "民生银行",12),
    中信银行(14, "622689", "中信银行",12),
    平安银行(15, "622588","平安银行",9);

    private int id;
    private String prefix;
    private String bankName;
    private int cardinalNumberLength;

    public static List<IdentificationCardModel> getIdAndBankNameMap(){
        BankEnum[] bankEnums = values();
        List<IdentificationCardModel> list = new ArrayList<IdentificationCardModel>();
        for(BankEnum bankEnum : bankEnums){
            list.add(new IdentificationCardModel(bankEnum.getId(),bankEnum.getBankName()));
        }
        return list;
    }

    public static String getBankPrefix(int id){
        BankEnum[] bankEnums = values();
        for(BankEnum bankEnum : bankEnums){
            if(bankEnum.getId() == id){
                return bankEnum.getPrefix();
            }
        }
        return null;
    }

    public static int getCardinalNumberLength(int id){
        BankEnum[] bankEnums = values();
        for(BankEnum bankEnum : bankEnums){
            if(bankEnum.getId() == id){
                return bankEnum.getCardinalNumberLength();
            }
        }
        return 0;
    }

    private BankEnum(int id, String prefix, String bankName, int cardinalNumberLength) {
        this.id = id;
        this.prefix = prefix;
        this.bankName = bankName;
        this.cardinalNumberLength = cardinalNumberLength;
    }

    public int getId() {
        return id;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getBankName() {
        return bankName;
    }

    public int getCardinalNumberLength() {
        return cardinalNumberLength;
    }
}
