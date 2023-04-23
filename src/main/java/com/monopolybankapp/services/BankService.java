package com.monopolybankapp.services;

import com.monopolybankapp.Entities.HomeDetails;
import com.monopolybankapp.Entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;

@Service
public class BankService {

    @Autowired
    private UserService userService;

    @Autowired
    private HistoryService historyService;


    @Transactional
    public void transfer(Long accontId, BigDecimal value) {
        User origin = userService.getLoggerUser();
        User destiny = userService.getUser(accontId);

        origin.setBalance(origin.getBalance().subtract(value));
        destiny.setBalance(destiny.getBalance().add(value));
        userService.save(origin);
        userService.save(destiny);
        historyService.createHistory(origin,destiny,value);
    }

    @Transactional
    public void transfer(String origin, User userDestiny, BigDecimal value) {
        userDestiny.setBalance(userDestiny.getBalance().add(value));
        userService.save(userDestiny);
        historyService.createHistory(origin,userDestiny,value);
    }

    public HomeDetails getHomeDetails() {
        User user = userService.getLoggerUser();
        return HomeDetails.builder()
                .clientName(user.getUsername())
                .balance(user.getBalance())
                .history(historyService.getHistory(user.getId()))
                .build();
    }

}
