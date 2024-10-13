package com.proyecto_dbp.food.domain;

import com.proyecto_dbp.food.dto.FoodRequestDto;
import com.proyecto_dbp.food.dto.FoodResponseDto;
import com.proyecto_dbp.food.infrastructure.FoodRepository;
import com.proyecto_dbp.restaurant.domain.Restaurant;
import com.proyecto_dbp.restaurant.infrastructure.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FoodService {

    @Autowired
    private FoodRepository foodRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    public FoodResponseDto createFood(FoodRequestDto foodRequestDto) {
        Food food = new Food();
        food.setName(foodRequestDto.getName());
        food.setPrice(foodRequestDto.getPrice());
        food.setStatus(foodRequestDto.getStatus());

        // Fetch the restaurant entity and set it
        Restaurant restaurant = restaurantRepository.findById(foodRequestDto.getRestaurantId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid restaurant ID"));
        food.setRestaurant(restaurant);

        Food savedFood = foodRepository.save(food);
        return new FoodResponseDto(savedFood.getFoodId(), savedFood.getName(), savedFood.getPrice(), savedFood.getStatus(), savedFood.getRestaurant().getId());
    }

    public FoodResponseDto getFoodById(Long id) {
        Optional<Food> foodOptional = foodRepository.findById(id);
        if (foodOptional.isPresent()) {
            Food food = foodOptional.get();
            return new FoodResponseDto(food.getFoodId(), food.getName(), food.getPrice(), food.getStatus(), (Object) food.getRestaurant().getId());
        }
        return null;
    }

    public List<FoodResponseDto> getAllFoods() {
        return foodRepository.findAll().stream()
                .map(food -> new FoodResponseDto(food.getFoodId(), food.getName(), food.getPrice(), food.getStatus(), (Object) food.getRestaurant().getId()))
                .collect(Collectors.toList());
    }

    public FoodResponseDto updateFood(Long id, FoodRequestDto foodRequestDto) {
        Optional<Food> foodOptional = foodRepository.findById(id);
        if (foodOptional.isPresent()) {
            Food food = foodOptional.get();
            food.setName(foodRequestDto.getName());
            food.setPrice(foodRequestDto.getPrice());
            food.setStatus(foodRequestDto.getStatus());

            // Fetch the restaurant entity and set it
            Restaurant restaurant = restaurantRepository.findById(foodRequestDto.getRestaurantId())
                    .orElseThrow(() -> new IllegalArgumentException("Invalid restaurant ID"));
            food.setRestaurant(restaurant);

            Food updatedFood = foodRepository.save(food);
            return new FoodResponseDto(updatedFood.getFoodId(), updatedFood.getName(), updatedFood.getPrice(), updatedFood.getStatus(), (Object) updatedFood.getRestaurant().getId());
        }
        return null;
    }

    public void deleteFood(Long id) {
        foodRepository.deleteById(id);
    }
}