package com.hollies.patientapi.controller;

import com.hollies.patientapi.repository.PatientRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class PatientResolver implements GraphQLQueryResolver {

    private final PatientRepository patientRepository;

    @Autowired
    public PatientResolver(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<Patient> findPatientsByFirstName(String firstName) {
        return patientRepository.findPatientsByFirstName(firstName);
    }

     public List<Patient> findPatientsByLastName(String lastName) {
        return patientRepository.findPatientsByLastName(lastName);
    }

     public List<Patient> findPatientsByGender(String gender) {
        return patientRepository.findPatientsByGender(gender);
    }

     public List<Patient> findPatientsByPhoneNumber(String phoneNumber) {
        return patientRepository.findPatientsByPhoneNumber(phoneNumber);
    }

     public List<Patient> findPatientByEmail(String email) {
        return patientRepository.findPatientByEmail(email);
    }

     public List<Patient> findPatientsByAddress(String address) {
        return patientRepository.findPatientsByAddress(address);
    }

     public List<Patient> findPatientsByVisitDate(String visitDate) {
        return patientRepository.findPatientsByVisitDate(visitDate);
    }

     public List<Patient> findPatientsByDiagnosis(String diagnosis) {
        return patientRepository.findPatientsByDiagnosis(diagnosis);
    }

     public List<Patient> findPatientsByDrugCode(String drugCode) {
        return patientRepository.findPatientsByDrugCode(drugCode);
    }

}