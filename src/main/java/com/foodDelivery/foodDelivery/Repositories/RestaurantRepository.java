package com.foodDelivery.foodDelivery.Repositories;

import com.foodDelivery.foodDelivery.Entities.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant,Long> {
}
