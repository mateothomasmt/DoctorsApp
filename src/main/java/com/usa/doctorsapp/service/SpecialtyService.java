package com.usa.doctorsapp.service;

import com.usa.doctorsapp.model.Specialty;
import com.usa.doctorsapp.repository.SpecialtyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpecialtyService {
    @Autowired
    private SpecialtyRepository specialtyRepository;
    public List<Specialty> getAll(){return specialtyRepository.getAll();}
    public Optional<Specialty> getById(Integer id){return specialtyRepository.getById(id);}
    public Specialty save(Specialty specialty){
        if (specialty.getId()==null){
            return specialtyRepository.save(specialty);
        }else {
            Optional<Specialty> optionalSpecialtyModel=specialtyRepository.getById(specialty.getId());
            if (optionalSpecialtyModel.isEmpty()){
                return specialtyRepository.save(specialty);
            }else{
                return specialty;
            }
        }
    }
    public Specialty update(Specialty specialty){
        if(specialty.getId()!=null){
            Optional<Specialty> optionalSpecialtyModel=specialtyRepository.getById(specialty.getId());
            if(!optionalSpecialtyModel.isEmpty()){
                if(specialty.getName()!=null){
                    optionalSpecialtyModel.get().setName(specialty.getName());
                }
                if (specialty.getDescription()!=null){
                    optionalSpecialtyModel.get().setDescription(specialty.getDescription());
                }
                specialtyRepository.save(optionalSpecialtyModel.get());
                return optionalSpecialtyModel.get();
            }else{
                return specialty;
            }
        }else {
            return specialty;
        }
    }
    public boolean delete(Integer id){
        Boolean aBoolean=getById(id).map(specialtyModel -> {
            specialtyRepository.delete(specialtyModel);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
