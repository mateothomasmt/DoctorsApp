package com.usa.doctorsapp.repository;


import com.usa.doctorsapp.model.SpecialtyModel;
import com.usa.doctorsapp.repository.crudrepository.SpecialtyCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class SpecialtyRepository {
    @Autowired
    private SpecialtyCrudRepository specialtyCrudRepository;

    public List<SpecialtyModel> getAll(){
        return (List<SpecialtyModel>) specialtyCrudRepository.findAll();
    }
    public Optional<SpecialtyModel> getById(Integer id){
        return specialtyCrudRepository.findById(id);
    }
    public SpecialtyModel save(SpecialtyModel specialty){
        return specialtyCrudRepository.save(specialty);
    }
    public void delete(SpecialtyModel specialty){
        specialtyCrudRepository.delete(specialty);
    }
}
