package com.company;

import com.company.services.pharmacy.Pharmacy;
import com.company.specilizations.EyesSpecialization;
import com.company.specilizations.SkinSpecialization;
import com.company.users.Admin;
import com.company.users.Doctor;

public class Main {

    public static void main(String[] args) {
        Admin admin = new Admin("Ali");
        admin.initializeData();

    }
}
