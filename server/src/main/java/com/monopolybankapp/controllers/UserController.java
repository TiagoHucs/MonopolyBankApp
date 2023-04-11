package com.monopolybankapp.controllers;

import com.monopolybankapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("rest/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("balance")
    public ResponseEntity<BigDecimal> getBalance(){
        return ResponseEntity.ok(BigDecimal.ZERO);
    }

    @PostMapping("create")
    public ResponseEntity<Void> create(@RequestBody UserCreateVO userVo){
        userService.create(userVo);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


}