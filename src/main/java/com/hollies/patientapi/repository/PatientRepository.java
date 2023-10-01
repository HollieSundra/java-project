package com.hollies.patientapi.repository;

import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PatientResolver implements GraphQLQueryResolver {

    private final PatientRepository patientRepository;

    @Autowired
    public PatientResolver(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<Patient> findPatientByFirstName(String firstName) {
        return patientRepository.findPatientByFirstName(firstName);
    }

     public List<Patient> findPatientByLastName(String lastName) {
        return patientRepository.findPatientByLastName(lastName);
    }

     public List<Patient> findPatientByGender(String gender) {
        return patientRepository.findPatientByGender(gender);
    }

     public List<Patient> findPatientByPhoneNumber(String phoneNumber) {
        return patientRepository.findPatientByPhoneNumber(phoneNumber);
    }

     public List<Patient> findPatientByEmail(String email) {
        return patientRepository.findPatientByEmail(email);
    }

     public List<Patient> findPatientByAddress(String address) {
        return patientRepository.findPatientByAddress(address);
    }

     public List<Patient> findPatientByVisitDate(String visitDate) {
        return patientRepository.findPatientByVisitDate(visitDate);
    }

     public List<Patient> findPatientByDiagnosis(String diagnosis) {
        return patientRepository.findPatientByDiagnosis(diagnosis);
    }

     public List<Patient> findPatientByDrugCode(String drugCode) {
        return patientRepository.findPatientByDrugCode(drugCode);
    }

}
