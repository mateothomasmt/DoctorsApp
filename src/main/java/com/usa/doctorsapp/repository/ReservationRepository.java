package com.usa.doctorsapp.repository;


import com.usa.doctorsapp.model.ReservationModel;
import com.usa.doctorsapp.repository.crudrepository.ReservationCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository {
    @Autowired
    private ReservationCrudRepository reservationCrudRepository;

    public List<ReservationModel> getAll(){
        return (List<ReservationModel>) reservationCrudRepository.findAll();
    }
    public Optional<ReservationModel> getById(Integer id){
        return reservationCrudRepository.findById(id);
    }
    public ReservationModel save(ReservationModel reservation){
        return reservationCrudRepository.save(reservation);
    }
    public void delete(ReservationModel reservation){
        reservationCrudRepository.delete(reservation);
    }
}
