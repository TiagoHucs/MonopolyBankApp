package com.monopolybankapp.controllers;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterUserVO {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
