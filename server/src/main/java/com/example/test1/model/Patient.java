package com.example.test1.model;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "patients")
public class Patient {

    @Id
    @Column (name = "id")
    private long id;

    @Column (name = "first_name")
    private String firstName;

    @Column (name = "last_name")
    private String lastName;

    @ElementCollection
    @Column (name = "diseases")
    private List<String> diseases = new ArrayList<>();


    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="doctor_id")
    @JsonIgnore
    private Doctor doctor;

    public Patient() {}

    public Patient(String firstName, String lastName, List<String> diseases, Doctor doctor) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.diseases = diseases;
        this.doctor = doctor;
    }

    public long getId() {
        return id;
    }

    public void setId(long patient_id) {
        this.id = patient_id;
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

    public List<String> getDiseases() {
        return diseases;
    }

    public void setDiseases(List<String> diseases) {
        this.diseases = diseases;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public void addDisease(String disease) {
        diseases.add(disease);
    }

}
