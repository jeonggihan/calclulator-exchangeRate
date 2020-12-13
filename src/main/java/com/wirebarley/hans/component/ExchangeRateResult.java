package com.wirebarley.hans.component;

import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Map;

@Data
public class ExchangeRateResult {

    boolean                   success;
    String                    terms;
    String                    privacy;
    Timestamp                 timestamp;

    // 기준 타겟
    String                    source;

    // 국가별 환율
    Map< String, BigDecimal > quotes;

}
