package com.monopolybankapp.controllers;

import com.monopolybankapp.Entities.UserOption;
import com.monopolybankapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("rest/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("balance")
    public ResponseEntity<BigDecimal> getBalance(){
        return ResponseEntity.ok(BigDecimal.ZERO);
    }

    @GetMapping("list")
    public ResponseEntity<List<UserOption>> getUsers(){
        List<UserOption> userList = userService.listTransferOptions();
        return ResponseEntity.ok(userList);
    }

}
