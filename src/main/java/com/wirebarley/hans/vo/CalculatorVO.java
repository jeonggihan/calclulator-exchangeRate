package com.wirebarley.hans.vo;

import com.wirebarley.hans.common.CommonCode;
import lombok.Data;

@Data
public class CalculatorVO {

    // 선택 환율
    CommonCode.CurrencyType currencyType;

    // 현재 환율
    String exchangeRate;

    // 계산된 환율
    String amountReceived;

}
