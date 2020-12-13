package com.wirebarley.hans.component;

import com.wirebarley.hans.WebApiApplicationTest;
import com.wirebarley.hans.component.ExchangeRateComponent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

public class ComponentTest extends WebApiApplicationTest {

    @Autowired
    ExchangeRateComponent exchangeRateComponent;

    @Test
    public void getExchangeRate () {
        BigDecimal map = exchangeRateComponent.getExchangeRate( "KRW" );
    }

}
