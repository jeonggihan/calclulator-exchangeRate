package com.wirebarley.hans.common;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class Util {

    /**
     * 콤마, 소수점
     *
     * @param number 수
     * @return 변환된 문자열
     */
    public static String formatNumber( BigDecimal number ) {
        return new DecimalFormat( "#,##0.00" ).format( number );
    }

}
