DROP TABLE IF EXISTS doctors;
DROP TABLE IF EXISTS patients;
DROP TABLE IF EXISTS document_report;

CREATE TABLE doctors (
	id INT PRIMARY KEY,
	department VARCHAR (50) NOT NULL
);

CREATE TABLE patients (
	id INT PRIMARY KEY,
	first_name VARCHAR (50) NOT NULL,
    last_name VARCHAR (50) NOT NULL,
    fk_doctor_id INT REFERENCES doctors(id)
);

CREATE TABLE document_report (
	id SERIAL PRIMARY KEY,
	doctor_id INTEGER,
	created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
	error VARCHAR (50)
);
