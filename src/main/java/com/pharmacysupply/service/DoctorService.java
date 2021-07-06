package com.pharmacysupply.service;

import com.pharmacysupply.dao.DoctorRepository;
import com.pharmacysupply.entity.RepSchedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
//This is a service class which returns the all the data stored into the doctor_list table into the controller,
//using the JPA Repository remade function "findall".
@Service
/*
Indicates that an annotated class is a "Service", originally defined by Domain-Driven Design (Evans, 2003) as
 "an operation offered as an interface that stands alone in the model, with no encapsulated state."
 */
public class DoctorService {
    @Autowired
    /*
    Marks a constructor, field, setter method, or
     config method as to be autowired by
     Spring's dependency injection facilities.
     */
    private DoctorRepository doctorRepository;
    public List<RepSchedule> getAllDoctors() {
        try {
            return this.doctorRepository.findAll();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
