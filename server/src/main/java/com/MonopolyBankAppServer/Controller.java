package com.MonopolyBankAppServer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("rest")
public class Controller {

    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping("login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest){
        if("admin".equals(loginRequest.getUsername()) && "123456".equals(loginRequest.getPassword())){
            String username = loginRequest.getUsername();
            String token = jwtUtils.generateToken(username);
            return ResponseEntity.ok(token);
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
    }

    @GetMapping("balance")//TODO: mover pro controller especifico
    public ResponseEntity<BigDecimal> getBalance(){
        return ResponseEntity.ok(BigDecimal.TEN);
    }

}
