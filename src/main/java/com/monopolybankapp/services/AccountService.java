package com.monopolybankapp.services;

import com.monopolybankapp.Entities.Account;
import com.monopolybankapp.Entities.History;
import com.monopolybankapp.Entities.HomeDetails;
import com.monopolybankapp.Entities.User;
import com.monopolybankapp.repositories.AccountRepository;
import com.monopolybankapp.repositories.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class AccountService {

    @Autowired
    private UserService userService;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private HistoryRepository historyRepository;


    @Transactional
    public void tranfer(Long accontId, BigDecimal value) {
        User user = userService.getLoggerUser();

        //get accounts
        Account origin =  user.getAccount();
        Account destiny = accountRepository.getReferenceById(accontId);

        //operations //TODO: criar logica de transferencia e historico
        origin.setBalance(origin.getBalance().subtract(value));
        destiny.setBalance(destiny.getBalance().add(value));

        History history = new History();
        history.setValue(value);
        history.setDateTime(LocalDateTime.now());
        history.setOriginId(origin.getId());
        history.setDestinyId(destiny.getId());

        historyRepository.save(history);
        accountRepository.save(origin);
        accountRepository.save(destiny);
    }

    public HomeDetails getHomeDetails() {
        User user = userService.getLoggerUser();
        return HomeDetails.builder().clientName(user.getUsername()).balance(user.getAccount().getBalance()).build();
    }

    public List<History> getHistory(){
        User user = userService.getLoggerUser();
        return historyRepository.findByOriginIdOrDestinyId(user.getId());
    }

}
