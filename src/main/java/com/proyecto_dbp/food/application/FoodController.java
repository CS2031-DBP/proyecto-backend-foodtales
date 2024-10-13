package com.proyecto_dbp.food.application;

import com.proyecto_dbp.food.domain.FoodService;
import com.proyecto_dbp.food.dto.FoodRequestDto;
import com.proyecto_dbp.food.dto.FoodResponseDto;
import com.proyecto_dbp.restaurant.dto.RestaurantRequestDto;
import com.proyecto_dbp.restaurant.dto.RestaurantResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/foods")
public class FoodController {

    @Autowired
    private FoodService foodService;

    @PostMapping
    public ResponseEntity<FoodResponseDto> createFood(@RequestBody FoodRequestDto foodRequestDto) {
        FoodResponseDto createdFood = foodService.createFood(foodRequestDto);
        return ResponseEntity.ok(createdFood);
    }



    @GetMapping("/{id}")
    public ResponseEntity<FoodResponseDto> getFoodById(@PathVariable Long id) {
        FoodResponseDto food = foodService.getFoodById(id);
        if (food != null) {
            return ResponseEntity.ok(food);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<FoodResponseDto>> getAllFoods() {
        List<FoodResponseDto> foods = foodService.getAllFoods();
        return ResponseEntity.ok(foods);
    }



    @PutMapping("/{id}")
    public ResponseEntity<FoodResponseDto> updateFood(@PathVariable Long id, @RequestBody FoodRequestDto foodRequestDto) {
        FoodResponseDto updatedFood = foodService.updateFood(id, foodRequestDto);
        if (updatedFood != null) {
            return ResponseEntity.ok(updatedFood);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFood(@PathVariable Long id) {
        foodService.deleteFood(id);
        return ResponseEntity.noContent().build();
    }
}