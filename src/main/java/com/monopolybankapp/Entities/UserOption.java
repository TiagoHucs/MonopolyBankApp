package com.monopolybankapp.Entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserOption {

    private String username;
    private Long accountId;

    public UserOption(Long accountId, String username) {
        this.username = username;
        this.accountId = accountId;
    }
}
