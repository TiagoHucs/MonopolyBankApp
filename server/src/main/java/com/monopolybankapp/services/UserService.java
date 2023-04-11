package com.monopolybankapp.services;

import com.monopolybankapp.Entities.LoginRequest;
import com.monopolybankapp.Entities.User;
import com.monopolybankapp.controllers.UserCreateVO;
import com.monopolybankapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public User getLoggerUser() {
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    public User getUser(UUID id){
        return userRepository.getReferenceById(id);
    }


    public void create(UserCreateVO userVo) {
        User user = new User(userVo.getUsername(),userVo.getPassword());
        userRepository.save(user);
    }

    //TODO: findByUsername in repo
    public User getUser(LoginRequest loginRequest) {
        User user = new User(loginRequest.getUsername(), loginRequest.getPassword());
        Example<User> example = Example.of(user);
        List<User> users = userRepository.findAll(example);
        return users.isEmpty() ? null : users.get(0);
    }
}
