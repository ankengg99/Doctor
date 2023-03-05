package com.example.doctor.dao;

import com.example.doctor.moudle.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Integer> {
}
