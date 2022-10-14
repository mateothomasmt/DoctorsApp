package com.usa.doctorsapp.repository;

import com.usa.doctorsapp.model.Doctor;
import com.usa.doctorsapp.repository.crudrepository.DoctorCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class DoctorRepository {
    @Autowired
    DoctorCrudRepository doctorCrudRepository;
    public List<Doctor> getAll(){
        return (List<Doctor>) doctorCrudRepository.findAll();
    }
    public Optional<Doctor> getById(Integer id){
        return doctorCrudRepository.findById(id);
    }
    public Doctor save(Doctor doctor){
        return doctorCrudRepository.save(doctor);
    }
    public void delete(Doctor doctor){
        doctorCrudRepository.delete(doctor);
    }
}
