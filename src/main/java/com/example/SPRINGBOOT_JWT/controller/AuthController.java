package com.example.SPRINGBOOT_JWT.controller;

import com.example.SPRINGBOOT_JWT.dto.request.SignUpForm;
import com.example.SPRINGBOOT_JWT.security.jwt.JwtProvider;
import com.example.SPRINGBOOT_JWT.service.impl.RoleAppService;
import com.example.SPRINGBOOT_JWT.service.impl.UserAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/api/auth")
@RestController
@CrossOrigin(origins = "*")
public class AuthController {
    @Autowired
    UserAppService userService;
    @Autowired
    RoleAppService roleService;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtProvider jwtProvider;

//    @PostMapping("/signup")
//    public ResponseEntity<?>register(@Valid @RequestBody SignUpForm signUpForm){
//        if(userService.existsByUsername(signUpForm.getUsername())){
//            return null;
//        }
//    }
}
