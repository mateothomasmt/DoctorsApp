package com.usa.doctorsapp.controller;

import com.usa.doctorsapp.model.ClientReport;
import com.usa.doctorsapp.model.ReservationModel;
import com.usa.doctorsapp.model.ReservationReport;
import com.usa.doctorsapp.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ReservationController {
    @Autowired
    private ReservationService reservationService;
    @GetMapping("/all")
    public List<ReservationModel> getReservations(){
        return reservationService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<ReservationModel> getReservation(@PathVariable("id") Integer id){
        return reservationService.getById(id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public ReservationModel save(@RequestBody ReservationModel reservationModel){
        return reservationService.save(reservationModel);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public ReservationModel update(@RequestBody ReservationModel reservationModel){
        return reservationService.update(reservationModel);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") Integer id){
        return reservationService.delete(id);
    }
    @GetMapping("/report-status")
    public ReservationReport getReservationsStatusReport(){
        return reservationService.getReservationsStatusReport();
    }
    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
    public List<ReservationModel> getReservationsReportDates(@PathVariable("dateOne") String dateOne, @PathVariable("dateTwo") String dateTwo){
        return reservationService.getReservationPeriod(dateOne, dateTwo);
    }
    @GetMapping("/report-clients")
    public List<ClientReport> getClients(){
        return reservationService.getTopClients();
    }
}
