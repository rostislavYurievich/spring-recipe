package com.spring_recipe.demo.repository;

import com.spring_recipe.demo.domain.entity.Step;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface StepRepository extends JpaRepository<Step, UUID> {

    @Query(value = "SELECT p FROM Step p")
    List<Step> getAll();
    Optional<Step> findById(UUID id);

    boolean existsById(UUID id);
}