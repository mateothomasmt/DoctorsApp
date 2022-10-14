package com.usa.doctorsapp.controller;

import com.usa.doctorsapp.model.SpecialtyModel;
import com.usa.doctorsapp.service.SpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Specialty")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class SpecialtyController {
    @Autowired
    private SpecialtyService specialtyService;
    @GetMapping("/all")
    public List<SpecialtyModel> getSpecialties(){
        return specialtyService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<SpecialtyModel> getSpecialty(@PathVariable("id")Integer id){
        return specialtyService.getById(id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public SpecialtyModel save(@RequestBody SpecialtyModel specialtyModel){
        return specialtyService.save(specialtyModel);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public SpecialtyModel update(@RequestBody SpecialtyModel specialtyModel){
        return specialtyService.update(specialtyModel);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id")Integer id){
        return specialtyService.delete(id);
    }
}
