package com.usa.doctorsapp.controller;

import com.usa.doctorsapp.model.MessageModel;
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
    public List<MessageModel> getMessages(){
        return messageService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<MessageModel> getMessage(@PathVariable("id")Integer id){
        return messageService.getById(id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public MessageModel save(@RequestBody MessageModel messageModel){
        return messageService.save(messageModel);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public MessageModel update(@RequestBody MessageModel messageModel){
        return messageService.update(messageModel);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id")Integer id){
        return messageService.delete(id);
    }
}
