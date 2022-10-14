package com.usa.doctorsapp.controller;

import com.usa.doctorsapp.model.Client;
import com.usa.doctorsapp.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Client")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ClientController {
    @Autowired
    private ClientService clientService;
    @GetMapping("/all")
    public List<Client> getClients(){
        return  clientService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Client> getClient(@PathVariable("id") Integer id){
        return clientService.getById(id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Client save(@RequestBody Client client){
        return clientService.save(client);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Client update(@RequestBody Client client){
        return clientService.update(client);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") Integer id){
        return clientService.delete(id);
    }
}
