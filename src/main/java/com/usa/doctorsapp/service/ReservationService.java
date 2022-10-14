package com.usa.doctorsapp.service;


import com.usa.doctorsapp.model.ClientReport;
import com.usa.doctorsapp.model.ReservationModel;
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
    public List<ReservationModel> getAll(){return reservationRepository.getAll();}
    public Optional<ReservationModel> getById(Integer id){return reservationRepository.getById(id);}
    public ReservationModel save(ReservationModel reservationModel){
        if (reservationModel.getIdReservation()==null){
            return reservationRepository.save(reservationModel);
        }else {
            Optional<ReservationModel> optionalReservationModel=reservationRepository.getById(reservationModel.getIdReservation());
            if (optionalReservationModel.isEmpty()){
                return reservationRepository.save(reservationModel);
            }else{
                return reservationModel;
            }
        }
    }
    public ReservationModel update(ReservationModel reservationModel){
        if(reservationModel.getIdReservation()!=null){
            Optional<ReservationModel> optionalReservationModel=reservationRepository.getById(reservationModel.getIdReservation());
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

    public ReservationReport getReservationsStatusReport(){
        List<ReservationModel> completed = reservationRepository.getReservationByStatus("completed");
        List<ReservationModel> cancelled= reservationRepository.getReservationByStatus("cancelled");
        return new ReservationReport(completed.size(), cancelled.size());
    }
    public List<ReservationModel> getReservationPeriod(String dateA, String dateB){
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

