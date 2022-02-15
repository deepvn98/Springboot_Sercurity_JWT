package com.example.SPRINGBOOT_JWT.service.impl;

import com.example.SPRINGBOOT_JWT.model.UserApp;
import com.example.SPRINGBOOT_JWT.repository.IUserAppRepository;
import com.example.SPRINGBOOT_JWT.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserAppService implements IUserService {
    @Autowired
    IUserAppRepository userAppRepository;

    @Override
    public Optional<UserApp> findByUsername(String name) {
        return userAppRepository.findByUsername(name);
    }

    @Override
    public Boolean existsByUsername(String username) {
        return userAppRepository.existsByUsername(username);
    }

    @Override
    public Boolean existsByEmail(String email) {
        return userAppRepository.existsByEmail(email);
    }

    @Override
    public UserApp save(UserApp user) {
        return userAppRepository.save(user);
    }
}
