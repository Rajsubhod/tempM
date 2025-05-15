package com.captraining.entity;


import com.captraining.annotation.Security;

import java.util.List;

@Security(role = "Admin")
public class Admin extends User {

    @Override
    void showProfile() {
        System.out.println("Admin ID: " + id + ", Admin Name: " + name);
    }

    public void removeDoctor(List<Doctor> doctors, String doctorId) {

        Security security = this.getClass().getAnnotation(Security.class);

        if(security != null && security.role().equals("Admin")){
            for (Doctor doctor : doctors) {
                if (doctor.id.equals(doctorId)) {
                    doctors.remove(doctor);
                    System.out.println("Doctor with ID " + doctorId + " has been removed.");
                    return;
                }
            }
            System.err.println("Doctor with ID " + doctorId + " not found.");
        } else {
            throw new RuntimeException("Unauthorized access");
        }
    }
}
