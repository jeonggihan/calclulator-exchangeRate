package com.wirebarley.hans.vo.param;

import com.wirebarley.hans.common.CommonCode;
import lombok.Data;

import java.math.BigDecimal;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class CalculatorParam {

    @Min( value = 0, message = "송금액이 옳바르지 않습니다." )
    @Max( value = 10000, message = "송금액이 옳바르지 않습니다." )
    @NotNull( message = "송금액이 옳바르지 않습니다." )
    BigDecimal value;

    @NotNull( message = "수취국가를 선택해 주세요." )
    CommonCode.CurrencyType target;

}
