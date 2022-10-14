package com.usa.doctorsapp.service;

import com.usa.doctorsapp.model.MessageModel;
import com.usa.doctorsapp.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    public List<MessageModel> getAll(){return messageRepository.getAll();}
    public Optional<MessageModel> getById(Integer id){return messageRepository.getById(id);}
    public MessageModel save(MessageModel messageModel){
        if (messageModel.getId()==null){
            return messageRepository.save(messageModel);
        }else {
            Optional<MessageModel> optionalMessageModel=messageRepository.getById(messageModel.getId());
            if (optionalMessageModel.isEmpty()){
                return messageRepository.save(messageModel);
            }else{
                return messageModel;
            }
        }
    }
    public MessageModel update(MessageModel messageModel){
        if (messageModel.getId()!=null){
            Optional<MessageModel> optionalMessageModel=messageRepository.getById(messageModel.getId());
            if(!optionalMessageModel.isEmpty()){
                if (messageModel.getMessageText()!=null){
                    optionalMessageModel.get().setMessageText(messageModel.getMessageText());
                    optionalMessageModel.get().setClient(messageModel.getClient());
                    optionalMessageModel.get().setDoctor(messageModel.getDoctor());
                }
                messageRepository.save(optionalMessageModel.get());
                return optionalMessageModel.get();
            }else{
                return messageModel;
            }
        }else{
            return messageModel;
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
