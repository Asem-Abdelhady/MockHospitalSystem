package com.company.users;

import com.company.specilizations.Specialization;

public class Doctor {
    private final String name, state, insurance;
    private final Specialization spec;
    private boolean sch[] = new boolean[24];

    private Doctor(DoctorBuilder builder) {
        this.name = builder.name;
        this.state = builder.state;
        this.insurance = builder.insurance;
        this.spec = builder.spec;
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


    public static class DoctorBuilder {
        private String name, state, insurance;
        private Specialization spec;

        public DoctorBuilder(String name) {
            this.name = name;
        }

        public DoctorBuilder state(String state) {
            this.state = state;
            return this;
        }

        public DoctorBuilder insurance(String insurance) {
            this.insurance = insurance;
            return this;
        }

        public DoctorBuilder spec(Specialization spec) {
            this.spec = spec;
            return this;
        }

        public Doctor build() {
            return new Doctor(this);
        }
    }
}
