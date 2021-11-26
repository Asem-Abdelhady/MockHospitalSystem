package com.company.services.transactions;

/**
 * The type Transaction.
 */
public class Transaction {

    /**
     * Pay bill.
     *
     * @param card     the card
     * @param receiver the receiver
     */
    public void payBill(BankCard card, TransactionReceiver receiver) {
        receiver.printBill(card);
    }
}
