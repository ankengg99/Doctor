package com.example.doctor.controller;

import com.example.doctor.moudle.Patient;
import com.example.doctor.service.PatientService;
import jakarta.annotation.Nullable;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class PatientController {
    @Autowired
    PatientService service;
   @PostMapping("/patient")
    public String savePatient(@RequestBody String patient){
       JSONObject jsonObject=new JSONObject(patient);
      Patient patient1= service.setPatient(jsonObject);
       service.savePatient(patient1);
       return "saved";
   }
      @GetMapping("/patient")
    public List<Patient> getPatients(@Nullable @RequestParam Integer  doctorId,
                                     @Nullable @RequestParam Integer patientId){
       return service.getPatient(doctorId,patientId);
      }
}
