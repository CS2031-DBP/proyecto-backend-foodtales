package com.proyecto_dbp.typefood.infrastructure;

import com.proyecto_dbp.restaurant.domain.Restaurant;
import com.proyecto_dbp.typefood.domain.TypeFood;
import com.proyecto_dbp.typefood.dto.TypeFoodResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TypeFoodRepository extends JpaRepository<TypeFood, Long> {
  List<TypeFood> findByRestaurantRestaurantId(Long restaurantId);
 // List<TypeFoodResponseDto> findByRestaurantRestaurantId(Long restaurantId); //3
}