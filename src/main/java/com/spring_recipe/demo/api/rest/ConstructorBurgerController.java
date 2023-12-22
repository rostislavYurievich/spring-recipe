package com.spring_recipe.demo.api.rest;

import com.spring_recipe.demo.domain.dto.CreateBurgerRequest;
import com.spring_recipe.demo.domain.dto.RecipeDto;
import com.spring_recipe.demo.domain.exceptions.RecipeAlreadyExistException;
import com.spring_recipe.demo.service.interfaces.RecipeService;
import com.spring_recipe.demo.service.interfaces.StepService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.spring_recipe.demo.domain.entity.Recipe;
import com.spring_recipe.demo.domain.entity.Step;

import java.util.Arrays;

@RestController
@RequiredArgsConstructor
public class ConstructorBurgerController {
    private final StepService stepService;
    private final RecipeService recipeService;


    @PostMapping("/constructor/burger")
    @PreAuthorize("hasAuthority('modification')")
    public ResponseEntity<RecipeDto> controllerBurger (@RequestBody CreateBurgerRequest burger) throws RecipeAlreadyExistException {
        Recipe recipe=Recipe.builder()
                .name(burger.getName())
                .description(burger.getDescription())
                .image(burger.getImage())
                .userId(burger.getUserId())
                .build();
        Step step = Step.builder()
                .description("Положить сверху булочку")
                .recipeId(recipe.getId())
                .nextId(null)
                .build();
        stepService.createStep(step);

        step = Step.builder()
                .description("Налить на котлету "+burger.getSauce())
                .recipeId(recipe.getId())
                .nextId(step.getId())
                .build();
        stepService.createStep(step);
        step = Step.builder()
                .description("Положить сверху "+ Arrays.toString(burger.getIngredients()))
                .recipeId(recipe.getId())
                .nextId(step.getId())
                .build();
        stepService.createStep(step);
        step = Step.builder()
                .description("Положить сверху "+burger.getKotleta())
                .recipeId(recipe.getId())
                .nextId(step.getId())
                .build();
        stepService.createStep(step);
        step = Step.builder()
                .description("Разрезать булочку на 2 части ")
                .recipeId(recipe.getId())
                .nextId(step.getId())
                .build();
        stepService.createStep(step);
        step = Step.builder()
                .description("Взять булку ")
                .recipeId(recipe.getId())
                .nextId(step.getId())
                .build();
        stepService.createStep(step);

        recipe.setStepId(step.getId());

        return ResponseEntity.ok(recipeService.createRecipe(recipe));

    }

}