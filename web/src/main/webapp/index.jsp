<%@ page import="javax.naming.NamingException" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="org.example.ee.core.service.ProductService" %>
<%@ page import="java.util.List" %>
<%@ page import="org.example.ee.core.model.Product" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>web index</h1>

<c:if test="${empty pageContext.request.userPrincipal}">

    <a href="${pageContext.request.contextPath}/register.jsp">Register</a>
    <a href="${pageContext.request.contextPath}/login.jsp">Login</a>

</c:if>
<c:if test="${not empty pageContext.request.userPrincipal}">
    <a href="${pageContext.request.contextPath}/logout">Login</a>
</c:if>

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
        </tr>
    </c:forEach>
</table>


</body>
</html>
