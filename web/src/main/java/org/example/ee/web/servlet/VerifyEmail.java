package org.example.ee.web.servlet;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.ee.core.model.Status;
import org.example.ee.core.model.User;
import org.example.ee.core.service.UserService;

import java.io.IOException;
import java.util.Base64;

@WebServlet("/verify")
public class VerifyEmail extends HttpServlet {

    @EJB
    private UserService userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("id");
        String code = req.getParameter("vc");

        byte[] decode = Base64.getDecoder().decode(email);
        String decodeEmail = new String(decode);

        byte[] decode2 = Base64.getDecoder().decode(code);
        String decodeCode = new String(decode2);

        User user = userService.getUserByEmail(decodeEmail);
        if(user != null && user.getVerificationCode().equals(decodeCode)){

            user.setStatus(Status.ACTIVE);
            userService.updateUser(user);
        }

        resp.sendRedirect(req.getContextPath()+"/index.jsp");

    }
}
