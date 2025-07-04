package org.example.ee.jersey.model;

import jakarta.enterprise.context.ApplicationScoped;
import org.example.ee.jersey.annotation.UserBind;

@UserBind
public class User {

    private String name;
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
