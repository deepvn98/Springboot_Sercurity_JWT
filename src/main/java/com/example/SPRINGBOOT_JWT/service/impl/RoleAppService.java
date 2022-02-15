package com.example.SPRINGBOOT_JWT.service.impl;

import com.example.SPRINGBOOT_JWT.model.RoleApp;
import com.example.SPRINGBOOT_JWT.model.RoleName;
import com.example.SPRINGBOOT_JWT.repository.IRoleAppRepository;
import com.example.SPRINGBOOT_JWT.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class RoleAppService implements IRoleService {
    @Autowired
    IRoleAppRepository roleAppRepository;
    @Override
    public Optional<RoleApp> findByName(RoleName name) {
        return roleAppRepository.findAllByName(name);
    }
}
