package com.example.doctor.service;

import com.example.doctor.dao.DoctorRepository;
import com.example.doctor.dao.PatientRepository;
import com.example.doctor.moudle.Doctor;
import com.example.doctor.moudle.Patient;
import com.example.doctor.utils.CommonValidator;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class PatientService {
    @Autowired
    PatientRepository repository;
    @Autowired
    DoctorRepository doctorRepository;

    public void savePatient(Patient patient){
        repository.save(patient);
    }
    public Patient setPatient(JSONObject jsonObject){
        Patient patient=new Patient();
        patient.setPatientId(jsonObject.getInt("patientId"));
        patient.setPatientName((jsonObject.getString("patientName")));
        patient.setDisease(jsonObject.getString("disease"));
        if(CommonValidator.validatePhoneNumber(jsonObject.getString("phoneNo"))) {
            patient.setPhoneNo(jsonObject.getString("phoneNo"));
        }
        else{
            patient.setPhoneNo("invalid no");
        }
        Doctor doctor= doctorRepository.findById(jsonObject.getInt("doctorId")).get();
        patient.setDoctorId(doctor);
        Timestamp curtime=new Timestamp(System.currentTimeMillis());
        patient.setAdmitTime(curtime);
        return patient;
    }
    public List<Patient> getPatient(Integer doctorId,Integer patientId){
        List<Patient> patients=new ArrayList<>();

        if(doctorId==null && patientId==null){
            return repository.findAll();
        }
        else if(doctorId==null){
            patients.add(repository.findById(patientId).get());
        }
        else if(patientId==null){
            Doctor doctor=doctorRepository.findById(doctorId).get();
            //patients.add(repository.get);
        }

        return patients;
    }
}
