package org.example.ee.bank.ejb;

import jakarta.ejb.*;
import jakarta.inject.Inject;
import jakarta.transaction.SystemException;
import jakarta.transaction.UserTransaction;
import org.example.ee.bank.ejb.remote.TransferService;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class TransferServiceBean implements TransferService {

    @EJB
    private AccountServiceBean accountService;

    @Inject
    private UserTransaction userTransaction;

    @Override
    //@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void transferAmount(String sourceAccountNo, String destinationAccountNo, double amount) {

        try{

            userTransaction.begin();

            accountService.debitFromAccount(sourceAccountNo,amount);
            accountService.creditToAccount(destinationAccountNo,amount);

            userTransaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            try {
                userTransaction.rollback();
            } catch (SystemException ex) {
                e.printStackTrace();
            }
        }

    }
}
