package com.example.SPRINGBOOT_JWT.service;

import com.example.SPRINGBOOT_JWT.model.RoleApp;
import com.example.SPRINGBOOT_JWT.model.RoleName;
import org.springframework.stereotype.Service;

import java.util.Optional;

public interface IRoleService {
    Optional<RoleApp> findByName(RoleName name);

}
