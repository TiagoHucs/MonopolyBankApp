package com.monopolybankapp.services;

import com.monopolybankapp.Entities.LoginRequest;
import com.monopolybankapp.Entities.User;
import com.monopolybankapp.controllers.UserCreateVO;
import com.monopolybankapp.repositories.UserRepository;
import com.monopolybankapp.security.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public User getLoggerUser() {
        String username = UserContext.getUserInfo();
        return getUserByUsername(username);
    }

    public User getUser(Long id){
        return userRepository.getReferenceById(id);
    }


    public void create(UserCreateVO userVo) {
        User user = new User();
        user.setUsername(userVo.getUsername());
        user.setPassword(userVo.getPassword());
        userRepository.save(user);
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
}
