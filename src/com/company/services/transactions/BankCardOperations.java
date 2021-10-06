package com.company.services.transactions;

import com.company.users.Patient;

import java.util.List;


public class BankCardOperations {
    public void addCard(Patient patient, BankCard bankCard) {
        patient.getBankCards().add(bankCard);
    }

    public void removeCard(Patient patient, BankCard bankCard) {
        patient.getBankCards().remove(bankCard);
    }

    public void cardList(Patient patient) {
        for (int i = 0; i < patient.getBankCards().size(); i++) {
            System.out.println(i + 1 + "- " + patient.getBankCards().get(i).getVisaNumber());
        }
    }

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
