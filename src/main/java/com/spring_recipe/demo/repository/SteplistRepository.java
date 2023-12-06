package com.spring_recipe.demo.repository;

import com.spring_recipe.demo.domain.entity.Steplist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SteplistRepository extends JpaRepository<Steplist, UUID> {

    @Query(value = "SELECT p FROM Steplist p")
    List<Steplist> getAll();
    Optional<Steplist> findById(UUID id);

    boolean existsById(UUID id);
}