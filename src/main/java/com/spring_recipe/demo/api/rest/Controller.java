package com.spring_recipe.demo.api.rest;
/*import lombok.RequiredArgsConstructor;
import com.spring_recipe.demo.domain.JwtAuthentication;
import com.spring_recipe.demo.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/apiJWT")
@RequiredArgsConstructor
public class Controller {
    private final AuthService authService;
    @PreAuthorize("hasAuthority('admin')")
    @GetMapping("hello/user")
    public ResponseEntity<String> helloAdmin(){
        final JwtAuthentication authInfo = authService.getAuthInfo();
        return ResponseEntity.ok("Hello admin" + authInfo.getPrincipal());}

    @PreAuthorize("hasAuthority('reader')")
    @GetMapping("hello/reader")
    public ResponseEntity<String> helloReader(){
        final JwtAuthentication authInfo = authService.getAuthInfo();
        return ResponseEntity.ok("Hello reader" + authInfo.getPrincipal());}

    @PreAuthorize("hasAuthority('writer')")
    @GetMapping("hello/writer")
    public ResponseEntity<String> helloWriter(){
        final JwtAuthentication authInfo = authService.getAuthInfo();
        return ResponseEntity.ok("Hello writer" + authInfo.getPrincipal());}


}*/
