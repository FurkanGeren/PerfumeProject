package com.perfumeProject.PerfumeProject.Controller;


import com.perfumeProject.PerfumeProject.Model.User;
import com.perfumeProject.PerfumeProject.Service.UserService;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class LoginController {

    private UserService userService;
    @GetMapping("/LoginPage")
    public String LoginPage(){
        return "fancy-login";
    }




}
