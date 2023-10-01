package com.hollies.patientapi.repository;

import org.springframework.data.jpa.respository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    Patient save(Paitent patient);

    Optional<Patient> findById(Long id);

    List<Patient> findAll();



    
}
