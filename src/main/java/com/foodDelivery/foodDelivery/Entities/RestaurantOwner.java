package com.foodDelivery.foodDelivery.Entities;

import jakarta.persistence.*;

import java.util.List;
@Entity
public class RestaurantOwner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // OneToMany relationship with Restaurant
    @OneToMany(mappedBy = "restaurantOwner")
    private List<Restaurant> restaurants;

    // Constructors, getters, setters, etc.

    // Getters, setters, and other properties...

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(List<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }

    // Other getters and setters...

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
