package org.example.ee.web.servlet;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.ee.core.mail.VerificationMail;
import org.example.ee.core.model.Status;
import org.example.ee.core.model.User;
import org.example.ee.core.model.UserType;
import org.example.ee.core.provider.MailServiceProvider;
import org.example.ee.core.service.UserService;
import org.example.ee.core.util.Encryption;

import java.io.IOException;
import java.util.UUID;

@WebServlet("/register")
public class Register extends HttpServlet {

    @EJB
    private UserService userService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String contact = req.getParameter("contact");
        String password = req.getParameter("password");
        String encrypt = Encryption.encrypt(password);

        String verificationCode = UUID.randomUUID().toString();

        User user = new User(name,contact,email,encrypt, UserType.USER,verificationCode, Status.INACTIVE);
        userService.addUser(user);

        VerificationMail mail = new VerificationMail(email,verificationCode);
        MailServiceProvider.getInstance().sendEmail(mail);

        resp.sendRedirect(req.getContextPath()+"/login.jsp");

    }
}
