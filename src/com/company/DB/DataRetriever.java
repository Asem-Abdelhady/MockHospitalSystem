package com.company.DB;

import com.company.users.Doctor;
import com.company.users.Patient;
import com.company.users.SystemUser;

import java.util.Map;

public class DataRetriever {
    private UsersDataBase usersDataBase;
    private static DataRetriever dataRetriever = null;

    private DataRetriever(){usersDataBase = new UsersDataBase();}

    public static DataRetriever getInstance() {
        if(dataRetriever == null) dataRetriever = new DataRetriever();
        return dataRetriever;
    }

    Map<String, Doctor> getDoctors(){
        return usersDataBase.getDoctorsDB();
    }

    Map<String, Patient> getPatients(){
        return usersDataBase.getPatientsDB();
    }

    Map<String, SystemUser> getUsers(){
        return usersDataBase.getUsersDB();
    }
}
