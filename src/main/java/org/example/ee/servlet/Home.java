package org.example.ee.servlet;

import jakarta.persistence.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/home")
public class Home extends HttpServlet {

    @PersistenceContext(unitName = "JTAPU")
    EntityManager em;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JTAPU");
//        EntityManager em = emf.createEntityManager();

        Query query = em.createNativeQuery("select * from user");
        List<Object[]> list = query.getResultList();

        list.forEach(row ->{
            System.out.println(row[0]+" "+row[1]+" "+row[2]);
        });

    }
}
