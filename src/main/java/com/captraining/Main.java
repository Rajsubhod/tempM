package com.captraining;

import com.captraining.entity.Doctor;
import com.captraining.entity.Patient;
import com.captraining.service.Impl.AppointmentSystemImpl;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        String name="";
        String id="";

        try(Scanner sc=new Scanner(System.in)) {

            boolean flag = true;
            while (flag) {
                System.out.println("1. Register Patient: ");
                System.out.println("2. Register Doctor: ");
                System.out.println("3. Book Appointment: ");
                System.out.println("4. Show All Doctors: ");
                System.out.println("5. Show All Appointments: ");
                System.out.println("6. Complete Appointment: ");
                System.out.println("7. Exit: ");
                System.out.print("Enter Your Choice: ");
                int choice = sc.nextInt();

                sc.nextLine();

                AppointmentSystemImpl appointmentSystem = AppointmentSystemImpl.getInstance();

                switch (choice) {
                    case 1:

                        try {
                            System.out.print("Enter Id For New Patient: ");
                            id = sc.nextLine();

                            if (id.isEmpty()) {
                                throw new RuntimeException("ID cannot be empty! ");
                            }
                        } catch (Exception e) {
                            System.out.println("Error: " + e.getMessage());
                            break;
                        }

                        try {
                            System.out.println("Enter Name of new Patient: ");
                            name = sc.nextLine();

                            if (name.isEmpty()) {
                                throw new RuntimeException("Name cannot be empty! ");
                            }
                        } catch (Exception e) {
                            System.out.println("Error: " + e.getMessage());
                            break;
                        }

                        Patient patient = new Patient(id, name);
                        appointmentSystem.registerPatient(patient);

                        break;


                    case 2:

                        try {
                            System.out.print("Enter Id For New Doctor: ");
                            id = sc.nextLine();

                            if (id.isEmpty()) {
                                throw new RuntimeException("ID cannot be empty! ");
                            }
                        } catch (Exception e) {
                            System.out.println("Error: " + e.getMessage());
                            break;
                        }

                        try {
                            System.out.println("Enter Name of new Doctor: ");
                            name = sc.nextLine();

                            if (name.isEmpty()) {
                                throw new RuntimeException("Name cannot be empty! ");
                            }
                        } catch (Exception e) {
                            System.out.println("Error: " + e.getMessage());
                            break;
                        }

                        Doctor doctor = new Doctor(id, name);
                        appointmentSystem.registerDoctor(doctor);

                        break;

                    case 3:
                        System.out.print("Enter patient ID for booking appointment: ");
                        id = sc.nextLine();

                        Iterator<Patient> itr = appointmentSystem.getPatients().iterator();
                        while (itr.hasNext()) {
                            patient = itr.next();
                            if (patient.getId().equals(id)) {
                                appointmentSystem.bookAppointment(patient);
                                break;
                            }
                            System.out.println("No patient found! ");
                            break;
                        }

                        break;

                    case 4:
                        appointmentSystem.showAllDoctors();
                        break;

                    case 5:
                        appointmentSystem.showAllAppointments();
                        break;

                    case 6:
                        System.out.println("Enter Index For Complete Appointment: ");
                        int index = sc.nextInt();
                        sc.nextLine();
                        appointmentSystem.completeAppointment(index);
                        break;
                }
            }
        }
    }
}