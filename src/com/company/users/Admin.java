package com.company.users;

import com.company.DB.DataRetriever;
import com.company.services.pharmacy.Pharmacy;
import com.company.specilizations.EyesSpecialization;
import com.company.specilizations.SkinSpecialization;

public class Admin {
    private String name;
    private final String password = "1234";
    DataRetriever dataRetriever = DataRetriever.getInstance();

    public Admin(String name) {
        this.name = name;
    }

    public void addDoctor(Doctor doctor) {
        dataRetriever.getDoctors().put(doctor.getName(), doctor);
    }

    public void addPharmacy(Pharmacy pharmacy) {
        dataRetriever.getPharmacies().put(pharmacy.getState(), pharmacy);
    }

    public void initializeData() {

        Doctor doctor1 = new Doctor.DoctorBuilder("Hadi")
                .state("Syria")
                .insurance("NoInsurance")
                .spec(new EyesSpecialization())
                .build();

        Doctor doctor2 = new Doctor.DoctorBuilder("Asem")
                .state("Egypt")
                .insurance("VIP")
                .spec(new SkinSpecialization())
                .build();
    }

    Pharmacy pharmacy1 = new Pharmacy("Syria", "Syria ya dawla");
    Pharmacy pharmacy2 = new Pharmacy("Egypt", "El3os' Pharmacy");

}



