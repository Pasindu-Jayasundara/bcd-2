
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JTA BANK | Account</title>
</head>
<body>

<ht>Hello, ${sessionScope.user}</ht>

<form action="transfer" method="post">
    <table>
        <tr>
            <th>Source Account No</th>
            <td><input type="text" name="sourceAccountNo"/></td>
        </tr>
        <tr>
            <th>Destination Account No</th>
            <td><input type="text" name="destinationAccountNo"/></td>
        </tr>
        <tr>
            <th>Ammount</th>
            <td><input type="text" name="amount"/></td>
        </tr>
        <tr>
            <th></th>
            <td><input type="button" name="Transfer"/></td>
        </tr>
    </table>
</form>
</body>
</html>
