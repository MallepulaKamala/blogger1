package com.blog.repository;

import com.blog.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRespository extends JpaRepository<Roles,Long> {
    Optional<Roles> findByRoles(String roles);
}


