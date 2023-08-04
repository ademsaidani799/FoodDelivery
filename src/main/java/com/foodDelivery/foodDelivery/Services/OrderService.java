package com.foodDelivery.foodDelivery.Services;


import com.foodDelivery.foodDelivery.Entities.Client;
import com.foodDelivery.foodDelivery.Entities.OrderEntity;
import com.foodDelivery.foodDelivery.Repositories.ClientRepository;
import com.foodDelivery.foodDelivery.Repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final ClientRepository clientRepository;


    public OrderService(OrderRepository orderRepository, ClientRepository clientRepository) {
        this.orderRepository =orderRepository ;
        this.clientRepository =clientRepository ;
    }



    public  List<OrderEntity> getAllOrders() {

    return (List<OrderEntity>) this.orderRepository.findAll();
    }

    public void addOrder(Long id, OrderEntity orderEntity){
        Client client = clientRepository.findById(id).orElse(null);

        if (client != null) {
            // Create a new Product entity and set its fields
            OrderEntity newOrder = new OrderEntity();
            newOrder.setDate(orderEntity.getDate());
            newOrder.setDelivered(orderEntity.isDelivered());

            // Set the associated Category for the new Product
            newOrder.setClient(client);

            // Save the new Product to the database
            orderRepository.save(newOrder);
        }
    }


}