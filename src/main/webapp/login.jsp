<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 7/4/2025
  Time: 9:38 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Login</h1>

<form method="post" action="j_security_check">
    <table>
        <tr>
            <th>Username:</th>
            <td><input type="text" name="j_username"/></td>
        </tr>
        <tr>
            <th>Password:</th>
            <td><input type="password" name="j_password"/></td>
        </tr>
        <tr>
            <td><input type="button" value="Login"/></td>
        </tr>
    </table>
</form>
</body>
</html>
