package com.wirebarley.hans.controller.exchange;

import com.wirebarley.hans.common.Util;
import com.wirebarley.hans.service.exchange.ExchangeRateService;
import com.wirebarley.hans.vo.CommonJsonVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping( "/exchangeRate" )
public class ExchangeRateRestController {

    @Autowired
    private ExchangeRateService exchangeRateService;

    /**
     * 환율 게산기 화면
     *
     * @return 화면 파일 위치
     * @author 한정기
     * @since 2020-12-09
     */
    @RequestMapping( "" )
    public CommonJsonVO< String > getExchangeRate ( @RequestParam String target ) {

        CommonJsonVO< String > result = new CommonJsonVO<>();

        String exchangeRate = exchangeRateService.getExchangeRate( target );
        if ( exchangeRate != null ) {
            result.setData( exchangeRate );
        } else {
            result.setCode( 100 );
            result.setMsg( "환율 정보를 가져오지 못했습니다." );
        }

        return result;
    }

}
