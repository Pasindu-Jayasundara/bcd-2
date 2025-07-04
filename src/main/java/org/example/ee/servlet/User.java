package org.example.ee.servlet;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.ee.ejb.UserSessionBean;

import java.io.IOException;

@WebServlet(urlPatterns = {"/user"})
public class User extends HttpServlet {

    @EJB
    private UserSessionBean userSessionBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        userSessionBean.method1();
        userSessionBean.method2();
        userSessionBean.method3();
        userSessionBean.method4();
        userSessionBean.method5();
    }
}
