package com.foodDelivery.foodDelivery.dto;

import com.foodDelivery.foodDelivery.Entities.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class RestaurantDto {
    private Long id;
    private String name;
    private Long ownerId;
    // Other fields as needed
    // Omit restaurantOwner and menuItems
    // Getters and setters

    private List<MenuItem> menuItems;
    public RestaurantDto(){
        this.menuItems =new ArrayList<>();
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(String name, Double price) {

        MenuItem menuItem1 = new MenuItem();
        menuItem1.setPrice(price);
        menuItem1.setName(name);
        this.menuItems.add(menuItem1);
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
