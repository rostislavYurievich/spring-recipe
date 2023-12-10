package com.spring_recipe.demo.api.rest;

import com.spring_recipe.demo.domain.dto.CreateStepRequest;
import com.spring_recipe.demo.domain.entity.Step;
import com.spring_recipe.demo.domain.dto.StepDto;
import com.spring_recipe.demo.domain.exceptions.RecipeAlreadyExistException;
import com.spring_recipe.demo.domain.exceptions.RecipeNotFoundException;
import com.spring_recipe.demo.service.UserDetailsServiceImpl;
import com.spring_recipe.demo.service.interfaces.RecipeService;
import com.spring_recipe.demo.service.interfaces.StepService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import static java.lang.String.format;


@RestController
@RequiredArgsConstructor
public class StepController {
    private final StepService stepService;
    private final RecipeService RecipeService;
    private final UserDetailsServiceImpl UserDetailsService;

    @GetMapping("/Steps/{id}")
    @PreAuthorize("hasAuthority('read')")
    public ResponseEntity<StepDto> getStepById(@PathVariable String id) throws RecipeNotFoundException {
        return ResponseEntity.ok(stepService.getStepById(id));
    }

    @PostMapping("/Steps")
    @PreAuthorize("hasAuthority('modification')")
    public ResponseEntity<StepDto> createStep(@RequestBody CreateStepRequest Step) throws RecipeAlreadyExistException {
        return ResponseEntity.ok(stepService.createStep(Step));
    }

    @PatchMapping("/Steps")
    @PreAuthorize("hasAuthority('modification')")
    public ResponseEntity<StepDto> updateStep(Authentication auth, @RequestBody Step Step) throws RecipeNotFoundException {
        UserDetails udt1 = (UserDetails) auth.getPrincipal();
        String recipe_id = stepService.getStepById(Step.getId().toString()).getRecipeId().toString();
        int user_id = RecipeService.getRecipeById(recipe_id).getUserId();
        UserDetails udt2 = UserDetailsService.findById(user_id);
        if (udt1.equals(udt2)){
            return ResponseEntity.ok(stepService.updateStep(Step));
        }
        throw new AccessDeniedException("403 returned");
    }

    @DeleteMapping("/Steps/{id}")
    @PreAuthorize("hasAuthority('modification')")
    public ResponseEntity deleteStep(Authentication auth, @PathVariable String id) throws RecipeNotFoundException {
        UserDetails udt1 = (UserDetails) auth.getPrincipal();
        String recipe_id = stepService.getStepById(id).getRecipeId().toString();
        int user_id = RecipeService.getRecipeById(recipe_id).getUserId();
        UserDetails udt2 = UserDetailsService.findById(user_id);
        if (udt1.equals(udt2)){
            stepService.deleteStep(id);
            return ResponseEntity.ok()
                    .body(format("Step with id= %s deleted", id));
        }
        throw new AccessDeniedException("403 returned");
    }
}