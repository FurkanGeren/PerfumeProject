package com.perfumeProject.PerfumeProject.Controller;


import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class LoginController {

    @GetMapping("/LoginPage")
    public String LoginPage(){
        return "fancy-login";
    }

}
