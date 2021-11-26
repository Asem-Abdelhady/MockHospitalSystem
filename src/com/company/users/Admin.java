package com.company.users;

import com.company.DB.DataRetriever;
import com.company.services.pharmacy.Medicine;
import com.company.services.pharmacy.MedicineOperations;
import com.company.services.pharmacy.Pharmacy;
import com.company.services.transactions.BankCard;
import com.company.services.transactions.BankCardOperations;
import com.company.specilizations.EyesSpecialization;
import com.company.specilizations.SkinSpecialization;

/**
 * The type Admin.
 */
public class Admin {
    private String name;
    private final String password = "1234";
    /**
     * The Data retriever.
     */
    DataRetriever dataRetriever = DataRetriever.getInstance();

    /**
     * Instantiates a new Admin.
     *
     * @param name the name
     */
    public Admin(String name) {
        this.name = name;
    }

    /**
     * Add doctor.
     *
     * @param doctor the doctor
     */
    public void addDoctor(Doctor doctor) {
        dataRetriever.getDoctors().put(doctor.getName(), doctor);
    }

    /**
     * Add pharmacy.
     *
     * @param pharmacy the pharmacy
     */
    public void addPharmacy(Pharmacy pharmacy) {
        dataRetriever.getPharmacies().put(pharmacy.getState(), pharmacy);
    }

    /**
     * Initialize data.
     */
    public void initializeData() {

        Doctor doctor1 = new Doctor("Hadi","Syria","NoInsurance", new EyesSpecialization());
        Doctor doctor2 = new Doctor("Asem","Egypt","VIP", new SkinSpecialization());



        Patient patient1 = new Patient("Asem", 1);
        Patient patient2 = new Patient("Murhaf", 2);

        Pharmacy pharmacy1 = new Pharmacy("Syria", "pharmacy");
        Pharmacy pharmacy2 = new Pharmacy("Egypt", "El3os");

        addDoctor(doctor1);
        addDoctor(doctor2);
        addPharmacy(pharmacy1);
        addPharmacy(pharmacy2);

        pharmacy2.subscribe(doctor1);
        pharmacy2.subscribe(doctor2);
        pharmacy2.subscribe(patient1);
        pharmacy2.subscribe(patient2) ;
        dataRetriever.addPatient(patient1.getName(), patient1);

        MedicineOperations medicineOperations = new MedicineOperations();
        Medicine parastemol = new Medicine("Parastemol", 5);
        medicineOperations.addMedicine(pharmacy2, parastemol);

        BankCard masterCard = new BankCard("Asem", 4567, 977, 23);
        BankCardOperations bankCardOperations = new BankCardOperations();
        bankCardOperations.addCard(patient1, masterCard);

    }


}



