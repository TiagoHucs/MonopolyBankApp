package com.monopolybankapp.services;

import com.monopolybankapp.Entities.LoginRequest;
import com.monopolybankapp.Entities.User;
import com.monopolybankapp.Entities.UserOption;
import com.monopolybankapp.controllers.UserCreateVO;
import com.monopolybankapp.repositories.UserRepository;
import com.monopolybankapp.security.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private HistoryService historyService;

    public User getLoggerUser() {
        String username = UserContext.getUserInfo();
        return getUserByUsername(username);
    }

    public User getUser(Long id){
        return userRepository.getReferenceById(id);
    }


    public void create(UserCreateVO userVo) {
        BigDecimal inicialBalance =  BigDecimal.valueOf(1500);
        User user = new User();
        user.setUsername(userVo.getUsername());
        user.setPassword(userVo.getPassword());
        user.setBalance(inicialBalance);
        userRepository.save(user);
        historyService.createHistory("Deposito",user,inicialBalance);
    }

    //TODO: findByUsername in repo
    public User getUser(LoginRequest loginRequest) {
        User user = new User();
        user.setUsername(loginRequest.getUsername());
        user.setPassword(loginRequest.getPassword());
        Example<User> example = Example.of(user);
        List<User> users = userRepository.findAll(example);
        return users.isEmpty() ? null : users.get(0);
    }

    public User getUserByUsername(String username) {
        User user = new User();
        user.setUsername(username);
        return userRepository.findOne(Example.of(user)).get();
    }

    public List<UserOption> listOptions() {
        List<User> list = userRepository.findAll();
        List<UserOption> userOptionList = new ArrayList<>();
        for (User user: list) {
            userOptionList.add(new UserOption(user.getId(), user.getUsername()));
        }
        return userOptionList;
    }

    public void save(User user) {
        userRepository.save(user);
    }
}
