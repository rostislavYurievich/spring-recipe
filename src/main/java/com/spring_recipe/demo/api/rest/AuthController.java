package com.spring_recipe.demo.api.rest;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/auth")
public class AuthController {

    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

    @GetMapping("/success")
    public String getSuccessPage() {
        return "success";
    }

    @PostMapping("/login")
    public String verifyCaptcha(HttpServletRequest request, @RequestParam("captcha") String captcha) {
        String captchaSession = (String) request.getSession().getAttribute("captcha");
        if (captcha.equals(captchaSession)) {
            return "success";
        } else {
            return "login";
        }
    }

}