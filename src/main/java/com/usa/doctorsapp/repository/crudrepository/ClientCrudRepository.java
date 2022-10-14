package com.usa.doctorsapp.repository.crudrepository;

import com.usa.doctorsapp.model.ClientModel;
import org.springframework.data.repository.CrudRepository;

public interface ClientCrudRepository extends CrudRepository<ClientModel, Integer> {
}
