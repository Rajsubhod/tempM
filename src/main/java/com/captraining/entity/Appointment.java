package com.captraining.entity;

public class Appointment {
    private Patient patient;
    private Doctor doctor;
    private String status = "Scheduled";

    public Appointment() {
    }

    public Appointment(Patient patient, Doctor doctor) {
        this.patient = patient;
        this.doctor = doctor;
        this.doctor.setAvailable(false);
    }

    public String getStatus() {
        return status;
    }

    public void completedAppointment() {
        this.status = "Completed";
        this.doctor.setAvailable(true);
    }

    public String appointmentDetails() {
        return "Appointment Details: \n" +
                "Patient: " + patient.name + "\n" +
                "Doctor: " + doctor.name + "\n" +
                "Status: " + status;
    }

}
