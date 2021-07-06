package com.pharmacysupply.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class ChemicalComposition {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //Id of long type for the chemicalComposition class.
    public Long id;
    //ChemicalComposition name as string
    public String chemicalComposition;
    //Many to one linking with the class MedicineStock, fetchtype lazy used so that no new column will form into the table
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonBackReference
    private MedicineStock medicineStock;

}
