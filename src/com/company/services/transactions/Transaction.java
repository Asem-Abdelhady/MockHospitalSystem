package com.company.services.transactions;

import com.company.users.Patient;

public class Transaction {

    public void payBill(BankCard card, TransactionReceiver receiver) {
        receiver.printBill(card);
    }
}
