package com.company.services.pharmacy;

import java.util.ArrayList;
import java.util.List;

public class Pharmacy {
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
}
