package com.foodDelivery.foodDelivery.Repositories;

import com.foodDelivery.foodDelivery.Entities.Client;
import com.foodDelivery.foodDelivery.Entities.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuItemRepository extends JpaRepository<MenuItem,Long> {
}
