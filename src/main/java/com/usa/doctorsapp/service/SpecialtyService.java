package com.usa.doctorsapp.service;

import com.usa.doctorsapp.model.SpecialtyModel;
import com.usa.doctorsapp.repository.SpecialtyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpecialtyService {
    @Autowired
    private SpecialtyRepository specialtyRepository;
    public List<SpecialtyModel> getAll(){return specialtyRepository.getAll();}
    public Optional<SpecialtyModel> getById(Integer id){return specialtyRepository.getById(id);}
    public SpecialtyModel save(SpecialtyModel specialtyModel){
        if (specialtyModel.getId()==null){
            return specialtyRepository.save(specialtyModel);
        }else {
            Optional<SpecialtyModel> optionalSpecialtyModel=specialtyRepository.getById(specialtyModel.getId());
            if (optionalSpecialtyModel.isEmpty()){
                return specialtyRepository.save(specialtyModel);
            }else{
                return specialtyModel;
            }
        }
    }
    public SpecialtyModel update(SpecialtyModel specialtyModel){
        if(specialtyModel.getId()!=null){
            Optional<SpecialtyModel> optionalSpecialtyModel=specialtyRepository.getById(specialtyModel.getId());
            if(!optionalSpecialtyModel.isEmpty()){
                if(specialtyModel.getName()!=null){
                    optionalSpecialtyModel.get().setName(specialtyModel.getName());
                }
                if (specialtyModel.getDescription()!=null){
                    optionalSpecialtyModel.get().setDescription(specialtyModel.getDescription());
                }
                specialtyRepository.save(optionalSpecialtyModel.get());
                return optionalSpecialtyModel.get();
            }else{
                return specialtyModel;
            }
        }else {
            return specialtyModel;
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
