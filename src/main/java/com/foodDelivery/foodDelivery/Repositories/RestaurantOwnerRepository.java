package com.foodDelivery.foodDelivery.Repositories;

import com.foodDelivery.foodDelivery.Entities.OrderEntity;
import com.foodDelivery.foodDelivery.Entities.RestaurantOwner;
import org.springframework.data.repository.CrudRepository;

public interface RestaurantOwnerRepository extends CrudRepository<RestaurantOwner,Long> {
}
