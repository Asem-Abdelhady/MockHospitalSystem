package com.company.DB;

import com.company.services.pharmacy.Pharmacy;
import com.company.users.Doctor;
import com.company.users.Patient;

import java.util.HashMap;
import java.util.Map;

/**
 * The type Users data base.
 */
public class UsersDataBase {
    /**
     * The Doctors db.
     */
    Map<String, Doctor> doctorsDB = new HashMap<>();
    /**
     * The Patients db.
     */
    Map<String, Patient> patientsDB = new HashMap<>();
    /**
     * The Pharmacies db.
     */
    Map<String, Pharmacy> pharmaciesDB = new HashMap<>();

    /**
     * Gets doctors db.
     *
     * @return the doctors db
     */
    public Map<String, Doctor> getDoctorsDB() {
        return doctorsDB;
    }

    /**
     * Gets patients db.
     *
     * @return the patients db
     */
    public Map<String, Patient> getPatientsDB() {
        return patientsDB;
    }

    /**
     * Gets pharmacies db.
     *
     * @return the pharmacies db
     */
    public Map<String, Pharmacy> getPharmaciesDB() {
        return pharmaciesDB;
    }
}
