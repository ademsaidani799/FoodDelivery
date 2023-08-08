package com.foodDelivery.foodDelivery.Services;


import com.foodDelivery.foodDelivery.Entities.Client;
import com.foodDelivery.foodDelivery.Entities.MenuItem;
import com.foodDelivery.foodDelivery.Entities.OrderEntity;
import com.foodDelivery.foodDelivery.Entities.Restaurant;
import com.foodDelivery.foodDelivery.Repositories.ClientRepository;
import com.foodDelivery.foodDelivery.Repositories.MenuItemRepository;
import com.foodDelivery.foodDelivery.Repositories.OrderRepository;
import com.foodDelivery.foodDelivery.Repositories.RestaurantRepository;
import jakarta.persistence.criteria.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final ClientRepository clientRepository;
    private final MenuItemRepository menuItemRepository;
    private final RestaurantRepository restaurantRepository;


    public OrderService(OrderRepository orderRepository, ClientRepository clientRepository, MenuItemRepository menuItemRepository, RestaurantRepository restaurantRepository) {
        this.orderRepository =orderRepository ;
        this.clientRepository =clientRepository ;
        this.menuItemRepository = menuItemRepository;
        this.restaurantRepository = restaurantRepository;
    }



    public  List<OrderEntity> getAllOrders() {

    return (List<OrderEntity>) this.orderRepository.findAll();
    }

    public void addOrder(Long id, Long restaurantId,OrderEntity orderEntity){
        Client client = clientRepository.findById(id).orElse(null);
        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElse(null);
        if (client != null) {
            // Create a new Product entity and set its fields
            OrderEntity newOrder = new OrderEntity();
            newOrder.setDate(orderEntity.getDate());
            newOrder.setDelivered(orderEntity.isDelivered());
            newOrder.setClient(client);
            orderRepository.save(newOrder);

            orderEntity.getMenuItems().forEach((menuItem -> {
                MenuItem item = new MenuItem();
                item.setName(menuItem.getName());
                item.setPrice(menuItem.getPrice());
                item.setRestaurant(restaurant);
                item.setOrderEntity(newOrder);
                menuItemRepository.save(item);
            }));
            // Set the associated Category for the new Product


            // Save the new Product to the database
        }
    }

    public List<OrderEntity> getAllOrderPerClient(Long id){
        return this.orderRepository.findByClient_Id(id);
    }


}