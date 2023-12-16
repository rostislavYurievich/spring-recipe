package com.spring_recipe.demo.repository;

import com.spring_recipe.demo.domain.entity.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Integer> {
    Optional<ApplicationUser> findByEmail(String email);
    boolean existsByEmail(String name);
    Optional<ApplicationUser> findById(int id);
}
