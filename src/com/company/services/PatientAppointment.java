package com.company.services;

import com.company.DB.DataRetriever;
import com.company.specilizations.Specialization;
import com.company.users.Doctor;


public class PatientAppointment {
    String doctorName, state, insurance, patientName;
    Specialization specialization;

    private PatientAppointment(AppointmentBuilder builder) {
        this.patientName = builder.patientName;
        this.state = builder.state;
        this.specialization = builder.specialization;
        this.insurance = builder.insurance;
        this.doctorName = builder.doctorName;

    }

    public void getAppointment(String doctorName, String state, Specialization spec, int start, int end, String insurance) {
        if (DataRetriever.getInstance().getDoctors().containsKey(doctorName)) {
            Doctor doctor = DataRetriever.getInstance().getDoctors().get(doctorName);
            boolean isFree = true;
            if (doctor.getInsurance().equals(insurance) && doctor.getState().equals(state) && doctor.getSpecialization().equals(spec)) {
                for (int i = start + 1; i < end + 1; i++) {
                    if (!doctor.getSch()[i]) {
                        isFree = false;
                        break;
                    }
                }

                if (isFree) {
                    for (int i = start + 1; i < end + 1; i++) {
                        doctor.getSch()[i] = false;
                    }
                    System.out.println("Data confirmed, your appointment with the doctor is reserved !");
                }
            }
        }
    }

    public static class AppointmentBuilder{
        String doctorName, state, insurance, patientName;
        Specialization specialization;
        public AppointmentBuilder specialization(Specialization specialization){
            this.specialization = specialization;
            return this;
        }

        public AppointmentBuilder doctorName(String doctorName){
            this.doctorName = doctorName;
            return this;
        }

        public AppointmentBuilder state(String state){
            this.state = state;
            return this;
        }

        public AppointmentBuilder insurance(String insurance){
            this.insurance = insurance;
            return this;
        }

        public AppointmentBuilder patientName(String patientName){
            this.patientName = patientName;
            return this;
        }

        public PatientAppointment build(){
            return new PatientAppointment(this);
        }
    }

}
