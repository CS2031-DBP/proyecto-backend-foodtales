package com.proyecto_dbp.food.domain;

import com.proyecto_dbp.exception.ResourceNotFoundException;
import com.proyecto_dbp.exception.ValidationException;
import com.proyecto_dbp.food.dto.FoodRequestDto;
import com.proyecto_dbp.food.dto.FoodResponseDto;
import com.proyecto_dbp.food.infrastructure.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FoodService {

    @Autowired
    private FoodRepository foodRepository;

    public FoodResponseDto getFoodById(Long id) {
        Food food = foodRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Food not found with id " + id));
        return mapToDto(food);
    }

    public List<FoodResponseDto> getAllFoods() {
        List<Food> foods = foodRepository.findAll();
        return foods.stream().map(this::mapToDto).collect(Collectors.toList());
    }

    public FoodResponseDto createFood(FoodRequestDto foodRequestDto) {
        if (foodRequestDto.getName() == null || foodRequestDto.getName().isEmpty()) {
            throw new ValidationException("Name cannot be null or empty");
        }
        Food food = mapToEntity(foodRequestDto);
        food = foodRepository.save(food);
        return mapToDto(food);
    }

    public FoodResponseDto updateFood(Long id, FoodRequestDto foodRequestDto) {
        Food food = foodRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Food not found with id " + id));
        if (foodRequestDto.getName() == null || foodRequestDto.getName().isEmpty()) {
            throw new ValidationException("Name cannot be null or empty");
        }
        food.setName(foodRequestDto.getName());
        food.setPrice(foodRequestDto.getPrice());
        food.setStatus(foodRequestDto.getStatus());
        food = foodRepository.save(food);
        return mapToDto(food);
    }

    public void deleteFood(Long id) {
        if (!foodRepository.existsById(id)) {
            throw new ResourceNotFoundException("Food not found with id " + id);
        }
        foodRepository.deleteById(id);
    }

    private FoodResponseDto mapToDto(Food food) {
        FoodResponseDto foodResponseDto = new FoodResponseDto();
        foodResponseDto.setFoodId(food.getFoodId());
        foodResponseDto.setName(food.getName());
        foodResponseDto.setPrice(food.getPrice());
        foodResponseDto.setStatus(food.getStatus());
        foodResponseDto.setAverageRating(food.getAverageRating());
        foodResponseDto.setCreatedDate(food.getCreatedDate());
        return foodResponseDto;
    }

    private Food mapToEntity(FoodRequestDto foodRequestDto) {
        Food food = new Food();
        food.setName(foodRequestDto.getName());
        food.setPrice(foodRequestDto.getPrice());
        food.setStatus(foodRequestDto.getStatus());
        return food;
    }
}