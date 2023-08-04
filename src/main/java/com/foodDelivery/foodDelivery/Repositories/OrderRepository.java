package com.foodDelivery.foodDelivery.Repositories;

import com.foodDelivery.foodDelivery.Entities.OrderEntity;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<OrderEntity,Long> {
}
