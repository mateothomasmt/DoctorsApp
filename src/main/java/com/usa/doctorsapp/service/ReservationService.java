package com.usa.doctorsapp.service;


import com.usa.doctorsapp.model.ClientReport;
import com.usa.doctorsapp.model.Reservation;
import com.usa.doctorsapp.model.ReservationReport;
import com.usa.doctorsapp.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;
    public List<Reservation> getAll(){return reservationRepository.getAll();}
    public Optional<Reservation> getById(Integer id){return reservationRepository.getById(id);}
    public Reservation save(Reservation reservation){
        if (reservation.getIdReservation()==null){
            return reservationRepository.save(reservation);
        }else {
            Optional<Reservation> optionalReservationModel=reservationRepository.getById(reservation.getIdReservation());
            if (optionalReservationModel.isEmpty()){
                return reservationRepository.save(reservation);
            }else{
                return reservation;
            }
        }
    }
    public Reservation update(Reservation reservation){
        if(reservation.getIdReservation()!=null){
            Optional<Reservation> optionalReservationModel=reservationRepository.getById(reservation.getIdReservation());
            if(!optionalReservationModel.isEmpty()){
                if(reservation.getStartDate()!=null){
                    optionalReservationModel.get().setStartDate(reservation.getStartDate());
                }
                if(reservation.getDevolutionDate()!=null){
                    optionalReservationModel.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if(reservation.getStatus()!=null){
                    optionalReservationModel.get().setStatus(reservation.getStatus());
                    optionalReservationModel.get().setDoctor(reservation.getDoctor());
                    optionalReservationModel.get().setClient(reservation.getClient());
                }
                reservationRepository.save(optionalReservationModel.get());
                return optionalReservationModel.get();
            }else{
                return reservation;
            }
        }else {
            return reservation;
        }
    }
    public boolean delete(Integer id){
        Boolean aBoolean=getById(id).map(reservationModel -> {
            reservationRepository.delete(reservationModel);
            return true;
        }).orElse(false);
        return aBoolean;
    }

    public ReservationReport getReservationsStatusReport(){
        List<Reservation> completed = reservationRepository.getReservationByStatus("completed");
        List<Reservation> cancelled= reservationRepository.getReservationByStatus("cancelled");
        return new ReservationReport(completed.size(), cancelled.size());
    }
    public List<Reservation> getReservationPeriod(String dateA, String dateB){
        SimpleDateFormat parser=new SimpleDateFormat("yyyy-MM-dd");
        Date aDate= new Date();
        Date bDate= new Date();

        try {
            aDate = parser.parse(dateA);
            bDate = parser.parse(dateB);
        }catch(ParseException evt){
            evt.printStackTrace();
        }
        if(aDate.before(bDate)){
            return reservationRepository.getReservationPeriod(aDate, bDate);
        }else{
            return new ArrayList<>();
        }
    }
    public List<ClientReport> getTopClients(){
        return reservationRepository.getTopClients();
    }

}

