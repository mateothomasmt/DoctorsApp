package com.usa.doctorsapp.controller;

import com.usa.doctorsapp.model.Message;
import com.usa.doctorsapp.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Message")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class MessageController {
    @Autowired
    private MessageService messageService;
    @GetMapping("/all")
    public List<Message> getMessages(){
        return messageService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Message> getMessage(@PathVariable("id")Integer id){
        return messageService.getById(id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Message save(@RequestBody Message message){
        return messageService.save(message);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Message update(@RequestBody Message message){
        return messageService.update(message);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id")Integer id){
        return messageService.delete(id);
    }
}
