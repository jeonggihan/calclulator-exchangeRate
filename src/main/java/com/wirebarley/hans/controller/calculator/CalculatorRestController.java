package com.wirebarley.hans.controller.calculator;

import com.wirebarley.hans.vo.param.CalculatorParam;
import com.wirebarley.hans.service.calculator.CalculatorService;
import com.wirebarley.hans.vo.CalculatorVO;
import com.wirebarley.hans.vo.CommonJsonVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "/calculator" )
public class CalculatorRestController {

    @Autowired
    private CalculatorService calculatorService;

    /**
     * 환률 계산
     *
     * @param calculatorParam 계산에 필요한 객체
     * @param bindingResult 벨리데이션 결과
     * @return 변환 값
     */
    @RequestMapping( "" )
    public CommonJsonVO< CalculatorVO > calculator ( @Validated CalculatorParam calculatorParam, BindingResult bindingResult ) {
        CommonJsonVO< CalculatorVO > result = new CommonJsonVO<>();

        if ( bindingResult.hasErrors() ) {
            result.setCode( 100 );
            result.setMsg( bindingResult.getFieldError().getDefaultMessage() );
            return result;
        }

        CalculatorVO data = calculatorService.calculator( calculatorParam );
        if ( data != null ) {
            result.setData( data );
        } else {
            result.setMsg( "계산에 실패하였습니다." );
        }

        return result;
    }

}
