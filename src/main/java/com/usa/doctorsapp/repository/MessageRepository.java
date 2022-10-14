package com.usa.doctorsapp.repository;

import com.usa.doctorsapp.model.MessageModel;
import com.usa.doctorsapp.repository.crudrepository.MessageCrudRepository;
import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MessageRepository {
    @Autowired
    private MessageCrudRepository messageCrudRepository;

    public List<MessageModel> getAll(){
        return (List<MessageModel>) messageCrudRepository.findAll();
    }
    public Optional<MessageModel> getById(Integer id){
        return messageCrudRepository.findById(id);
    }
    public MessageModel save(MessageModel message){
        return messageCrudRepository.save(message);
    }
    public void delete(MessageModel message){
        messageCrudRepository.delete(message);
    }
}
