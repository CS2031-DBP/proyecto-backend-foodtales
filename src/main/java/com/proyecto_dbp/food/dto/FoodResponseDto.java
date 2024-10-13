package com.proyecto_dbp.food.dto;

import com.proyecto_dbp.food.domain.FoodStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodResponseDto {
    private Long foodId;
    private String name;
    private Double price;
    private FoodStatus status;
    private Object restaurantId;
}