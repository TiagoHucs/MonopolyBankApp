package com.monopolybankapp.services;

import com.monopolybankapp.Entities.History;
import com.monopolybankapp.Entities.User;
import com.monopolybankapp.repositories.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class HistoryService {

    @Autowired
    private HistoryRepository historyRepository;

    public List<History> getHistory(Long userId){
        return historyRepository.findByOriginIdOrDestinyId(userId);
    }

    public void createHistory(User origin, User destiny, BigDecimal value) {
        History history = new History();
        history.setAmount(value);
        history.setOrigin(origin);
        history.setDestiny(destiny);
        historyRepository.save(history);
    }

    public void createHistory(String originName, User userDestiny, BigDecimal value) {
        History history = new History();
        history.setAmount(value);
        history.setOriginName(originName);
        history.setDestiny(userDestiny);
        historyRepository.save(history);
    }
}
