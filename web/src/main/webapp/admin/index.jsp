<%@ page import="javax.naming.InitialContext" %>
<%@ page import="org.example.ee.core.service.ProductService" %>
<%@ page import="org.example.ee.core.model.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="javax.naming.NamingException" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin | Dashboard</title>
</head>
<body>

<h1>Hello Admin, ${pageContext.request.userPrincipal.name}</h1>

<h2>Add Product</h2>
<a href="${pageContext.request.contextPath}/admin/add_product.jsp">Register</a>

<h2>All Product</h2>

<%
    try{

        InitialContext ic = new InitialContext();
        ProductService productService = (ProductService) ic.lookup("jndi name from console server log");

        List<Product> products = productService.getAllProducts();
        pageContext.setAttribute("products",products);

    }catch (NamingException e){
        e.printStackTrace();
    }
%>

<table>
    <tr>
        <th>Product</th>
    </tr>
    <c:forEach var="product" items="${products}">
        <tr>
            <td>${product.name}</td>
            <td>
                <a href="${pageContext.request.contextPath}/admin/delete_product?pid=${product.id}">Delete Product</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
