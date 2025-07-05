package org.example.ee.security;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.security.enterprise.AuthenticationException;
import jakarta.security.enterprise.AuthenticationStatus;
import jakarta.security.enterprise.authentication.mechanism.http.AutoApplySession;
import jakarta.security.enterprise.authentication.mechanism.http.HttpAuthenticationMechanism;
import jakarta.security.enterprise.authentication.mechanism.http.HttpMessageContext;
import jakarta.security.enterprise.credential.UsernamePasswordCredential;
import jakarta.security.enterprise.identitystore.CredentialValidationResult;
import jakarta.security.enterprise.identitystore.IdentityStore;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@AutoApplySession
@ApplicationScoped
public class AuthMechanism implements HttpAuthenticationMechanism {

    @Inject
    private IdentityStore identityStore;

    @Override
    public AuthenticationStatus validateRequest(HttpServletRequest request, HttpServletResponse response, HttpMessageContext context) throws AuthenticationException {

        System.out.println("auth mechanism validate request");

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if(username != null && password != null){
            // authenticate using username and password

            CredentialValidationResult result = identityStore.validate(new UsernamePasswordCredential(username, password));
            System.out.println(result.getStatus());

            if(result.getStatus() == CredentialValidationResult.Status.VALID){

                return context.notifyContainerAboutLogin(result);
            }else{

                try {
                    response.sendRedirect(request.getContextPath()+"/login.jsp");

                } catch (IOException e) {
                    e.printStackTrace();
                }
                return AuthenticationStatus.SEND_FAILURE;
            }
        }

        if(context.isProtected()){
            try {

                response.sendRedirect(request.getContextPath()+"/login.jsp");
                return AuthenticationStatus.SEND_CONTINUE;

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return context.doNothing();
    }
}
