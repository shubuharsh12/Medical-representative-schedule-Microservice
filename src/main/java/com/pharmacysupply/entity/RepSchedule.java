package com.pharmacysupply.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Data

public class RepSchedule implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private Long doctor_id;
    private String rep_name;
    private String doctor_name;
    private String Treating_Ailment;
    @OneToMany(cascade= CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "repSchedule")
    private List<Medicine_name> Medicine=new ArrayList<>();
    private String slot;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    private Long doctor_contact;

    public RepSchedule() {
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RepSchedule that = (RepSchedule) o;
        return Objects.equals(doctor_id, that.doctor_id) && Objects.equals(rep_name, that.rep_name) && Objects.equals(doctor_name, that.doctor_name) && Objects.equals(Treating_Ailment, that.Treating_Ailment) && Objects.equals(Medicine, that.Medicine) && Objects.equals(slot, that.slot) && Objects.equals(date, that.date) && Objects.equals(doctor_contact, that.doctor_contact);
    }

    @Override
    public int hashCode() {
        return Objects.hash(doctor_id, rep_name, doctor_name, Treating_Ailment, Medicine, slot, date, doctor_contact);
    }

    @Override
    public String toString() {
        return "RepSchedule{" +
                "doctor_id=" + doctor_id +
                ", rep_name='" + rep_name + '\'' +
                ", doctor_name='" + doctor_name + '\'' +
                ", Treating_Ailment='" + Treating_Ailment + '\'' +
                ", Medicine=" + Medicine +
                ", slot='" + slot + '\'' +
                ", date=" + date +
                ", doctor_contact=" + doctor_contact +
                '}';
    }
}
