package com.company.services.pharmacy;

import com.company.services.transactions.BankCard;
import com.company.services.transactions.TransactionReceiver;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Pharmacy.
 */
public class Pharmacy implements TransactionReceiver {
    private String state;
    private String name;
    private List<Medicine> medicines;
    private List<PharmacySubscriber> subscribers;

    /**
     * Instantiates a new Pharmacy.
     *
     * @param state the state
     * @param name  the name
     */
    public Pharmacy(String state, String name) {
        this.state = state;
        this.name = name;
        medicines = new ArrayList<>();
        subscribers = new ArrayList<>();
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
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets medicines.
     *
     * @return the medicines
     */
    public List<Medicine> getMedicines() {
        return medicines;
    }

    /**
     * Subscribe.
     *
     * @param subscriber the subscriber
     */
    public void subscribe(PharmacySubscriber subscriber){
        this.subscribers.add(subscriber);
    }

    /**
     * Notify data change.
     *
     * @param medicine the medicine
     */
    public void notifyDataChange(Medicine medicine){
        for(int i = 0; i < subscribers.size(); i++){
            subscribers.get(i).printNotification(medicine);
        }
    }

    @Override
    public void printBill(BankCard card) {
        System.out.println("Transaction succeeded from \n" + card.getNameHolder() + ": \n Card Number: " + card.getVisaNumber());
    }
}
