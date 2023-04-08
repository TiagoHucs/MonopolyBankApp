package com.MonopolyBankAppServer;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Service
public class BankService {

    private List<User> userList;

    public BankService(List<User> userList) {
        //MOCK
        User user = new User("admin","123456");
        user.getAccount().setBalance(BigDecimal.valueOf(32.90));
        this.userList = Arrays.asList(user);
    }

    //TODO: implementar com repo
    public User getUser(String username){
        for (User u: userList) {
            if(username.equals(u.getUsername())){
                return u;
            }
        }
        return null;
    }

    public User getLoggerUser(){
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    public BigDecimal getBalance(){
        return getLoggerUser().getAccount().getBalance();
    }


}
