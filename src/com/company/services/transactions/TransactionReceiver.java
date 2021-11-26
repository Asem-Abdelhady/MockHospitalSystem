package com.company.services.transactions;

/**
 * The interface Transaction receiver.
 */
public interface TransactionReceiver {
    /**
     * Print bill.
     *
     * @param card the card
     */
    void printBill(BankCard card);
}
