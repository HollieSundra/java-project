package com.hollies.patientapi.model;
import java.util.List;

public class Patient {
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
