package com.hollies.patientapi.model;


import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String gender;
    private String phoneNumber;
    private String email;
    private String address;
    private String visitDate;
    private String diagnosis;
    private String drugCode;
    private List<AdditionalInformation> additionalInformation;
    
    public static class AdditionalInformation {
        private String notes;
        private boolean newPatient;
        private String race;
        private String ssn;
    }
}
