package org.example.ee.ejb.bean;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example.ee.core.model.User;
import org.example.ee.core.service.UserService;

@Stateless
public class UserSessionBean implements UserService {

    @PersistenceContext
    private EntityManager em;

    @Override
    public User getUserById(Long id) {
        return em.find(User.class,id);
    }

    @Override
    public User getUserByEmail(String email) {
        return em.createNamedQuery("User.findUserByEmail", User.class)
                .setParameter("email",email)
                .getSingleResult();
    }

    @Override
    public void addUser(User user) {
        em.persist(user);
    }

    @Override
    public void updateUser(User user) {
        em.merge(user);
    }

    @Override
    public void removeUser(User user) {
        em.remove(user);
    }

    @Override
    public boolean validate(String email, String password) {

        User user = em.createNamedQuery("User.findByEmailAndPassword", User.class)
                .setParameter("email", email)
                .setParameter("password", password)
                .getSingleResult();

        return user != null;
    }
}
