package com.company.services.pharmacy;

public class Medicine {
    private String medicineName;
    private int price;

    public Medicine(String medicineName, int price) {
        this.medicineName = medicineName;
        this.price = price;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
