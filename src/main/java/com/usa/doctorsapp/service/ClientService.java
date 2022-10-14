package com.usa.doctorsapp.service;

import com.usa.doctorsapp.model.Client;
import com.usa.doctorsapp.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll(){
        return clientRepository.getAll();
    }

    public Optional<Client> getById(Integer id){
        return clientRepository.getById(id);
    }

    public Client save(Client client){
        if(client.getIdClient()==null){
            return clientRepository.save(client);
        }else{
            Optional<Client> optionalClientModel=clientRepository.getById(client.getIdClient());
            if(optionalClientModel.isEmpty()){
                return clientRepository.save(client);
            }else{
                return client;
            }
        }
    }

    public Client update(Client client){
        if(client.getIdClient()!=null){
            Optional<Client> optionalClientModel=clientRepository.getById(client.getIdClient());
            if(!optionalClientModel.isEmpty()){
                if(client.getName()!=null){
                    optionalClientModel.get().setName(client.getName());
                }
                if (client.getEmail()!=null){
                    optionalClientModel.get().setEmail(client.getEmail());
                }
                if(client.getPassword()!=null){
                    optionalClientModel.get().setPassword(client.getPassword());
                }
                if(client.getAge()!=null){
                    optionalClientModel.get().setAge(client.getAge());
                }
                clientRepository.save(optionalClientModel.get());
                return optionalClientModel.get();
            }else{
                return client;
            }
        }else {
            return client;
        }
    }

    public boolean delete(Integer id){
        Boolean aBoolean=getById(id).map(clientModel -> {
            clientRepository.delete(clientModel);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
