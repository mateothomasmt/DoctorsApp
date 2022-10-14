package com.usa.doctorsapp.repository.crudrepository;

import com.usa.doctorsapp.model.Doctor;
import org.springframework.data.repository.CrudRepository;

public interface DoctorCrudRepository extends CrudRepository<Doctor, Integer> {
}
