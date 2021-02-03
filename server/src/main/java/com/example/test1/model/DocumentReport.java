package com.example.test1.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "document_report")

public class DocumentReport {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(columnDefinition = "serial")
    private long id;

    @Column (name = "doctor_id")
    private long doctorId;

    @Column(name = "created_at")
    public Date createdAt;

    @Column (name = "error")
    private String error;

    @PrePersist
    void createdAt() {
        this.createdAt = new Date();
    }

    public DocumentReport() {}

    public DocumentReport(long id, long doctorId, Date createdAt, String error) {
        this.id = id;
        this.doctorId = doctorId;
        this.error = error;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(long doctor_id) {
        this.doctorId = doctor_id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
