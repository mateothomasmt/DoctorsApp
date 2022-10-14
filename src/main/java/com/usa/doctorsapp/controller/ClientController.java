package com.usa.doctorsapp.controller;

import com.usa.doctorsapp.model.ClientModel;
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
    public List<ClientModel> getClients(){
        return  clientService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<ClientModel> getClient(@PathVariable("id") Integer id){
        return clientService.getById(id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public ClientModel save(@RequestBody ClientModel clientModel){
        return clientService.save(clientModel);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public ClientModel update(@RequestBody ClientModel clientModel){
        return clientService.update(clientModel);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") Integer id){
        return clientService.delete(id);
    }
}
