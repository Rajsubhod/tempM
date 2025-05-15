package com.captraining.service;

import com.captraining.entity.Appointment;
import com.captraining.entity.Doctor;
import com.captraining.entity.Patient;

import java.util.Optional;

public interface AppointmentSystem {
    void registerPatient(Patient patient);

    void registerDoctor(Doctor doctor);

    Appointment bookAppointment(Patient patient);

    void completeAppointment(int index);

    void showAllAppointments();

    void showAllDoctors();
}
