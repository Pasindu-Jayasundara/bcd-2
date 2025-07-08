package org.example.ee.core.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "users")
@NamedQueries({
        @NamedQuery(name = "User.findUserByEmail",query = "select u from User u where u.email =:email"),
        @NamedQuery(name = "User.findByEmailAndPassword",query = "select u from User u where u.email =:email and u.password =:password")
})
@Cacheable(value = false)
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String contact;
    @Column(unique = true)
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private UserType userType = UserType.USER;
    private String verificationCode;
    @Enumerated(EnumType.STRING)
    private Status status = Status.INACTIVE;

    public User() {
    }

    public User(String name, String contact, String email, String password, UserType userType, String verificationCode, Status status) {
        this.name = name;
        this.contact = contact;
        this.email = email;
        this.password = password;
        this.userType = userType;
        this.verificationCode = verificationCode;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
