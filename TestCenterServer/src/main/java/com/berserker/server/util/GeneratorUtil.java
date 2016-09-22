package com.berserker.server.util;

import com.berserker.server.enums.BankEnum;

import java.util.ArrayList;
import java.util.List;

public class GeneratorUtil {

    public static String idCardGenerator(String prefix, int length){
            String cardNumber = prefix;
            //生成不包含模10算法的卡号
            for(int i = 0; i < length; i++){
                cardNumber += (int)Math.floor(Math.random()*9 + 1);
            }
            //进行模10算法
            String[] cardNo = cardNumber.split("");
            int lumnSum = 0;

            for(int i=0; i < cardNo.length; i++){
                int num = Integer.parseInt(cardNo[i]);
                if(num%2 ==0){
                    lumnSum += num;
                }else {
                    num = num*2;
                    if(num > 9){
                        num = Integer.parseInt(String.valueOf((String.valueOf(num).charAt(0))))
                                + Integer.parseInt(String.valueOf((String.valueOf(num).charAt(1))));
                        if(num > 9){
                            num = num - 9;
                        }
                    }
                    lumnSum += num;
                }
            }

            int lunmCode = lumnSum%10 ==0 ? 0: (10-lumnSum%10);
            cardNumber += String.valueOf(lunmCode);

            return cardNumber;
    }
}
