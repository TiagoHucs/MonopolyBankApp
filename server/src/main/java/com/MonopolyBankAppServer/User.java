package com.MonopolyBankAppServer;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;

@Getter
@Setter
public class User {

    private String username;
    private String password;
    private Account account;

    public <E> User(String username,String password) {
        this.username = username;
        this.password = password;
    }
}
