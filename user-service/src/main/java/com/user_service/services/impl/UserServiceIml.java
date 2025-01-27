package com.user_service.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user_service.entities.User;
import com.user_service.repositories.UserRepository;
import com.user_service.services.UserService;

@Service // This annotation makes this class a Spring-managed bean
public class UserServiceIml implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUser(int userId) {
        return userRepository.findById((long) userId).orElseThrow(() -> new RuntimeException("User not found!"));
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUserById(int id) {
        userRepository.deleteById((long) id);
    }

}
