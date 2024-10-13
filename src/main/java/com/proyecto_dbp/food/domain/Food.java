package com.proyecto_dbp.food.domain;

import com.proyecto_dbp.foodrating.domain.FoodRating;
import com.proyecto_dbp.restaurant.domain.Restaurant;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long foodId;

    @NotNull
    @Size(max = 100)
    private String name;

    private Double price;

    private Double averageRating;

    private LocalDateTime createdDate;

    @Enumerated(EnumType.STRING)
    private FoodStatus status;

    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;

    @OneToMany(mappedBy = "food", cascade = CascadeType.ALL)
    private List<FoodRating> foodRatings;
}