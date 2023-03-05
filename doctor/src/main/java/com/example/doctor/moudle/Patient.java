package com.example.doctor.moudle;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Patient {
    @Id
    private Integer patientId;
    private String patientName;
    private String disease;
    private String phoneNo;
    private Timestamp admitTime;
    @JoinColumn
    @ManyToOne
    private Doctor doctorId;

}
