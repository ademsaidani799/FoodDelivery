package com.foodDelivery.foodDelivery.Services;


import com.foodDelivery.foodDelivery.Entities.Client;
import com.foodDelivery.foodDelivery.Entities.OrderEntity;
import com.foodDelivery.foodDelivery.Repositories.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    private final ClientRepository clientRepository;


    public ClientService(ClientRepository clientRepository) {
        this.clientRepository =clientRepository ;
    }

    public Client createClient(Client client) {

        return clientRepository.save(client);
    }

    public List<Client> getAllClients(){
        return (List<Client>) this.clientRepository.findAll();
    }

    public void deleteClient(Long id){
        this.clientRepository.deleteById(id);
    }




}