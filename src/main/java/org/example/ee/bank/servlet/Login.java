package org.example.ee.bank.servlet;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.ee.bank.ejb.remote.LoginService;

import java.io.IOException;

@WebServlet("/login")
public class Login extends HttpServlet {

    @EJB
    private LoginService loginService;
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("email");
        String password = req.getParameter("password");

        boolean login = loginService.login(email, password);
        if(login){
            HttpSession session = req.getSession();
            session.setAttribute("user",email);

            resp.sendRedirect("home.jsp");
        }else{
            resp.sendRedirect("login.jsp");
        }

    }
}
