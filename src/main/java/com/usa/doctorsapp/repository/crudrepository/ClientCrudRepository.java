package com.usa.doctorsapp.repository.crudrepository;

import com.usa.doctorsapp.model.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientCrudRepository extends CrudRepository<Client, Integer> {
}
