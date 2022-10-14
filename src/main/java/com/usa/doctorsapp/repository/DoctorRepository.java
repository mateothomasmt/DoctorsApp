package com.usa.doctorsapp.repository;

import com.usa.doctorsapp.model.DoctorModel;
import com.usa.doctorsapp.repository.crudrepository.DoctorCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class DoctorRepository {
    @Autowired
    DoctorCrudRepository doctorCrudRepository;
    public List<DoctorModel> getAll(){
        return (List<DoctorModel>) doctorCrudRepository.findAll();
    }
    public Optional<DoctorModel> getById(Integer id){
        return doctorCrudRepository.findById(id);
    }
    public DoctorModel save(DoctorModel doctor){
        return doctorCrudRepository.save(doctor);
    }
    public void delete(DoctorModel doctor){
        doctorCrudRepository.delete(doctor);
    }
}
