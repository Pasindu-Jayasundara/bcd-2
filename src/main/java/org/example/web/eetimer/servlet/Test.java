package org.example.web.eetimer.servlet;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.web.eetimer.ejb.TaskSessionBean;
import org.example.web.eetimer.ejb.TimerSessionBean;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@WebServlet("/test")
public class Test extends HttpServlet {

    //@EJB
    //TaskSessionBean session;

    @EJB
    TimerSessionBean session;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        session.doTask();

//        Future<String> doTask = session.doTask();
//        try {
//
//            String s = doTask.get();
//            resp.getWriter().println(s);
//
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        } catch (ExecutionException e) {
//            throw new RuntimeException(e);
//        }
    }
}
