package com.example.SPRINGBOOT_JWT.repository;

import com.example.SPRINGBOOT_JWT.model.RoleApp;
import com.example.SPRINGBOOT_JWT.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IRoleAppRepository extends JpaRepository<RoleApp,Long> {
    Optional<RoleApp> findAllByName(RoleName name);
}
