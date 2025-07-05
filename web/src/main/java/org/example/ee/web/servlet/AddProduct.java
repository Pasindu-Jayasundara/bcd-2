package org.example.ee.web.servlet;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.HttpConstraint;
import jakarta.servlet.annotation.ServletSecurity;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.ee.core.model.Product;
import org.example.ee.core.service.ProductService;

import java.io.IOException;

@ServletSecurity(@HttpConstraint(rolesAllowed = {"SUPER_ADMIN","ADMIN"}))
@WebServlet("/admin/add_product")
public class AddProduct extends HttpServlet {

    @EJB
    private ProductService productService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("product_name");
        String desc = req.getParameter("product_desc");
        String price = req.getParameter("product_price");
        String qty = req.getParameter("product_qty");
        String category = req.getParameter("product_category");

        Product product = new Product(name,desc,Double.parseDouble(price),Double.parseDouble(qty),category);
        productService.addProduct(product);

        resp.sendRedirect(req.getContextPath()+"/index.jsp");
    }
}
