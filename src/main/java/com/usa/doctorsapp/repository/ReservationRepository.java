package com.usa.doctorsapp.repository;


import com.usa.doctorsapp.model.Client;
import com.usa.doctorsapp.model.ClientReport;
import com.usa.doctorsapp.model.Reservation;
import com.usa.doctorsapp.repository.crudrepository.ReservationCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository {
    @Autowired
    private ReservationCrudRepository reservationCrudRepository;

    public List<Reservation> getAll(){
        return (List<Reservation>) reservationCrudRepository.findAll();
    }
    public Optional<Reservation> getById(Integer id){
        return reservationCrudRepository.findById(id);
    }
    public Reservation save(Reservation reservation){
        return reservationCrudRepository.save(reservation);
    }
    public void delete(Reservation reservation){
        reservationCrudRepository.delete(reservation);
    }

    public List<Reservation> getReservationByStatus(String status){
        return reservationCrudRepository.findAllByStatus(status);
    }
    public List<Reservation> getReservationPeriod(Date dateOne, Date dateTwo){
        return reservationCrudRepository.findAllByStartDateAfterAndStartDateBefore(dateOne, dateTwo);
    }
    public List<ClientReport> getTopClients(){
        List<ClientReport> response=new ArrayList<>();
        List<Object[]> report=reservationCrudRepository.countTotalReservationByClient();
        for (int i = 0; i<report.size();i++){
            response.add(new ClientReport((Long)report.get(i)[1], (Client) report.get(i)[0]));
        }
        return response;
    }
}
