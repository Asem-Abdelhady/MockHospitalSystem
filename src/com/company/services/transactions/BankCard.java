package com.company.services.transactions;

/**
 * The type Bank card.
 */
public class BankCard {
    private String nameHolder;
    private long visaNumber;
    private int CVC, expirationYear;

    /**
     * Instantiates a new Bank card.
     *
     * @param nameHolder     the name holder
     * @param visaNumber     the visa number
     * @param CVC            the cvc
     * @param expirationYear the expiration year
     */
    public BankCard(String nameHolder, long visaNumber, int CVC, int expirationYear) {
        this.nameHolder = nameHolder;
        this.visaNumber = visaNumber;
        this.CVC = CVC;
        this.expirationYear = expirationYear;
    }

    /**
     * Gets name holder.
     *
     * @return the name holder
     */
    public String getNameHolder() {
        return nameHolder;
    }

    /**
     * Gets visa number.
     *
     * @return the visa number
     */
    public long getVisaNumber() {
        return visaNumber;
    }

    /**
     * Gets cvc.
     *
     * @return the cvc
     */
    public int getCVC() {
        return CVC;
    }

    /**
     * Gets expiration year.
     *
     * @return the expiration year
     */
    public int getExpirationYear() {
        return expirationYear;
    }
}
