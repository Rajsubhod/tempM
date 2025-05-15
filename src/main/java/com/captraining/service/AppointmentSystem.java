package com.captraining.service;

import com.captraining.entity.Doctor;
import com.captraining.entity.Patient;

public interface AppointmentSystem {
    void registerPatient(Patient patient);

    void registerDoctor(Doctor doctor);

    void bookAppointment(Patient patient);

    void completeAppointment(int index);

    void showAllAppointments();

    void showAllDoctors();
}
