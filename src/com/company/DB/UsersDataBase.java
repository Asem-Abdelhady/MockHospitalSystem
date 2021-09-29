package com.company.DB;

import com.company.services.pharmacy.Pharmacy;
import com.company.users.Doctor;
import com.company.users.Patient;

import java.util.HashMap;
import java.util.Map;

public class UsersDataBase {
    Map<String, Doctor> doctorsDB = new HashMap<>();
    Map<String, Patient> patientsDB = new HashMap<>();
    Map<String, Pharmacy> pharmaciesDB = new HashMap<>();

    public Map<String, Doctor> getDoctorsDB() {
        return doctorsDB;
    }

    public Map<String, Patient> getPatientsDB() {
        return patientsDB;
    }

    public Map<String, Pharmacy> getPharmaciesDB() {
        return pharmaciesDB;
    }
}
