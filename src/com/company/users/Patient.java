package com.company.users;

import com.company.services.transactions.BankCard;

import java.util.ArrayList;
import java.util.List;

public class Patient {
    private String name;
    private int id;
    private List<BankCard> bankCards;

    public Patient(String name, int id) {
        this.name = name;
        this.id = id;
        bankCards = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public List<BankCard> getBankCards() {
        return bankCards;
    }


}
