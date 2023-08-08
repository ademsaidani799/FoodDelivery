package com.foodDelivery.foodDelivery.controllers;


import com.foodDelivery.foodDelivery.Entities.*;
import com.foodDelivery.foodDelivery.Services.ClientService;
import com.foodDelivery.foodDelivery.Services.OrderService;
import com.foodDelivery.foodDelivery.Services.RestaurantService;
import com.foodDelivery.foodDelivery.dto.RestaurantDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HomeController {


    private final ClientService clientService;
    private final OrderService orderService;
    private final RestaurantService restaurantService;


    public HomeController(OrderService orderService, ClientService clientService, RestaurantService restaurantService){

        this.clientService= clientService;
        this.orderService= orderService;
        this.restaurantService = restaurantService;
    }

    @RequestMapping(value="/save-client", method = RequestMethod.POST)
    public ResponseEntity<?> addClient(@RequestBody Client client) {
        return new ResponseEntity<>(clientService.createClient(client), HttpStatus.CREATED);
    }

    @RequestMapping(value="/save-owner", method = RequestMethod.POST)
    public ResponseEntity<?> addOwner(@RequestBody RestaurantOwner restaurantOwner) {
        return new ResponseEntity<>(restaurantService.createRestaurantOwner(restaurantOwner), HttpStatus.CREATED);
    }



    @GetMapping("/orders")
    public List<OrderEntity> findAllOrders(){
        return this.orderService.getAllOrders();
    }
    @GetMapping("/clients")
    public List<Client> findAllClients(){
        return this.clientService.getAllClients();
    }

    @DeleteMapping("clients/{id}")
    public void deleteClient(@PathVariable("id") Long id){
        this.clientService.deleteClient(id);
    }

    @PostMapping("clients/{id}/restaurant/{restaurantId}")
    public void makeOrder(@PathVariable("id") Long id,@PathVariable("restaurantId") Long restaurantId,@RequestBody OrderEntity orderEntity){

        this.orderService.addOrder(id,restaurantId,orderEntity);
    }
    @PostMapping("owners/{id}")
    public void addRestaurant(@PathVariable("id") Long id,@RequestBody Restaurant restaurant){

        this.restaurantService.addRestaurant(id,restaurant);
    }

    @GetMapping("restaurants")
    public List<RestaurantDto> getAllRestaurants() {
        List<Restaurant> restaurants = this.restaurantService.getAllRestaurants();
        List<RestaurantDto> restaurantDtos = new ArrayList<>();

        for (Restaurant restaurant : restaurants) {
            RestaurantDto restaurantDto = new RestaurantDto();
            restaurantDto.setId(restaurant.getId());
            restaurantDto.setName(restaurant.getName());
            restaurantDto.setOwnerId(restaurant.getRestaurantOwner().getId());

            for (MenuItem menuItem : restaurant.getMenuItems()) {if(menuItem != null){ restaurantDto.setMenuItems(menuItem.getName(),menuItem.getPrice());}}

            // Map other fields if needed
            restaurantDtos.add(restaurantDto);
        }

        return restaurantDtos;
    }





 }