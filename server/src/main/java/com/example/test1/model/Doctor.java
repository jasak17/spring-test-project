package com.example.test1.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "doctors")
public class Doctor {

    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "department")
    private String department;

    @OneToMany(mappedBy = "doctor", cascade = {CascadeType.ALL})
    private List<Patient> patients = new ArrayList<>();

    public Doctor(String department) {
        this.department = department;
    }

    public Doctor() {
    }

    public long getId() {
        return id;
    }

    public void setId(long doctor_id) {
        this.id = doctor_id;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
        patient.setDoctor(this);
    }

    public void removePatient(Patient patient) {
        patients.remove(patient);
        patient.setDoctor(null);
    }
}
