package org.example.ee.bank.ejb;

import jakarta.ejb.Stateless;
import jakarta.ejb.TransactionAttribute;
import jakarta.ejb.TransactionAttributeType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import org.example.ee.bank.ejb.remote.AccountService;
import org.example.ee.bank.entity.Account;

@Stateless
public class AccountServiceBean implements AccountService {

    @PersistenceContext(unitName = "BankPU")
    private EntityManager em;

    @Override
    @TransactionAttribute(TransactionAttributeType.MANDATORY)
    public void creditToAccount(String accountNo, double amount) {

        try {

            Account account = em.createNamedQuery("Account.findByAccountNo", Account.class)
                    .setParameter("accountNo", accountNo)
                    .getSingleResult();

            if(amount > 0){
                account.setBalance(account.getBalance()+amount);
                em.merge(account);
            }

        }catch (NoResultException e){
            e.printStackTrace();
        }

    }

    @Override
    @TransactionAttribute(TransactionAttributeType.MANDATORY)
    public void debitFromAccount(String accountNo, double amount) {

        try {

            Account account = em.createNamedQuery("Account.findByAccountNo", Account.class)
                    .setParameter("accountNo", accountNo)
                    .getSingleResult();

            if(amount <= account.getBalance()){
                account.setBalance(account.getBalance()-amount);
                em.merge(account);
            }

        }catch (NoResultException e){
            e.printStackTrace();
        }
    }
}
