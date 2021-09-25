package com.company.users;

import com.company.DB.DataRetriever;

public class SystemUser {
    private int userID;
    private String password;
    private DataRetriever dataRetriever;


    public SystemUser(int userID, String password) {
        this.userID = userID;
        this.password = password;
        dataRetriever = DataRetriever.getInstance();

    }
    public int getUserID() {
        return userID;
    }

    public String getPassword() {
        return password;
    }


    public void appoint(Patient patient, Doctor doctor){
        if(doctor.getAvailability()){
            doctor.setAvailability(false);
        }



    }



}
