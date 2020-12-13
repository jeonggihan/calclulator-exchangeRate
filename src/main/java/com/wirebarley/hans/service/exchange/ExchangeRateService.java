package com.wirebarley.hans.service.exchange;

import com.wirebarley.hans.common.Util;
import com.wirebarley.hans.component.ExchangeRateComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExchangeRateService {

    @Autowired
    private ExchangeRateComponent exchangeRateComponent;

    /**
     * 환율 정보 가져오기
     * @param target 대상 타겟
     * @return
     */
    public String getExchangeRate( String target ) {
        return Util.formatNumber( exchangeRateComponent.getExchangeRate( target ) );
    }

}
