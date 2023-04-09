package com.MonopolyBankAppServer.controllers;

import com.MonopolyBankAppServer.security.JwtUtils;
import com.MonopolyBankAppServer.Entities.LoginRequest;
import com.MonopolyBankAppServer.Entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("rest")
public class SecurityController {

    @Autowired
    private JwtUtils jwtUtils;


    @PostMapping("login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest){
        if("admin".equals(loginRequest.getUsername()) && "123456".equals(loginRequest.getPassword())){
            String username = loginRequest.getUsername();
            String token = jwtUtils.generateToken(username);
            autenticateInSpringSecurity(username);
            return ResponseEntity.ok(token);
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
    }

    private static void autenticateInSpringSecurity(String username) {
        User userDetails = new User(username,null);
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, null);
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
}
