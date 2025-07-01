package org.example.ee.bank.ejb;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import org.example.ee.bank.ejb.remote.LoginService;
import org.example.ee.bank.entity.User;

@Stateless
public class LoginServiceBean implements LoginService {

    @PersistenceContext(unitName = "BankPU")
    private EntityManager em;

    @Override
    public boolean login(String email, String password) {

        try{
            User user = em.createNamedQuery("User.findByEmailAndPassword", User.class)
                    .setParameter("email", email)
                    .setParameter("password", password)
                    .getSingleResult();

            return true;
        }catch (NoResultException e){
            return false;
        }

    }
}
