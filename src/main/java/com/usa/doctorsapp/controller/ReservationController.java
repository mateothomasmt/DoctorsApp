package com.usa.doctorsapp.controller;

import com.usa.doctorsapp.model.ClientReport;
import com.usa.doctorsapp.model.Reservation;
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
    public List<Reservation> getReservations(){
        return reservationService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Reservation> getReservation(@PathVariable("id") Integer id){
        return reservationService.getById(id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation reservation){
        return reservationService.save(reservation);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation update(@RequestBody Reservation reservation){
        return reservationService.update(reservation);
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
    public List<Reservation> getReservationsReportDates(@PathVariable("dateOne") String dateOne, @PathVariable("dateTwo") String dateTwo){
        return reservationService.getReservationPeriod(dateOne, dateTwo);
    }
    @GetMapping("/report-clients")
    public List<ClientReport> getClients(){
        return reservationService.getTopClients();
    }
}
