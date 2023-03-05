package com.example.doctor.service;

import com.example.doctor.dao.DoctorRepository;
import com.example.doctor.moudle.Doctor;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorService {
    @Autowired
    DoctorRepository repository;

    public void saveDoctor(Doctor doctor) {
        String doctorName = doctor.getDoctorName();
        doctorName = "Dr. " + doctorName;
        doctor.setDoctorName(doctorName);
          repository.save(doctor);
    }

    public List<Doctor> getDoctor(String doctorId) {

        List<Doctor> doctorList;

        if(null != doctorId) {
            doctorList = new ArrayList<>();
            doctorList.add(repository.findById(Integer.valueOf(doctorId)).get());
        } else {
            doctorList = repository.findAll();
        }
        return doctorList;
    }

    public Doctor getDoctorById(int doctorId) {

        return repository.findById(doctorId).get();
    }
    public Doctor setDoctor (JSONObject json) {
        Doctor doctor = new Doctor();

        int doctorId =  json.getInt("doctorId");
        doctor.setDoctorId(doctorId);

        String doctorName = json.getString("doctorName");
        doctor.setDoctorName(doctorName);

        String s = json.getString("specialization");
        doctor.setSpecialization(s);

        if(json.has("experience")) {
            int exp = json.getInt("experience");
            doctor.setExperience(exp);
        }

        return doctor;

    }
}
