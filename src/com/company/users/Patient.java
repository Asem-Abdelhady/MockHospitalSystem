package com.company.users;

import com.company.services.pharmacy.Medicine;
import com.company.services.pharmacy.PharmacySubscriber;
import com.company.services.transactions.BankCard;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Patient.
 */
public class Patient implements PharmacySubscriber {
    private String name;
    private int id;
    private List<BankCard> bankCards;

    /**
     * Instantiates a new Patient.
     *
     * @param name the name
     * @param id   the id
     */
    public Patient(String name, int id) {
        this.name = name;
        this.id = id;
        bankCards = new ArrayList<>();
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
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Gets bank cards.
     *
     * @return the bank cards
     */
    public List<BankCard> getBankCards() {
        return bankCards;
    }


    @Override
    public void printNotification(Medicine medicine) {
        System.out.println("Hello user " + this.name + " the medicine " + medicine.getMedicineName()+ " is now available in our pharmacy, you can buy it anytime!");
    }
}
