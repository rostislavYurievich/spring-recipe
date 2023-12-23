package com.spring_recipe.demo.api.rest;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring_recipe.demo.domain.JwtRequest;
import com.spring_recipe.demo.domain.JwtResponse;
import com.spring_recipe.demo.domain.RefreshJwtRequest;
import com.spring_recipe.demo.service.AuthService;


@Controller
@RequestMapping("/auth")
@RequiredArgsConstructor
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

    private final AuthService authService;

    @PostMapping("/login-jwt")
    public ResponseEntity<JwtResponse> Email(@RequestBody JwtRequest authRequest) {
        final JwtResponse token = authService.Email(authRequest);
        return ResponseEntity.ok(token);
    }

    @PostMapping("token")
    public ResponseEntity<JwtResponse> getNewAccessToken(@RequestBody RefreshJwtRequest request) {
        final JwtResponse token = authService.getAccessToken(request.getRefreshToken());
        return ResponseEntity.ok(token);
    }

    @PostMapping("refresh")
    public ResponseEntity<JwtResponse> getNewRefreshToken(@RequestBody RefreshJwtRequest request) {
        final JwtResponse token = authService.refresh(request.getRefreshToken());
        return ResponseEntity.ok(token);
    }
}