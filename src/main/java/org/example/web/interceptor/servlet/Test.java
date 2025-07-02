package org.example.web.interceptor.servlet;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.web.interceptor.ejb.UserSessionBean;

import java.io.IOException;

@WebServlet("/test")
public class Test extends HttpServlet {

    @EJB
    UserSessionBean userSessionBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        userSessionBean.doAction();
    }
}
