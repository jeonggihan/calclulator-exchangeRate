package com.wirebarley.hans.service.calculator;

import com.wirebarley.hans.common.Util;
import com.wirebarley.hans.component.ExchangeRateComponent;
import com.wirebarley.hans.vo.param.CalculatorParam;
import com.wirebarley.hans.vo.CalculatorVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CalculatorService {

    @Autowired
    private ExchangeRateComponent exchangeRateComponent;

    /**
     * 계산
     *
     * @param calculatorParam 계산시 필요 파라미터
     * @return
     */
    public CalculatorVO calculator ( CalculatorParam calculatorParam ) {
        BigDecimal exchangeRate = exchangeRateComponent.getExchangeRate( calculatorParam.getTarget().name() );
        CalculatorVO calculatorVO = new CalculatorVO();

        if ( exchangeRate != null ) {
            calculatorVO.setCurrencyType( calculatorParam.getTarget() );
            calculatorVO.setExchangeRate( Util.formatNumber( exchangeRate ) );
            calculatorVO.setAmountReceived( Util.formatNumber( exchangeRate.multiply( calculatorParam.getValue() ) ) );
        }

        return calculatorVO;
    }

}
