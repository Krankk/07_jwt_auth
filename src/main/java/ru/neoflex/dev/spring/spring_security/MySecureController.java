package ru.neoflex.dev.spring.spring_security;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.security.Principal;

@RestController
public class MySecureController extends ResponseEntityExceptionHandler {

    @GetMapping("/secure")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String hello(@AuthenticationPrincipal Principal principal) throws IllegalArgumentException  {
        return "Current principal: " + principal.getName();
    }
}
