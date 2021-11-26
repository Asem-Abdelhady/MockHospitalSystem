package com.company.services.pharmacy;

import com.company.DB.DataRetriever;

/**
 * The type Medicine operations.
 */
public class MedicineOperations {
    /**
     * The Data retriever.
     */
    DataRetriever dataRetriever = DataRetriever.getInstance();

    /**
     * Add medicine.
     *
     * @param pharmacy the pharmacy
     * @param medicine the medicine
     */
    public void addMedicine(Pharmacy pharmacy, Medicine medicine) {
        dataRetriever.addMedicine(pharmacy, medicine);
        pharmacy.notifyDataChange(medicine);
    }

    /**
     * Remove medicine.
     *
     * @param medicine the medicine
     * @param pharmacy the pharmacy
     */
    public void removeMedicine(Medicine medicine, Pharmacy pharmacy) {
        pharmacy.getMedicines().remove(medicine);
    }

    /**
     * Pharmacy finder pharmacy.
     *
     * @param state the state
     * @return the pharmacy
     */
    public Pharmacy pharmacyFinder(String state) {
        Pharmacy pharmacy = dataRetriever.getPharmacies().get(state);

        if (pharmacy == null) {
            System.out.println("We do not have a pharmacy partner in this state :(");
        }

        return pharmacy;

    }

    /**
     * Medicine list.
     *
     * @param pharmacy the pharmacy
     */
    public void medicineList(Pharmacy pharmacy) {
        for (int i = 0; i < pharmacy.getMedicines().size(); i++) {
            System.out.println(i + 1 + "- " + pharmacy.getMedicines().get(i).getMedicineName());
        }
    }

    /**
     * Medicine finder int.
     *
     * @param name     the name
     * @param pharmacy the pharmacy
     * @return the int
     */
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
