package com.company.services.appointment;


import com.company.DB.DataRetriever;
import com.company.users.Doctor;

/**
 * The type Appointment operations.
 */
public class AppointmentOperations {
    /**
     * The Data retriever.
     */
    DataRetriever dataRetriever = DataRetriever.getInstance();

    /**
     * Find doctor doctor.
     *
     * @param name the name
     * @return the doctor
     */
    public Doctor findDoctor(String name) {
        return DataRetriever.getInstance().getDoctors().get(name);
    }

    /**
     * Doctors list.
     */
    public void doctorsList() {
        int i = 0;
        for (String key : dataRetriever.getDoctors().keySet()) {
            System.out.println(i + 1 + "- " + key);
            i++;
        }
    }
}
