package com.foodDelivery.foodDelivery.Services;

import com.foodDelivery.foodDelivery.Entities.*;
import com.foodDelivery.foodDelivery.Repositories.MenuItemRepository;
import com.foodDelivery.foodDelivery.Repositories.RestaurantOwnerRepository;
import com.foodDelivery.foodDelivery.Repositories.RestaurantRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final RestaurantOwnerRepository restaurantOwnerRepository;
    private final MenuItemRepository menuItemRepository;

    public RestaurantService(RestaurantRepository restaurantRepository, RestaurantOwnerRepository restaurantOwnerRepository, MenuItemRepository menuItemRepository) {
        this.restaurantRepository = restaurantRepository;
        this.restaurantOwnerRepository = restaurantOwnerRepository;
        this.menuItemRepository = menuItemRepository;
    }

    public RestaurantOwner createRestaurantOwner(RestaurantOwner restaurantOwner) {

        return restaurantOwnerRepository.save(restaurantOwner);
    }

    public void addRestaurant(Long id, Restaurant restaurant){
        RestaurantOwner restaurantOwner = restaurantOwnerRepository.findById(id).orElse(null);

        if (restaurantOwner != null) {
            // Create a new Product entity and set its fields
            Restaurant newRestaurant = new Restaurant();
            newRestaurant.setRestaurantOwner(restaurantOwner);
            newRestaurant.setName(restaurant.getName());
            newRestaurant.setMenuItems(restaurant.getMenuItems());
            restaurantRepository.save(newRestaurant);
            restaurant.getMenuItems().forEach((item)->{
                MenuItem menuItem = new MenuItem();
                menuItem.setRestaurant(newRestaurant);
                menuItem.setPrice(item.getPrice());
                menuItem.setName(menuItem.getName());

                menuItemRepository.save(menuItem);
            });
            // Save the new Product to the database

        }
    }

    public List<Restaurant> getAllRestaurants(){
        return (List<Restaurant>) this.restaurantRepository.findAll();
    }
}
