package com.monopolybankapp.controllers;

import com.monopolybankapp.security.JwtUtils;
import com.monopolybankapp.Entities.LoginRequest;
import com.monopolybankapp.Entities.User;
import com.monopolybankapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("rest")
public class SecurityController {
    private static final Logger LOGGER = Logger.getLogger(SecurityController.class.getName());

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtils jwtUtils;


    @PostMapping("login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest){
        User user = userService.getUser(loginRequest);
        if(user != null){
            String username = loginRequest.getUsername();
            String token = jwtUtils.generateToken(username);
            LOGGER.log(Level.INFO,loginRequest.getUsername() + " logou com sucesso!");
            return ResponseEntity.ok(token);
        } else {
            LOGGER.log(Level.INFO,loginRequest.getUsername() + " login com erro!");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

}
