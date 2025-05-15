package com.captraining.service.Impl;

import com.captraining.entity.Appointment;
import com.captraining.entity.Doctor;
import com.captraining.entity.Patient;
import com.captraining.exception.InvalidAppointmentException;
import com.captraining.service.AppointmentSystem;

import java.util.ArrayList;
import java.util.List;

public class AppointmentSystemImpl implements AppointmentSystem {
    private List<Patient> patients = new ArrayList<>();
    private List<Doctor> doctors = new ArrayList<>();
    private List<Appointment> appointments = new ArrayList<>();

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    private static AppointmentSystemImpl INSTANCE;

    public static AppointmentSystemImpl getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new AppointmentSystemImpl();
        }
        return INSTANCE;
    }

    public void registerPatient(Patient patient) {
        patients.add(patient);
    }

    public void registerDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public Appointment bookAppointment(Patient patient) {
        try {
            if (patient == null) {
                throw new InvalidAppointmentException("Invalid patient");
            }
            for (Doctor doctor : doctors) {
                if (doctor.isAvailable()) {
                    Appointment appointment = new Appointment(patient, doctor);
                    appointments.add(appointment);
                    System.out.println("Appointment booked successfully.");
                    return appointment;
                }
            }
            throw new InvalidAppointmentException("No available doctors");
        } catch (InvalidAppointmentException e) {
            System.err.println(e);
        }
        return null;
    }

    public void completeAppointment(int index) {
        try{
            if(index < 0 || index >= appointments.size()) {
                throw new InvalidAppointmentException("Invalid appointment index");
            }
            for(int i = 0; i < appointments.size(); i++) {
                if (i == index && appointments.get(i).getStatus().equals("Scheduled")) {
                    appointments.get(i).completedAppointment();
                    System.out.println("Appointment completed successfully.");
                    return;
                }
            }
            throw new InvalidAppointmentException("Invalid appointment index or already completed");
        } catch (InvalidAppointmentException e) {
            System.err.println(e);
        }
    }

    public void showAllDoctors() {
        for (Doctor doctor : doctors) {
            doctor.showProfile();
        }
    }

    public void showAllAppointments() {
        for (int i = 0; i <= appointments.size(); i++) {
            System.out.println("Index : "+i+1+" - "+ appointments.get(i).appointmentDetails());
        }
    }

}

