package com.company.services.transactios;

public class BankCard {
    String nameHolder;
    long visaNumber;
    int CVC, expirationYear;

    public BankCard(String nameHolder, long visaNumber, int CVC, int expirationYear) {
        this.nameHolder = nameHolder;
        this.visaNumber = visaNumber;
        this.CVC = CVC;
        this.expirationYear = expirationYear;
    }

    public String getNameHolder() {
        return nameHolder;
    }

    public long getVisaNumber() {
        return visaNumber;
    }

    public int getCVC() {
        return CVC;
    }

    public int getExpirationYear() {
        return expirationYear;
    }
}
