package org.example.ee.web.servlet;

import jakarta.inject.Inject;
import jakarta.security.enterprise.AuthenticationStatus;
import jakarta.security.enterprise.SecurityContext;
import jakarta.security.enterprise.authentication.mechanism.http.AuthenticationParameters;
import jakarta.security.enterprise.credential.UsernamePasswordCredential;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.eclipse.tags.shaded.org.apache.bcel.verifier.exc.LoadingException;
import org.example.ee.core.exception.LoginFailedException;
import org.example.ee.core.util.Encryption;

import java.io.IOException;

@WebServlet("/login")
public class Login extends HttpServlet {

    @Inject
    private SecurityContext securityContext;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String encrypt = Encryption.encrypt(password);

        AuthenticationParameters credential = AuthenticationParameters.withParams()
                .credential(new UsernamePasswordCredential(email, encrypt));

        AuthenticationStatus status = securityContext.authenticate(req, resp, credential);
        if(status == AuthenticationStatus.SUCCESS){
            resp.sendRedirect(req.getContextPath()+"/index.jsp");
        }else{
            //resp.sendRedirect(req.getContextPath()+"/login.jsp");
            throw new LoginFailedException("Invalid Username or Password");
        }
    }
}
