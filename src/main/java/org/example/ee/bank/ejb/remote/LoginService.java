package org.example.ee.bank.ejb.remote;

import jakarta.ejb.Local;

@Local
public interface LoginService {
    boolean login(String email, String password);
}
