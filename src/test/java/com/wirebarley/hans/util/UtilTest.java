package com.wirebarley.hans.util;

import com.wirebarley.hans.common.Util;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class UtilTest {

    @Test
    public void commaTest() {
        System.out.println( Util.formatNumber( new BigDecimal( 100 ) ) );
        System.out.println( Util.formatNumber( new BigDecimal( 1001.123 ) ) );
        System.out.println( Util.formatNumber( new BigDecimal( 1000.123 ) ) );
        System.out.println( Util.formatNumber( new BigDecimal( 0 ) ) );
    }

}
