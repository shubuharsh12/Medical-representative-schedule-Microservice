package com.pharmacysupply.dao;

import com.pharmacysupply.entity.RepSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<RepSchedule,Long> {
}
