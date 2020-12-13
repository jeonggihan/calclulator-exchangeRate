package com.wirebarley.hans.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    /**
     * 메인 화면 지정
     *
     * @return
     */
    @RequestMapping( "/" )
    public String home () {
        return "redirect:/exchangeRate/calculator";
    }

}
