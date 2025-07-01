package org.example.ee.bank.ejb.remote;

import jakarta.ejb.Local;

@Local
public interface TransferService {
    void transferAmount(String sourceAccountNo, String destinationAccountNo, double amount);
}
