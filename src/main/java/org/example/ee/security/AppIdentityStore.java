package org.example.ee.security;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.security.enterprise.credential.Credential;
import jakarta.security.enterprise.credential.UsernamePasswordCredential;
import jakarta.security.enterprise.identitystore.CredentialValidationResult;
import jakarta.security.enterprise.identitystore.IdentityStore;
import org.example.ee.model.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@ApplicationScoped
public class AppIdentityStore implements IdentityStore {

    private static final Map<String, User> USERS = new HashMap<>();

    static {
        USERS.put("pasindu",new User("1234", Set.of("ADMIN")));
        USERS.put("kamal",new User("1234", Set.of("ADMIN","USER")));
        USERS.put("nimal",new User("1234", Set.of("USER")));
    }

    @Override
    public CredentialValidationResult validate(Credential credential) {
        System.out.println("app identity store ...");

        if(credential instanceof UsernamePasswordCredential){

            UsernamePasswordCredential upc = (UsernamePasswordCredential) credential;
            User user = USERS.get(upc.getCaller());

            if(user != null && user.getPassword().equals(upc.getPasswordAsString())){

                return new CredentialValidationResult(upc.getCaller(), user.getRoles());//authentication, authorization
            }
        }

        return CredentialValidationResult.INVALID_RESULT;
    }
}
