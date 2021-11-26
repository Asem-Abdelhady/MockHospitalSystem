package com.company.services.pharmacy;

/**
 * The type Medicine.
 */
public class Medicine {
    private String medicineName;
    private int price;

    /**
     * Instantiates a new Medicine.
     *
     * @param medicineName the medicine name
     * @param price        the price
     */
    public Medicine(String medicineName, int price) {
        this.medicineName = medicineName;
        this.price = price;
    }

    /**
     * Gets medicine name.
     *
     * @return the medicine name
     */
    public String getMedicineName() {
        return medicineName;
    }

    /**
     * Sets medicine name.
     *
     * @param medicineName the medicine name
     */
    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    /**
     * Gets price.
     *
     * @return the price
     */
    public int getPrice() {
        return price;
    }

    /**
     * Sets price.
     *
     * @param price the price
     */
    public void setPrice(int price) {
        this.price = price;
    }
}
