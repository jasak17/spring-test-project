package com.example.test1.controller;

import com.example.test1.model.Doctor;
import com.example.test1.model.DocumentReport;
import com.example.test1.model.Patient;
import com.example.test1.repository.*;
import io.swagger.annotations.ApiOperation;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/v1")
public class DoctorController {

    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private DocumentReportRepository documentReportRepository;

    @ApiOperation(value = "View a list of all doctors")
    @GetMapping("/doctors")
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    @ApiOperation(value = "Add a doctor to database")
    @PostMapping(value = "/doctors")
    public Doctor createDoctor(@Valid @RequestBody String body) {
        JSONObject doctorJSON = new JSONObject(body);
        Doctor doctor = new Doctor();

        DocumentReport documentReport = new DocumentReport();
        documentReport.setDoctorId(Integer.parseInt(doctorJSON.getJSONObject("doctor").getString("id")));
        documentReport.setId(0);
        documentReportRepository.save(documentReport);

        doctor.setId(Integer.parseInt(doctorJSON.getJSONObject("doctor").getString("id")));
        doctor.setDepartment(doctorJSON.getJSONObject("doctor").getString("department"));
        JSONArray patientsJSON = doctorJSON.getJSONObject("doctor").getJSONObject("patients").getJSONArray("patient");

        List patients = new ArrayList();
        for (int i = 0; i < patientsJSON.length(); i++) {
            Patient patient = new Patient();
            patient.setId(Integer.parseInt(patientsJSON.getJSONObject(i).getString("id")));
            patient.setFirstName(patientsJSON.getJSONObject(i).getString("first_name"));
            patient.setLastName(patientsJSON.getJSONObject(i).getString("last_name"));

            JSONArray diseasesJSON = patientsJSON.getJSONObject(i).getJSONObject("diseases").getJSONArray("disease");
            for (int j = 0; j < diseasesJSON.length(); j++) {
                patient.addDisease(diseasesJSON.get(j).toString());
            }

            doctor.addPatient(patient);

        }
        doctorRepository.save(doctor);

        return doctor;
    }
}
