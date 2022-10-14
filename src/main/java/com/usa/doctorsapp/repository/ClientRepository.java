package com.usa.doctorsapp.repository;

import com.usa.doctorsapp.model.ClientModel;
import com.usa.doctorsapp.repository.crudrepository.ClientCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepository {
    @Autowired
    private ClientCrudRepository clientCrudRepository;

    public List<ClientModel> getAll(){
        return (List<ClientModel>) clientCrudRepository.findAll();
    }
    public Optional<ClientModel> getById(Integer id){
        return clientCrudRepository.findById(id);
    }
    public ClientModel save(ClientModel client){
        return clientCrudRepository.save(client);
    }
    public void delete(ClientModel client){
        clientCrudRepository.delete(client);
    }
}
