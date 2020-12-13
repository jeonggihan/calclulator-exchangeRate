package com.wirebarley.hans.controller.exchange;

import com.wirebarley.hans.common.CommonCode.CurrencyType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping( "/exchangeRate" )
public class ExchangeRateController {

    /**
     * 환율 게산기 화면
     *
     * @return 화면 파일 위치
     */
    @RequestMapping( "/calculator" )
    public ModelAndView calculator () {

        ModelAndView view = new ModelAndView( "exchangeRate/calculator" );
        view.addObject( "currencyType", CurrencyType.values() );

        return view;
    }

}
