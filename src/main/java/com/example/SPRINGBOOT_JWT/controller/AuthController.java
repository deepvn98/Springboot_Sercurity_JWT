package com.example.SPRINGBOOT_JWT.controller;

import com.example.SPRINGBOOT_JWT.dto.request.SignUpForm;
import com.example.SPRINGBOOT_JWT.dto.response.ResponMessage;
import com.example.SPRINGBOOT_JWT.model.RoleApp;
import com.example.SPRINGBOOT_JWT.model.RoleName;
import com.example.SPRINGBOOT_JWT.model.UserApp;
import com.example.SPRINGBOOT_JWT.security.jwt.JwtProvider;
import com.example.SPRINGBOOT_JWT.service.impl.RoleAppService;
import com.example.SPRINGBOOT_JWT.service.impl.UserAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

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

@PostMapping("signup")
    public ResponseEntity<?> register(@Valid @RequestBody SignUpForm signUpForm){
    if( userService.existsByUsername(signUpForm.getName())){
        return new ResponseEntity<>(new ResponMessage("daplicate"), HttpStatus.OK);
    }
    if(userService.existsByEmail(signUpForm.getEmail())){
        return new ResponseEntity<>(new ResponMessage("noemail"), HttpStatus.OK);
    }
    UserApp user = new UserApp(signUpForm.getName(), signUpForm.getUsername(), signUpForm.getEmail(),passwordEncoder.encode(signUpForm.getPassword()));
    Set<String> strRoles = signUpForm.getRoles();
    Set<RoleApp> roles = new HashSet<>();
    strRoles.forEach(role ->{
        switch (role){
            case "admin":
                RoleApp adminRole = roleService.findByName(RoleName.ADMIN).orElseThrow(
                        ()-> new RuntimeException("Role not found")
                );
                roles.add(adminRole);
                break;
            case "pm":
                RoleApp pmRole = roleService.findByName(RoleName.PM).orElseThrow( ()-> new RuntimeException("Role not found"));
                roles.add(pmRole);
                break;
            default:
                RoleApp userRole = roleService.findByName(RoleName.USER).orElseThrow( ()-> new RuntimeException("Role not found"));
                roles.add(userRole);
        }
    });
    user.setRoles(roles);
    userService.save(user);
    return new ResponseEntity<>(new ResponMessage("yes"), HttpStatus.OK);
}
}
