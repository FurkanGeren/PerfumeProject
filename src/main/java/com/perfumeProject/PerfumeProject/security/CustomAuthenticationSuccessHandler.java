package com.perfumeProject.PerfumeProject.security;

import com.perfumeProject.PerfumeProject.Model.User;
import com.perfumeProject.PerfumeProject.Service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private UserService userService;

    public CustomAuthenticationSuccessHandler(UserService theUserService) {
        userService = theUserService;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {

        System.out.println("In customAuthenticationSuccessHandler");

        String name = authentication.getName();

        System.out.println("Name=" + name);

        User theUser = userService.findByEmail(name);

        // now place in the session
        HttpSession session = request.getSession();
        session.setAttribute("user", theUser);

        // forward to home page
        response.sendRedirect(request.getContextPath() + "/");
    }
}
