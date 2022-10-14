package com.usa.doctorsapp.repository.crudrepository;

import com.usa.doctorsapp.model.DoctorModel;
import org.springframework.data.repository.CrudRepository;

public interface DoctorCrudRepository extends CrudRepository<DoctorModel, Integer> {
}
