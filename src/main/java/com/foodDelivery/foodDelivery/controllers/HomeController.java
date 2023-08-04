package com.foodDelivery.foodDelivery.controllers;


import com.foodDelivery.foodDelivery.Entities.Client;
import com.foodDelivery.foodDelivery.Entities.OrderEntity;
import com.foodDelivery.foodDelivery.Services.ClientService;
import com.foodDelivery.foodDelivery.Services.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HomeController {


    private final ClientService clientService;
    private final OrderService orderService;


    public HomeController(OrderService orderService,ClientService clientService){

        this.clientService= clientService;
        this.orderService= orderService;
    }

    @RequestMapping(value="/save-client", method = RequestMethod.POST)
    public ResponseEntity<?> addClient(@RequestBody Client client) {
        return new ResponseEntity<>(clientService.createClient(client), HttpStatus.CREATED);
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

    @PostMapping("clients/{id}")
    public void makeOrder(@PathVariable("id") Long id,@RequestBody OrderEntity orderEntity){

        this.orderService.addOrder(id,orderEntity);
    }
 }