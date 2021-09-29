package com.company.services.transactios;

import com.company.users.Patient;

public class Transaction {

    public void payBell(BankCard card, Patient patient, TransactionReceiver receiver){
        receiver.printBill(card);
    }
}
