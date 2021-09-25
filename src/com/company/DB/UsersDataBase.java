package com.company.DB;

import com.company.users.Doctor;
import com.company.users.Patient;
import com.company.users.SystemUser;

import java.util.HashMap;
import java.util.Map;

public class UsersDataBase {
    Map<String, Doctor> doctorsDB = new HashMap<>();
    Map<String, Patient> patientsDB = new HashMap<>();
    Map<String, SystemUser> systemUsersDB = new HashMap<>();

    public Map<String, Doctor> getDoctorsDB() {
        return doctorsDB;
    }


    public Map<String, Patient> getPatientsDB() {
        return patientsDB;
    }

    public Map<String, SystemUser> getUsersDB() {
        return systemUsersDB;
    }
}
