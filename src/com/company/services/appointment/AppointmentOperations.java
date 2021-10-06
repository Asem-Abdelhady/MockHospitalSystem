package com.company.services.appointment;


import com.company.DB.DataRetriever;
import com.company.users.Doctor;

public class AppointmentOperations {
    DataRetriever dataRetriever = DataRetriever.getInstance();

    public Doctor findDoctor(String name) {
        return DataRetriever.getInstance().getDoctors().get(name);
    }

    public void doctorsList() {
        int i = 0;
        for (String key : dataRetriever.getDoctors().keySet()) {
            System.out.println(i + 1 + "- " + key);
            i++;
        }
    }
}
