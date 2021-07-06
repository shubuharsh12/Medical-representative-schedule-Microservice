package com.pharmacysupply.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@Table(name="MedicineStock")
public class MedicineStock implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    //@Convert(converter = Jsr310JpaConverters.LocalDateTimeConverter.class)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long mId;

    private String name;

    @OneToMany(cascade=CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "medicineStock")
    private List<ChemicalComposition> chemicalComposition= new ArrayList<>();
    @JsonFormat(pattern = "yyyy/MM/dd")
    private Date localDate;
    private String TargetAilment;
    private int NumberOfTabletsInStock;
    public MedicineStock() {
        super();
        // TODO Auto-generated constructor stub
    }







}
