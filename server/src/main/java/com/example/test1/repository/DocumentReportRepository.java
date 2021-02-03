package com.example.test1.repository;

import com.example.test1.model.DocumentReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentReportRepository extends JpaRepository<DocumentReport, Long> {
}
