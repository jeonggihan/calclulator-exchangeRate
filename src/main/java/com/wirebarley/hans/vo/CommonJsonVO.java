package com.wirebarley.hans.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonJsonVO< T > {

    // 코드 유형
    int code = 200;

    // 데이터
    T data;

    // 공통 메세지
    String msg;

}
