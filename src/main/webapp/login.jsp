<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 7/5/2025
  Time: 1:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form method="post" action="${pageContext.request.contextPath}/login">
  <table>
    <tr>
      <th>Username: </th>
      <td><input type="text" name="username"></td>
    </tr>
    <tr>
      <th>Password: </th>
      <td><input type="password" name="password"></td>
    </tr>
    <tr>
      <th>Username: </th>
      <td><input type="button" name="Login"></td>
    </tr>
  </table>
</form>
</body>
</html>
