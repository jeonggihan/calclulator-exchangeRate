package com.wirebarley.hans.common;

public interface CommonCode {

    enum CurrencyType implements CommonCode {

        // 서비스 통화 유형
        KRW( "한국" ),
        JPY( "일본" ),
        PHP( "필리핀" );

        String locale;

        public String getLocale () {
            return this.locale;
        }

        CurrencyType ( String locale ) {
            this.locale = locale;
        }

    }
}
