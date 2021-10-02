package com.company;

import com.company.DB.DataRetriever;
import com.company.services.pharmacy.Pharmacy;
import com.company.specilizations.EyesSpecialization;
import com.company.specilizations.Specialization;
import com.company.users.Admin;
import com.company.users.Doctor;
import com.company.users.Patient;

import java.util.Scanner;

public class ConsoleApplication {
    Admin admin = new Admin("Ali");
    DataRetriever dataRetriever = DataRetriever.getInstance();
    Scanner scanner = new Scanner(System.in);
    int patientsCounter = 0;

    public ConsoleApplication() {
        admin.initializeData();
    }

    public void startProgram(){
        byte operation = userChoice();
        if(operation == 1){
            adminOperation();
        }
        else if(operation == 2){

        }
    }

    private Byte userChoice(){
        System.out.println("Who are you?\n1- admin\n2- patient\n3- pharmacy");
        return scanner.nextByte();
    }

    private Byte adminChoice(){
        System.out.println("What operation do you want to do?\n1- Add patient\n2- Add Doctor\n3- Add Pharmacy");
        return scanner.nextByte();
    }

    private Byte doctorSpecializationChoice(){
        System.out.println("What Specialization?\n 1- Eyes\n2- Skin");
        return scanner.nextByte();
    }

    private void adminOperation(){
        byte operation = adminChoice();
        if(operation == 1){
            System.out.print("Enter the patient name: ");
            String name = scanner.next();
            Patient patient = new Patient(name, patientsCounter);
            patientsCounter++;
            dataRetriever.addPatient(name, patient);
            System.out.println("Patient "+name+" is added!\n ---------------------\n ");
            startProgram();
        }

        if(operation == 2){
            System.out.print("Enter the doctor name: ");
            String doctorName = scanner.next();
            System.out.print("\nEnter the doctor state: ");
            String doctorState = scanner.next();
            System.out.print("\nEnter the doctor insurance: ");
            String doctorInsurance = scanner.next();
            System.out.println("\nEnter the doctor specialization: ");
            byte specChoice = doctorSpecializationChoice();
            Specialization doctorSpecialization;

            if(specChoice == 1){
                doctorSpecialization = new EyesSpecialization();
            }
            else if (specChoice == 2){
                doctorSpecialization = new EyesSpecialization();
            }
            else{
                doctorSpecialization = null;
            }

            Doctor doctor = new Doctor.DoctorBuilder(doctorName)
                    .state(doctorState)
                    .insurance(doctorInsurance)
                    .spec(doctorSpecialization)
                    .build();

            dataRetriever.addDoctor(doctorName, doctor);
            System.out.println("Doctor " + doctorName +" is added!\n ---------------------\n");
            startProgram();

        }

        else if(operation == 3){
            System.out.print("Enter the pharmacy state: ");
            String pharmacyState = scanner.next();
            System.out.print("\nEnter the pharmacy name: ");
            String pharmacyName = scanner.next();
            Pharmacy pharmacy = new Pharmacy(pharmacyState,pharmacyName);
            dataRetriever.addPharmacy(pharmacyState, pharmacy);
            System.out.println("\nPharmacy " + pharmacyName + " is added!\n ---------------------\n");
            startProgram();
        }
    }

}
