package com.company.services.pharmacy;

/**
 * The interface Pharmacy subscriber.
 */
public interface PharmacySubscriber {
    /**
     * Print notification.
     *
     * @param medicine the medicine
     */
    void printNotification(Medicine medicine);
}
