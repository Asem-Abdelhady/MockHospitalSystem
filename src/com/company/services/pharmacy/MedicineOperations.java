package com.company.services.pharmacy;

import com.company.DB.DataRetriever;

public class MedicineOperations {
    DataRetriever dataRetriever = DataRetriever.getInstance();

    public void addMedicine(Pharmacy pharmacy, Medicine medicine) {
        dataRetriever.addMedicine(pharmacy, medicine);
    }

    public void removeMedicine(Medicine medicine, Pharmacy pharmacy) {
        pharmacy.getMedicines().remove(medicine);
    }

    public Pharmacy pharmacyFinder(String state) {
        Pharmacy pharmacy = dataRetriever.getPharmacies().get(state);

        if (pharmacy == null) {
            System.out.println("We do not have a pharmacy partner in this state :(");
        }

        return pharmacy;

    }

    public void medicineList(Pharmacy pharmacy) {
        for (int i = 0; i < pharmacy.getMedicines().size(); i++) {
            System.out.println(i + 1 + "- " + pharmacy.getMedicines().get(i).getMedicineName());
        }
    }

    public int medicineFinder(String name, Pharmacy pharmacy) {
        for (int i = 0; i < pharmacy.getMedicines().size(); i++) {
            Medicine medicine = pharmacy.getMedicines().get(i);
            if (medicine.getMedicineName().equals(name)) {
                System.out.println("We have found the medicine, you will receive it soon. \n" + "Price = " + medicine.getPrice());
                return medicine.getPrice();
            }
        }
        System.out.println("The pharmacy does not have the medicine you entered:(");
        return 0;
    }
}
