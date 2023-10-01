package com.hollies.patientapi.model;


import java.util.List;
import jakarta.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;

@Entity
public class Patient implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    private String gender;

    @NotBlank
    @Pattern(regexp = "\\d{10}")
    private String phoneNumber;

    @Email
    private String email;

    @NotBlank
    private String address;

    @NotBlank
    private String visitDate;

    private String diagnosis;

    private String drugCode;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_id")
    private List<AdditionalInformation> additionalInformation;

    // Constructors for the Patient class

    public Patient() {
        // Default constructor
    }

    public Patient(
        String firstName,
        String lastName,
        String gender,
        String phoneNumber,
        String email,
        String address,
        String visitDate,
        String diagnosis,
        String drugCode,
        List<AdditionalInformation> additionalInformation
    ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.visitDate = visitDate;
        this.diagnosis = diagnosis;
        this.drugCode = drugCode;
        this.additionalInformation = additionalInformation;
    }

    // Getter and Setter methods for the Patient class fields

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(String visitDate) {
        this.visitDate = visitDate;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getDrugCode() {
        return drugCode;
    }

    public void setDrugCode(String drugCode) {
        this.drugCode = drugCode;
    }

    public List<AdditionalInformation> getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(List<AdditionalInformation> additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    // Nested class AdditionalInformation with its own constructors, getters, and setters

    public static class AdditionalInformation {
        private String notes;
        private boolean newPatient;
        private String race;
        private String ssn;

        // Constructors for the AdditionalInformation class

        public AdditionalInformation() {
            // Default constructor
        }

        public AdditionalInformation(String notes, boolean newPatient, String race, String ssn) {
            this.notes = notes;
            this.newPatient = newPatient;
            this.race = race;
            this.ssn = ssn;
        }

        // Getter and Setter methods for the AdditionalInformation class fields

        public String getNotes() {
            return notes;
        }

        public void setNotes(String notes) {
            this.notes = notes;
        }

        public boolean isNewPatient() {
            return newPatient;
        }

        public void setNewPatient(boolean newPatient) {
            this.newPatient = newPatient;
        }

        public String getRace() {
            return race;
        }

        public void setRace(String race) {
            this.race = race;
        }

        public String getSsn() {
            return ssn;
        }

        public void setSsn(String ssn) {
            this.ssn = ssn;
        }
    }
}
