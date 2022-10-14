package com.usa.doctorsapp.service;

import com.usa.doctorsapp.model.Message;
import com.usa.doctorsapp.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAll(){return messageRepository.getAll();}
    public Optional<Message> getById(Integer id){return messageRepository.getById(id);}
    public Message save(Message message){
        if (message.getIdMessage()==null){
            return messageRepository.save(message);
        }else {
            Optional<Message> optionalMessageModel=messageRepository.getById(message.getIdMessage());
            if (optionalMessageModel.isEmpty()){
                return messageRepository.save(message);
            }else{
                return message;
            }
        }
    }
    public Message update(Message message){
        if (message.getIdMessage()!=null){
            Optional<Message> optionalMessageModel=messageRepository.getById(message.getIdMessage());
            if(!optionalMessageModel.isEmpty()){
                if (message.getMessageText()!=null){
                    optionalMessageModel.get().setMessageText(message.getMessageText());
                    optionalMessageModel.get().setClient(message.getClient());
                    optionalMessageModel.get().setDoctor(message.getDoctor());
                }
                messageRepository.save(optionalMessageModel.get());
                return optionalMessageModel.get();
            }else{
                return message;
            }
        }else{
            return message;
        }
    }
    public boolean delete(Integer id){
        Boolean aBoolean=getById(id).map(messageModel -> {
            messageRepository.delete(messageModel);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
