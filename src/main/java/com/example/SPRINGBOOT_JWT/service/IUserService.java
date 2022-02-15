package com.example.SPRINGBOOT_JWT.service;

import com.example.SPRINGBOOT_JWT.model.UserApp;

import java.util.Optional;

public interface IUserService {
    Optional<UserApp> findByUsername(String name); //Tim kiem User co ton tai trong DB khong?
    Boolean existsByUsername(String username); //username da co trong DB chua, khi tao du lieu
    Boolean existsByEmail(String email); //email da co trong DB chua
    UserApp save(UserApp user);
}
