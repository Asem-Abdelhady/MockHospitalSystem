package com.company.services.pharmacy;

import com.company.services.transactions.BankCard;
import com.company.services.transactions.TransactionReceiver;

import java.util.ArrayList;
import java.util.List;

public class Pharmacy implements TransactionReceiver {
    private String state;
    private String name;
    private List<Medicine> medicines;

    public Pharmacy(String state, String name) {
        this.state = state;
        this.name = name;
        medicines = new ArrayList<>();
    }

    public String getState() {
        return state;
    }

    public String getName() {
        return name;
    }

    public List<Medicine> getMedicines() {
        return medicines;
    }

    @Override
    public void printBill(BankCard card) {
        System.out.println("Transaction succeeded from \n" + card.getNameHolder() + ": \n Card Number: " + card.getVisaNumber());
    }
}
