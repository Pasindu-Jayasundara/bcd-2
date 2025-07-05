package org.example.ee.core.service;

import jakarta.ejb.Remote;
import org.example.ee.core.model.User;

@Remote
public interface UserSession {

    User getUserById(Long id);
    User getUserByEmail(String email);
    void addUser(User user);
    void updateUser(User user);
    void removeUser(User user);
}
