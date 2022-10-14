package com.usa.doctorsapp.controller;

import com.usa.doctorsapp.model.DoctorModel;
import com.usa.doctorsapp.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Doctor")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class DoctorController {
    @Autowired
    private DoctorService doctorService;
    @GetMapping("/all")
    public List<DoctorModel> getDoctors(){
        return doctorService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<DoctorModel> getDoctor(@PathVariable("id") Integer id){
        return doctorService.getById(id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public DoctorModel save(@RequestBody DoctorModel doctorModel){
        return doctorService.save(doctorModel);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public DoctorModel update(@RequestBody DoctorModel doctorModel){
        return doctorService.update(doctorModel);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") Integer id){
        return doctorService.delete(id);
    }
}
