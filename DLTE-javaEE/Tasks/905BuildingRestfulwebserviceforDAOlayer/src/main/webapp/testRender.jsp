<%@ page import="application.db.Entities.Customer" %><%--
  Created by IntelliJ IDEA.
  User: xxnlnnpa
  Date: 3/21/2024
  Time: 10:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CustomerDetails</title>
</head>
<body>
<h3 >Customer Details</h3>
<table border="2" >
    <tr>
    <th>Customer name</th>
    <th>Email</th>
    <th>Initial Balance</th>
    <th>Address</th>
    <th>Contact</th>
    </tr>
<%Customer customerOne=(Customer) request.getAttribute("customer");%>
    <tr>
        <td><%=customerOne.getUsername()%></td>
        <td><%=customerOne.getEmail()%></td>
        <td><%=customerOne.getInitialBalace()%></td>
        <td><%=customerOne.getAddress()%></td>
        <td><%=customerOne.getContact()%></td>
    </tr>
</table>
</body>
</html>
