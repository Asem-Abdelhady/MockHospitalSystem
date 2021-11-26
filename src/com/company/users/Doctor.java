package com.company.users;

import com.company.services.pharmacy.Medicine;
import com.company.services.pharmacy.PharmacySubscriber;
import com.company.services.transactions.BankCard;
import com.company.services.transactions.TransactionReceiver;
import com.company.specilizations.Specialization;

/**
 * The type Doctor.
 */
public class Doctor implements TransactionReceiver, PharmacySubscriber {
    private final String name, state, insurance;
    private final Specialization spec;
    private boolean sch[] = new boolean[24];

    /**
     * Instantiates a new Doctor.
     *
     * @param name      the name
     * @param state     the state
     * @param insurance the insurance
     * @param spec      the spec
     */
    public Doctor(String name, String state, String insurance, Specialization spec) {
        this.name = name;
        this.state = state;
        this.insurance = insurance;
        this.spec = spec;
        for (int i = 7; i < 18; i++) {
            sch[i] = true;
        }
    }

    /**
     * Gets state.
     *
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * Gets insurance.
     *
     * @return the insurance
     */
    public String getInsurance() {
        return insurance;
    }

    /**
     * Gets specialization.
     *
     * @return the specialization
     */
    public Specialization getSpecialization() {
        return spec;
    }

    /**
     * Get sch boolean [ ].
     *
     * @return the boolean [ ]
     */
    public boolean[] getSch() {
        return sch;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    @Override
    public void printBill(BankCard card) {
        System.out.println("Transaction succeeded from \n" + card.getNameHolder() + ": \n Card Number: " + card.getVisaNumber());
    }


    @Override
    public void printNotification(Medicine medicine) {
        System.out.println("Hello doctor " + this.name + ", the medicine " + medicine.getMedicineName() + " is now available in our pharmacy. You can suggest it to patients !");
    }
}
