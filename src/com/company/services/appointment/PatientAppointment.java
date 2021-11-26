package com.company.services.appointment;

import com.company.DB.DataRetriever;
import com.company.specilizations.Specialization;
import com.company.users.Doctor;

import javax.print.Doc;


/**
 * The type Patient appointment.
 */
public class PatientAppointment {
    /**
     * The Doctor name.
     */
    String doctorName, /**
     * The Insurance.
     */
    insurance, /**
     * The Patient name.
     */
    patientName;
    /**
     * The Specialization.
     */
    Specialization specialization;

    private PatientAppointment(AppointmentBuilder builder) {
        this.patientName = builder.patientName;
        this.specialization = builder.specialization;
        this.insurance = builder.insurance;
        this.doctorName = builder.doctorName;

    }

    /**
     * Gets appointment.
     *
     * @param doctor the doctor
     * @param start  the start
     * @param end    the end
     * @return the appointment
     */
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

    /**
     * The type Appointment builder.
     */
    public static class AppointmentBuilder {
        /**
         * The Doctor name.
         */
        String doctorName, /**
         * The Insurance.
         */
        insurance, /**
         * The Patient name.
         */
        patientName;
        /**
         * The Specialization.
         */
        Specialization specialization;

        /**
         * Specialization appointment builder.
         *
         * @param specialization the specialization
         * @return the appointment builder
         */
        public AppointmentBuilder specialization(Specialization specialization) {
            this.specialization = specialization;
            return this;
        }

        /**
         * Doctor name appointment builder.
         *
         * @param doctorName the doctor name
         * @return the appointment builder
         */
        public AppointmentBuilder doctorName(String doctorName) {
            this.doctorName = doctorName;
            return this;
        }


        /**
         * Insurance appointment builder.
         *
         * @param insurance the insurance
         * @return the appointment builder
         */
        public AppointmentBuilder insurance(String insurance) {
            this.insurance = insurance;
            return this;
        }

        /**
         * Patient name appointment builder.
         *
         * @param patientName the patient name
         * @return the appointment builder
         */
        public AppointmentBuilder patientName(String patientName) {
            this.patientName = patientName;
            return this;
        }

        /**
         * Build patient appointment.
         *
         * @return the patient appointment
         */
        public PatientAppointment build() {
            return new PatientAppointment(this);
        }
    }

}
