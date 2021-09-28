package com.company;

import com.company.specilizations.EyesSpecialization;
import com.company.specilizations.SkinSpecialization;
import com.company.users.Doctor;

public class Main {

    public static void main(String[] args) {

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

}
