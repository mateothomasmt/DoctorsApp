package com.usa.doctorsapp.repository.crudrepository;

import com.usa.doctorsapp.model.MessageModel;
import org.springframework.data.repository.CrudRepository;

public interface MessageCrudRepository extends CrudRepository<MessageModel, Integer> {
}
