package com.company.services.appointment;

import com.company.DB.DataRetriever;
import com.company.specilizations.Specialization;
import com.company.users.Doctor;

import javax.print.Doc;


public class PatientAppointment {
    String doctorName, insurance, patientName;
    Specialization specialization;

    private PatientAppointment(AppointmentBuilder builder) {
        this.patientName = builder.patientName;
        this.specialization = builder.specialization;
        this.insurance = builder.insurance;
        this.doctorName = builder.doctorName;

    }

    public int getAppointment(Doctor doctor, int start, int end) {
        boolean isFree = true;
        if (doctor.getInsurance().equals(insurance) && doctor.getSpecialization().equals(specialization)) {
            for (int i = start + 1; i < end + 1; i++) {
                if (!doctor.getSch()[i]) {
                    isFree = false;
                    System.out.println("The doctor is not available at this time!");
                    break;
                }
            }

            if (isFree) {
                for (int i = start + 1; i < end + 1; i++) {
                    doctor.getSch()[i] = false;
                }
                System.out.println("Data confirmed, your appointment with the doctor is reserved !");
                return 1;
            } else {
                return 0;
            }
        } else {
            System.out.println("The doctor does not serve with Wither this specialization or this type of insurance");
            return 0;
        }
    }

    public static class AppointmentBuilder {
        String doctorName, insurance, patientName;
        Specialization specialization;

        public AppointmentBuilder specialization(Specialization specialization) {
            this.specialization = specialization;
            return this;
        }

        public AppointmentBuilder doctorName(String doctorName) {
            this.doctorName = doctorName;
            return this;
        }


        public AppointmentBuilder insurance(String insurance) {
            this.insurance = insurance;
            return this;
        }

        public AppointmentBuilder patientName(String patientName) {
            this.patientName = patientName;
            return this;
        }

        public PatientAppointment build() {
            return new PatientAppointment(this);
        }
    }

}
