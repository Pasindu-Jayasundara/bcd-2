<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 7/5/2025
  Time: 5:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>Login</h1>
<form method="post" action="${pageContext.request.contextPath}/login">
    <table>
        <tr>
            <th>Email: </th>
            <td><input type="email" name="email"/></td>
        </tr>
        <tr>
            <th>Password: </th>
            <td><input type="password" name="password"/></td>
        </tr>
        <tr>
            <td><input type="button" value="Login"/></td>
        </tr>
    </table>
</form>
</body>
</html>
