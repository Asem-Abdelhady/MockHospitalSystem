package com.company.DB;

import com.company.services.pharmacy.Medicine;
import com.company.services.pharmacy.Pharmacy;
import com.company.users.Doctor;
import com.company.users.Patient;

import java.util.Map;

/**
 * The type Data retriever.
 */
public class DataRetriever {
    private UsersDataBase usersDataBase;
    private static DataRetriever dataRetriever = null;

    private DataRetriever() {
        usersDataBase = new UsersDataBase();
    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static DataRetriever getInstance() {
        if (dataRetriever == null) dataRetriever = new DataRetriever();
        return dataRetriever;
    }

    /**
     * Gets doctors.
     *
     * @return the doctors
     */
    public Map<String, Doctor> getDoctors() {
        return usersDataBase.getDoctorsDB();
    }

    /**
     * Gets patients.
     *
     * @return the patients
     */
    public Map<String, Patient> getPatients() {
        return usersDataBase.getPatientsDB();
    }

    /**
     * Get pharmacies map.
     *
     * @return the map
     */
    public Map<String, Pharmacy> getPharmacies(){
        return usersDataBase.getPharmaciesDB();
    }

    /**
     * Add patient.
     *
     * @param name    the name
     * @param patient the patient
     */
    public void addPatient(String name,Patient patient){
        getPatients().put(name, patient);
    }

    /**
     * Add doctor.
     *
     * @param name   the name
     * @param doctor the doctor
     */
    public void addDoctor(String name, Doctor doctor){
        getDoctors().put(name, doctor);
    }

    /**
     * Add pharmacy.
     *
     * @param state    the state
     * @param pharmacy the pharmacy
     */
    public void addPharmacy(String state, Pharmacy pharmacy){
        getPharmacies().put(state, pharmacy);
    }

    /**
     * Add medicine.
     *
     * @param pharmacy the pharmacy
     * @param medicine the medicine
     */
    public void addMedicine(Pharmacy pharmacy, Medicine medicine){
        pharmacy.getMedicines().add(medicine);
    }
}
