package org.example.ee.web.servlet;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.ee.core.model.User;
import org.example.ee.core.service.UserService;

import java.io.IOException;

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

        User user = new User(name,email,contact,password);

        userService.addUser(user);

    }
}
