package com.spring_recipe.demo.service;

import com.spring_recipe.demo.domain.dto.CreateSteplistRequest;
import com.spring_recipe.demo.domain.dto.SteplistDto;
import com.spring_recipe.demo.domain.entity.Steplist;
import com.spring_recipe.demo.domain.exceptions.RecipeNotFoundException;
import com.spring_recipe.demo.repository.SteplistRepository;
import com.spring_recipe.demo.service.interfaces.SteplistService;
import com.spring_recipe.demo.util.SteplistMappingUtil;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

import static com.spring_recipe.demo.util.SteplistMappingUtil.mapToSteplistDto;
import static com.spring_recipe.demo.util.SteplistMappingUtil.mapToSteplistFromRequest;

@Service
@RequiredArgsConstructor
public class SteplistServiceImpl implements SteplistService {

    private final SteplistRepository repository;

    @Override
    public SteplistDto getSteplistById(String id) throws RecipeNotFoundException {
        return repository.findById(UUID.fromString(id)).stream()
                .map(SteplistMappingUtil::mapToSteplistDto)
                .findFirst()
                .orElseThrow(() -> new RecipeNotFoundException(id));
    }

    @Override
    @Transactional
    public SteplistDto createSteplist(CreateSteplistRequest request) {
        return mapToSteplistDto(repository.save(mapToSteplistFromRequest(request)));
    }

    @Override
    @Transactional
    public SteplistDto updateSteplist(Steplist step) {
        return mapToSteplistDto(repository.save(step));
    }

    @Override   
    public void deleteSteplist(String id) {
        repository.deleteById(UUID.fromString(id));
    }
}