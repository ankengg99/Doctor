package com.example.doctor.utils;

import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DoctorValidator {
    public List<String> validateDoctor(JSONObject json) {

        List<String> errorList = new ArrayList<>();

        if(!json.has("doctorId")) {
            errorList.add("doctorId");
        }

        if(!json.has("doctorName")) {
            errorList.add("doctorName");
        }

        if(!json.has("specialization")) {
            errorList.add("specialization");
        }

        return errorList;

    }
}
