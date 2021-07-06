package com.pharmacysupply.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Medicine_name {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JoinColumn(name= "doctor_id")
    private Long mid;
    private String medicine_name;
    @ManyToOne
    @JsonBackReference
    private RepSchedule repSchedule;

}
