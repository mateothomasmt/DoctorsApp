package com.usa.doctorsapp.service;

import com.usa.doctorsapp.model.ClientModel;
import com.usa.doctorsapp.model.DoctorModel;
import com.usa.doctorsapp.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    public List<DoctorModel> getAll(){return doctorRepository.getAll();}
    public Optional<DoctorModel> getById(Integer id){return doctorRepository.getById(id);}
    public DoctorModel save(DoctorModel doctorModel){
        if(doctorModel.getId()==null){
            return doctorRepository.save(doctorModel);
        }else{
            Optional<DoctorModel> optionalDoctorModel=doctorRepository.getById(doctorModel.getId());
            if(optionalDoctorModel.isEmpty()){
                return doctorRepository.save(doctorModel);
            }else{
                return doctorModel;
            }
        }
    }
    public DoctorModel update(DoctorModel doctorModel){
        if (doctorModel.getId()!=null){
            Optional<DoctorModel> optionalDoctorModel=doctorRepository.getById(doctorModel.getId());
            if(!optionalDoctorModel.isEmpty()){
                if (doctorModel.getName()!=null){
                    optionalDoctorModel.get().setName(doctorModel.getName());
                }
                if (doctorModel.getDepartment()!=null){
                    optionalDoctorModel.get().setDepartment(doctorModel.getDepartment());
                }
                if(doctorModel.getYear()!=null){
                    optionalDoctorModel.get().setYear(doctorModel.getYear());
                }
                if(doctorModel.getDescription()!=null){
                    optionalDoctorModel.get().setDescription(doctorModel.getDescription());
                }
                if(doctorModel.getSpecialty()!=null){
                    optionalDoctorModel.get().setSpecialty(doctorModel.getSpecialty());
                }
                doctorRepository.save(optionalDoctorModel.get());
                return optionalDoctorModel.get();
            }else{
                return doctorModel;
            }
        }else {
            return doctorModel;
        }
    }

    public boolean delete(Integer id){
        Boolean aBoolean=getById(id).map(doctorModel -> {
            doctorRepository.delete(doctorModel);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
