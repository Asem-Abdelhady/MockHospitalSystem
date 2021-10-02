package com.company.DB;

import com.company.services.pharmacy.Medicine;
import com.company.services.pharmacy.Pharmacy;
import com.company.users.Doctor;
import com.company.users.Patient;

import java.util.Map;

public class DataRetriever {
    private UsersDataBase usersDataBase;
    private static DataRetriever dataRetriever = null;

    private DataRetriever() {
        usersDataBase = new UsersDataBase();
    }

    public static DataRetriever getInstance() {
        if (dataRetriever == null) dataRetriever = new DataRetriever();
        return dataRetriever;
    }

    public Map<String, Doctor> getDoctors() {
        return usersDataBase.getDoctorsDB();
    }

    public Map<String, Patient> getPatients() {
        return usersDataBase.getPatientsDB();
    }

    public Map<String, Pharmacy> getPharmacies(){
        return usersDataBase.getPharmaciesDB();
    }

    public void addPatient(String name,Patient patient){
        getPatients().put(name, patient);
    }

    public void addDoctor(String name, Doctor doctor){
        getDoctors().put(name, doctor);
    }

    public void addPharmacy(String state, Pharmacy pharmacy){
        getPharmacies().put(state, pharmacy);
    }

    public void addMedicine(Pharmacy pharmacy, Medicine medicine){
        pharmacy.getMedicines().add(medicine);
    }
}
