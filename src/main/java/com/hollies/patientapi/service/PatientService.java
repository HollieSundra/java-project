package com.hollies.patientapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hollies.patientapi.model.Patient;

import graphql.com.google.common.base.Optional;

@Service

public class PatientService {
    private List<Patient> patients = new ArrayList<>();
    private Long nextId = 1L;

    public Patient createPatient(PatientInput patientInput) {
        
        if (isPatientInputValid(patientInput)) {
            Patient newPatient = convertToPatient(patientInput);
            newPatient.setId(nextId);
            patients.add(newPatient);
            nextId++;
            return newPatient;
        }else {
            throw new IllegalArgumentException("Invalid patient input");
        }
    }

    public Patient getPatient(Long id) {
        
        Optional<Patient> patient = patients.stream()
            .filter(p ->p.getId().equals(id))
            .findFirst();

        if (patient.isPresent()) {
            return patient.get();
        } else {
            throw new PatientNotFoundException("Patient not found");
        }
        
    }

    public List<Long> searchPatients(String firstName, String lastName, String gender, String phoneNumber, String email, String address, String visitDate, String diagnosis, String drugCode) {
        return patients.stream()
            .filter(p -> (firstName == null || p.getFirstName().equals(firstName)) &&
                        (lastName == null || p.getLastName().equals(lastName)) &&
                        (gender == null || p.getGender().equals(gender)) && 
                        (phoneNumber == null || p.getPhoneNumber().equals(phoneNumber)) &&
                        (email == null || p.getEmail().equals(email)) &&
                        (address == null || p.getAddress().equals(address)) &&
                        (visitDate == null || p.getVisitDate().equals(visitDate)) &&
                        (diagnosis == null || p.getDiagnosis().equals(diagnosis)) &&
                        (drugCode == null || p.getDrugCode().equals(drugCode)))
            .map(Patient::getId)
            .collect(Collectors.toList());            
        
    }

    public Patient updatePatient(Long id, PatientInput patientInput) {
        
        Optional<Patient> existingPatient = patients.stream()
        .filter(p -> p.getId().equals(id))
        .findFirst();

        if (existingPatient.isPresent()) {
            Patient updatePatient = convertToPatient(patientInput);
            updatePatient.setId(id);
            int index = patient.indexOf(existingPatient.get());
            patient.set(index, updatePatient);
            return updatePatient;
        } else {
            throw new PatientNotFoundException("Patient not found");
        }
    }

    public Patient deletePatient(Long id) {

        Optional<Patient> patient = patients.stream()
        .filter(p -> p.getId().equals(id))
        .findFirst();

        if (patient.isPresent()) {
            patients.remove(patient.get());
            return patient.get();
        } else {
            throw new PatientNotFoundException("Patient not found");
        }
    }

    private boolean isPatientInputValid(PatientInput patientInput) {

        return patientInput != null &&
               patientInput.getDiagnosis() != null &&
               !patientInput.getDiagnosis().isEmpty();
    }

    private Patient convertToPatient(PatientInput patientInput) {

        Patient patient = new Patient();
        patient.setFirstName(patientInput.getFirstName());
        patient.setLastName(patientInput.getLastName());
        patient.setGender(patientInput.getGender());
        patient.setPhoneNumber(patientInput.getPhoneNumber());
        patient.setEmail(patientInput.getEmail());
        patient.setAddress(patientInput.getAddress());
        patient.setVisitDate(patientInput.getVisitDate());
        patient.setDiagnosis(patientInput.getDiagnosis());
        patient.setDrugCode(patientInput.getDrugCode());
    
        return patient;
    }
}
