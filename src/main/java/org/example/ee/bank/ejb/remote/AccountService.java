package org.example.ee.bank.ejb.remote;

import jakarta.ejb.Local;

@Local
public interface AccountService {
    void creditToAccount(String accountNo, double amount);
    void debitFromAccount(String accountNo, double amount);
}
