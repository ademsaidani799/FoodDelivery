package com.foodDelivery.foodDelivery.Repositories;

import com.foodDelivery.foodDelivery.Entities.OrderEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<OrderEntity,Long> {
    public List<OrderEntity> findByClient_Id(Long id);


}
