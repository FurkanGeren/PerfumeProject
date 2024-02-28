package com.perfumeProject.PerfumeProject.Controller;


import com.perfumeProject.PerfumeProject.Model.User;
import com.perfumeProject.PerfumeProject.Service.UserService;
import com.perfumeProject.PerfumeProject.user.WebUser;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@Controller
@RequestMapping("/register")
public class RegisterController {

    private Logger logger = Logger.getLogger(getClass().getName());

    private UserService userService;

    @Autowired
    public RegisterController(UserService userService){
        this.userService = userService;
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder){
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/showRegistrationForm")
    public String showMyLoginPage(Model theModel){
        theModel.addAttribute("webUser", new WebUser());
        return "register/registration-form";
    }

    @PostMapping("/processRegistrationForm")
    public String processRegistrationForm(
            @Valid @ModelAttribute("webUser") WebUser theWebUser,
            BindingResult theBindingResult,
            HttpSession session, Model theModel){


        theModel.addAttribute("user", theWebUser);

        String email = theWebUser.getEmail();
        logger.info("Processing registration form for: " + email);

        if(theBindingResult.hasErrors()){
            return "register/registration-form";
        }

        User existing = userService.findByEmail(email);
        if(existing != null){
            theModel.addAttribute("webUser", new WebUser());
            theModel.addAttribute("registrationError", "User name already exists.");

            logger.warning("User name already exists.");
            return "register/registration-from";
        }
        userService.save(theWebUser);
        logger.info("Successfully created user: " + email);

        session.setAttribute("user",theWebUser);

        return "register/registration-confirmation";
    }

}





















