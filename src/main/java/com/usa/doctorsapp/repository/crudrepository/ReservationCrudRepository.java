package com.usa.doctorsapp.repository.crudrepository;

import com.usa.doctorsapp.model.ReservationModel;
import org.springframework.data.repository.CrudRepository;

public interface ReservationCrudRepository extends CrudRepository<ReservationModel, Integer> {
}
