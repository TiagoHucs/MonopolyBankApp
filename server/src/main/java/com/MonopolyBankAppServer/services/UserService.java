package com.MonopolyBankAppServer.services;

import com.MonopolyBankAppServer.Entities.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public User getLoggerUser() {
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
