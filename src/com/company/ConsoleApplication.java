package com.company;

import com.company.DB.DataRetriever;
import com.company.services.appointment.AppointmentOperations;
import com.company.services.appointment.PatientAppointment;
import com.company.services.pharmacy.Medicine;
import com.company.services.pharmacy.MedicineOperations;
import com.company.services.pharmacy.Pharmacy;
import com.company.services.transactions.BankCard;
import com.company.services.transactions.BankCardOperations;
import com.company.services.transactions.Transaction;
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

    public void startProgram() {
        byte operation = userChoice();
        if (operation == 1) {
            adminOperation();
        } else if (operation == 2) {
            patientOperation();
        }
        else if(operation == 3){
            pharmacyOperation();
        }
    }

    private byte patientChoice() {
        System.out.println("What operation do you want to do?\n1- Pick appointment \n2- Order medicine");
        return scanner.nextByte();
    }

    private byte pharmacyChoice() {
        System.out.println("Choose the number of operation\n1- Show medicines\n2- Add medicine");
        return scanner.nextByte();
    }

    private void pharmacyOperation() {
        System.out.println("Please enter pharmacy name: ");
        String name = scanner.next();
        System.out.println("Please enter pharmacy state: ");
        String state = scanner.next();

        Pharmacy pharmacy = dataRetriever.getPharmacies().get(state);

        byte operation = pharmacyChoice();
        if (operation == 1) {
            for (Medicine medicine : pharmacy.getMedicines())
                System.out.println(medicine.getMedicineName());
            userChoice();
        } else if (operation == 2) {
            System.out.println("Please enter medicine name: ");
            String medicineName = scanner.next();
            System.out.println("Please enter medicine price: ");
            int price = scanner.nextInt();
            MedicineOperations medicineOperations = new MedicineOperations();
            medicineOperations.addMedicine(pharmacy, new Medicine(medicineName, price));
            System.out.println("Medicine added!");
            userChoice();
        }

    }

    private void patientOperation() {
        System.out.println("Please enter your name: ");
        String name = scanner.next();
        Patient patient = dataRetriever.getPatients().get(name);
        byte operation = patientChoice();
        if (operation == 1) {
            AppointmentOperations appointmentOperations = new AppointmentOperations();
            System.out.println("Enter the name of the doctor you want: \n");
            appointmentOperations.doctorsList();
            String doctorName = scanner.next();
            Doctor doctor = appointmentOperations.findDoctor(doctorName);
            byte specChoice = doctorSpecializationChoice();
            Specialization doctorSpecialization;

            if (specChoice == 1) {
                doctorSpecialization = new EyesSpecialization();
            } else if (specChoice == 2) {
                doctorSpecialization = new EyesSpecialization();
            } else {
                doctorSpecialization = null;
            }
            System.out.print("\nEnter the doctor insurance: ");
            String doctorInsurance = scanner.next();

            System.out.println("\nEnter the start hour");
            int start = scanner.nextInt();
            System.out.println("Enter the end hour");
            int end = scanner.nextInt();


            PatientAppointment patientAppointment = new PatientAppointment.AppointmentBuilder()
                    .doctorName(doctorName)
                    .patientName(name)
                    .insurance(doctorInsurance)
                    .specialization(doctorSpecialization)
                    .build();
            int appointmentState = patientAppointment.getAppointment(doctor, start, end);
            if (appointmentState == 0) return;

            BankCardOperations bankCardOperations = new BankCardOperations();
            System.out.println("Enter the last 4 numbers of the visa you want to pay with: ");
            bankCardOperations.cardList(patient);
            long cardNumber = scanner.nextLong();
            BankCard bankCard = bankCardOperations.cardFinder(cardNumber, patient.getBankCards());
            if (bankCard == null) return;

            Transaction transaction = new Transaction();
            transaction.payBill(bankCard, doctor);
            userChoice();

        }
        if (operation == 2) {
            MedicineOperations medicineOperations = new MedicineOperations();

            System.out.println("Please enter the state you currently live in: ");
            String state = scanner.next();
            Pharmacy pharmacy = medicineOperations.pharmacyFinder(state);

            if (pharmacy == null) return;

            System.out.println("Please enter the name of the medicine from the list below: ");
            medicineOperations.medicineList(pharmacy);
            String med = scanner.next();

            int price = medicineOperations.medicineFinder(med, pharmacy);
            if (price == 0) return;
            ;

            BankCardOperations bankCardOperations = new BankCardOperations();
            System.out.println("Enter the last 4 numbers of the visa you want to pay with: ");
            bankCardOperations.cardList(patient);
            long cardNumber = scanner.nextLong();
            BankCard bankCard = bankCardOperations.cardFinder(cardNumber, patient.getBankCards());
            if (bankCard == null) return;

            Transaction transaction = new Transaction();
            transaction.payBill(bankCard, pharmacy);

            userChoice();


        }
    }

    private byte userChoice() {
        System.out.println("Who are you?\n1- admin\n2- patient\n3- pharmacy");
        return scanner.nextByte();
    }

    private byte adminChoice() {
        System.out.println("What operation do you want to do?\n1- Add patient\n2- Add Doctor\n3- Add Pharmacy");
        return scanner.nextByte();
    }

    private byte doctorSpecializationChoice() {
        System.out.println("What Specialization?\n1- Eyes\n2- Skin");
        return scanner.nextByte();
    }

    private void adminOperation() {
        byte operation = adminChoice();
        if (operation == 1) {
            System.out.print("Enter the patient name: ");
            String name = scanner.next();
            Patient patient = new Patient(name, patientsCounter);
            patientsCounter++;
            dataRetriever.addPatient(name, patient);
            System.out.println("Patient " + name + " is added!\n ---------------------\n ");
            startProgram();
        }

        if (operation == 2) {
            System.out.print("Enter the doctor name: ");
            String doctorName = scanner.next();
            System.out.print("\nEnter the doctor state: ");
            String doctorState = scanner.next();
            System.out.print("\nEnter the doctor insurance: ");
            String doctorInsurance = scanner.next();
            System.out.println("\nEnter the doctor specialization: ");
            byte specChoice = doctorSpecializationChoice();
            Specialization doctorSpecialization;

            if (specChoice == 1) {
                doctorSpecialization = new EyesSpecialization();
            } else if (specChoice == 2) {
                doctorSpecialization = new EyesSpecialization();
            } else {
                doctorSpecialization = null;
            }

            Doctor doctor = new Doctor.DoctorBuilder(doctorName)
                    .state(doctorState)
                    .insurance(doctorInsurance)
                    .spec(doctorSpecialization)
                    .build();

            dataRetriever.addDoctor(doctorName, doctor);
            System.out.println("Doctor " + doctorName + " is added!\n ---------------------\n");
            startProgram();

        } else if (operation == 3) {
            System.out.print("Enter the pharmacy state: ");
            String pharmacyState = scanner.next();
            System.out.print("\nEnter the pharmacy name: ");
            String pharmacyName = scanner.next();
            Pharmacy pharmacy = new Pharmacy(pharmacyState, pharmacyName);
            dataRetriever.addPharmacy(pharmacyState, pharmacy);
            System.out.println("\nPharmacy " + pharmacyName + " is added!\n ---------------------\n");
            startProgram();
        }
    }

}
