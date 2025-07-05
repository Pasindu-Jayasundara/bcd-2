package org.example.ee.core.service;

import jakarta.ejb.Remote;
import org.example.ee.core.model.User;

@Remote
public interface UserService {

    User getUserById(Long id);
    User getUserByEmail(String email);
    void addUser(User user);
    void updateUser(User user);
    void removeUser(User user);
    boolean validate(String email, String password);
}
