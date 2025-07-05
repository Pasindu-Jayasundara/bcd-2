package org.example.ee.security.security;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.security.enterprise.AuthenticationException;
import jakarta.security.enterprise.AuthenticationStatus;
import jakarta.security.enterprise.authentication.mechanism.http.AuthenticationParameters;
import jakarta.security.enterprise.authentication.mechanism.http.AutoApplySession;
import jakarta.security.enterprise.authentication.mechanism.http.HttpAuthenticationMechanism;
import jakarta.security.enterprise.authentication.mechanism.http.HttpMessageContext;
import jakarta.security.enterprise.identitystore.CredentialValidationResult;
import jakarta.security.enterprise.identitystore.IdentityStore;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.Set;

@AutoApplySession
@ApplicationScoped
public class AuthMechanism implements HttpAuthenticationMechanism {

    @Inject
    private IdentityStore identityStore;

    private static final Set<String> WHITE_LIST = Set.of(
            "/login",
            "/register",
            "/auth/login",
            "/auth/register",
            "/public",
            "/"
    );

    private boolean isWhitelisted(String path){
        //return WHITE_LIST.stream().anyMatch(whiteListed -> whiteListed.startsWith(path));
        return WHITE_LIST.stream().anyMatch(path::startsWith);
    }

    @Override
    public AuthenticationStatus validateRequest(HttpServletRequest request, HttpServletResponse response, HttpMessageContext context) throws AuthenticationException {

        String path = request.getServletPath();
        System.out.println(path);

        if(isWhitelisted(path)){ // no authentication needed
            return context.doNothing();
        }

        // check credentials in db
        AuthenticationParameters authParameters = context.getAuthParameters();
        if(authParameters.getCredential() != null){

            CredentialValidationResult result = identityStore.validate(authParameters.getCredential());
            if(result.getStatus() == CredentialValidationResult.Status.VALID){
                return context.notifyContainerAboutLogin(result); // can log now based on roles
            }else{
                return AuthenticationStatus.SEND_FAILURE;
            }
        }

        // if requesting to a protected route -> continue to authorization
        if(context.isProtected()){
            return AuthenticationStatus.SEND_CONTINUE;
        }

        return context.responseUnauthorized();
    }
}
