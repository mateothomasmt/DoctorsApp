package com.usa.doctorsapp.repository.crudrepository;

import com.usa.doctorsapp.model.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageCrudRepository extends CrudRepository<Message, Integer> {
}
