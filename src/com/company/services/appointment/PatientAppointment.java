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


    public PatientAppointment(String doctorName, String insurance, String patientName, Specialization specialization) {
        this.doctorName = doctorName;
        this.insurance = insurance;
        this.patientName = patientName;
        this.specialization = specialization;
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

}
