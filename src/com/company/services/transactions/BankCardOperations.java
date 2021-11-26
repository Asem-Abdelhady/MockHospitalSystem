package com.company.services.transactions;

import com.company.users.Patient;

import java.util.List;


/**
 * The type Bank card operations.
 */
public class BankCardOperations {
    /**
     * Add card.
     *
     * @param patient  the patient
     * @param bankCard the bank card
     */
    public void addCard(Patient patient, BankCard bankCard) {
        patient.getBankCards().add(bankCard);
    }

    /**
     * Remove card.
     *
     * @param patient  the patient
     * @param bankCard the bank card
     */
    public void removeCard(Patient patient, BankCard bankCard) {
        patient.getBankCards().remove(bankCard);
    }

    /**
     * Card list.
     *
     * @param patient the patient
     */
    public void cardList(Patient patient) {
        for (int i = 0; i < patient.getBankCards().size(); i++) {
            System.out.println(i + 1 + "- " + patient.getBankCards().get(i).getVisaNumber());
        }
    }

    /**
     * Card finder bank card.
     *
     * @param cardNumber the card number
     * @param bankCards  the bank cards
     * @return the bank card
     */
    public BankCard cardFinder(long cardNumber, List<BankCard> bankCards) {
        for (BankCard bankCard : bankCards) {
            if (bankCard.getVisaNumber() == cardNumber) {
                return bankCard;
            }
        }

        System.out.println("This card does not exist, transaction failed!");
        return null;
    }
}
