package com.usa.doctorsapp.service;


import com.usa.doctorsapp.model.ReservationModel;
import com.usa.doctorsapp.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;
    public List<ReservationModel> getAll(){return reservationRepository.getAll();}
    public Optional<ReservationModel> getById(Integer id){return reservationRepository.getById(id);}
    public ReservationModel save(ReservationModel reservationModel){
        if (reservationModel.getId()==null){
            return reservationRepository.save(reservationModel);
        }else {
            Optional<ReservationModel> optionalReservationModel=reservationRepository.getById(reservationModel.getId());
            if (optionalReservationModel.isEmpty()){
                return reservationRepository.save(reservationModel);
            }else{
                return reservationModel;
            }
        }
    }
    public ReservationModel update(ReservationModel reservationModel){
        if(reservationModel.getId()!=null){
            Optional<ReservationModel> optionalReservationModel=reservationRepository.getById(reservationModel.getId());
            if(!optionalReservationModel.isEmpty()){
                if(reservationModel.getStartDate()!=null){
                    optionalReservationModel.get().setStartDate(reservationModel.getStartDate());
                }
                if(reservationModel.getDevolutionDate()!=null){
                    optionalReservationModel.get().setDevolutionDate(reservationModel.getDevolutionDate());
                }
                if(reservationModel.getStatus()!=null){
                    optionalReservationModel.get().setStatus(reservationModel.getStatus());
                    optionalReservationModel.get().setDoctor(reservationModel.getDoctor());
                    optionalReservationModel.get().setClient(reservationModel.getClient());
                }
                reservationRepository.save(optionalReservationModel.get());
                return optionalReservationModel.get();
            }else{
                return reservationModel;
            }
        }else {
            return reservationModel;
        }
    }
    public boolean delete(Integer id){
        Boolean aBoolean=getById(id).map(reservationModel -> {
            reservationRepository.delete(reservationModel);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
