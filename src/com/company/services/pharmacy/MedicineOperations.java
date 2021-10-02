package com.company.services.pharmacy;

import com.company.DB.DataRetriever;

public class MedicineOperations {
    DataRetriever dataRetriever = DataRetriever.getInstance();

    public void addMedicine(Pharmacy pharmacy,Medicine medicine){
        dataRetriever.addMedicine(pharmacy, medicine);
    }

    public void removeMedicine(Medicine medicine, Pharmacy pharmacy){
        pharmacy.getMedicines().remove(medicine);
    }

    public void pharmacyFinder(String medicineName, String state){
        Pharmacy pharmacy = dataRetriever.getPharmacies().get(state);
        if( pharmacy == null){
            System.out.println("We do not have a pharmacy partner in this state :(");
        }
        else{
            for(int i = 0; i < pharmacy.getMedicines().size(); i++){
                Medicine medicine = pharmacy.getMedicines().get(i);
                if(medicine.getMedicineName().equals(medicineName)){
                    System.out.println("We have found the medicine you will receive it soon. \n" +"Price = " + medicine.getPrice());
                    return;
                }
            }

            System.out.println("The stock is empty, your medicine does not exist :(");
        }

    }
}
