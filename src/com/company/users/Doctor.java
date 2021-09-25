package com.company.users;

import com.company.specilizations.Specialization;

public class Doctor {
    private String name, state, insurance;
    private Specialization spec;
    private boolean sch[] = new boolean[24];

    public Doctor(String name ,String state, String insurance, Specialization spec) {
        this.state = state;
        this.insurance = insurance;
        this.spec = spec;

        for (int i = 7; i < 18; i++) {
            sch[i] = true;
        }
    }


    public String getState() {
        return state;
    }

    public String getInsurance() {
        return insurance;
    }

    public Specialization getSpecialization() {
        return spec;
    }

    public boolean[] getSch() {
        return sch;
    }

    public String getName() {
        return name;
    }
}
