package com.example.doctor.controller;

import com.example.doctor.moudle.Doctor;
import com.example.doctor.service.DoctorService;
import com.example.doctor.utils.DoctorValidator;
import jakarta.annotation.Nullable;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/doctor-api/app")
public class Doctor_Controller {
    @Autowired
    DoctorService service;

    @PostMapping(value = "/doctor")
    public ResponseEntity<String> saveDoctor(@RequestBody String requestDoctor) {

        JSONObject json = new JSONObject(requestDoctor);
        DoctorValidator validator=new DoctorValidator();

        List<String> validationList = validator.validateDoctor(json);

        if(validationList.isEmpty()) {
            Doctor doctor = service.setDoctor(json);
            service.saveDoctor(doctor);
            return new ResponseEntity<>("Doctor saved", HttpStatus.CREATED);
        }
        else {

            String[] answer = Arrays.copyOf(
                    validationList.toArray(), validationList.size(), String[].class);

            return new ResponseEntity<>("Please pass these mandatory parameters- " +
                    Arrays.toString(answer), HttpStatus.BAD_REQUEST);
        }


    }



    @GetMapping(value = "/doctor")
    public List<Doctor> getDoctor(@Nullable @RequestParam String doctorId) {

        return service.getDoctor(doctorId);
    }


}
