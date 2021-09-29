package com.company.users;

import com.company.DB.DataRetriever;
import com.company.specilizations.Specialization;

public class Patient {
    private String name;
    private int id;

    public Patient(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void pay(int fee) {
        System.out.println("Fee paid! ");
    }

    public void orderMedicine(String med) {
        System.out.println("Medicine ordered! ");
    }

}
