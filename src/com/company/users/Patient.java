package com.company.users;

import com.company.DB.DataRetriever;
import com.company.specilizations.Specialization;

public class Patient {
    private String name;
    private int id;

    public Patient(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void pay(int fee) {
        System.out.println("Fee paid! ");
    }

    public void orderMedicine(String med) {
        System.out.println("Medicine ordered! ");
    }

    public void getTreatment(String doctorName, String state, Specialization spec, int start, int end, String insurance){
       if(DataRetriever.getInstance().getDoctors().containsKey(doctorName)){
           Doctor doctor = DataRetriever.getInstance().getDoctors().get(doctorName);
           boolean isFree = true;
           if(doctor.getInsurance().equals(insurance) && doctor.getState().equals(state) && doctor.getSpecialization().equals(spec)){
               for(int i = start+1; i < end+1; i++){
                   if(!doctor.getSch()[i]) {
                       isFree = false;
                       break;
                   }
               }

               if(isFree){
                   for(int i = start+1; i < end+1; i++){
                       doctor.getSch()[i] = false;
                   }
                   System.out.println("Data confirmed, your appointment with the doctor is reserved !");
               }
           }
       }
    }
}
