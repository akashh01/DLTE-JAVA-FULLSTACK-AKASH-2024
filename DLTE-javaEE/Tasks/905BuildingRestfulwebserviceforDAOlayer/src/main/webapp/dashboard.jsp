<%@ page import="application.db.Entities.Customer" %>
<%@ page import="application.db.Services.UserInfoServices" %>
<%@ page import="application.db.Middlewares.DatabaseTarget" %>
<%@ page import="application.db.Remotes.StorageTarget" %><%--
  Created by IntelliJ IDEA.
  User: xxjainne
  Date: 4/21/2024
  Time: 10:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
    <title>Title</title>
</head>
<body>
<%
    response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
    UserInfoServices userService;
    StorageTarget storageTarget = new DatabaseTarget();
    userService = new UserInfoServices(storageTarget);
    if (session.getAttribute("username") != null) {
        String username = (String) session.getAttribute("username");
        Customer account = userService.callOneUserDetails(username);
%>
<nav class="navbar navbar-expand-lg navbar-light" style="background-color:rgb(165, 138, 190);">
    <div class="container-fluid justify-content-between">
        <a class="navbar-brand" href="#">MYBANK</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <p class="text-light display-6">Hi, <%=session.getAttribute("username")%></p>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="#">Home</a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="newaccount.jsp">Create Account</a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="depositamount.jsp">Deposit Amount</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<div id="pageContent" class="container mt-3">
    <!-- Content of the selected page will be loaded here -->
    <div class="card">
        <div class="card-body">
            <h5 class="card-title">User Information</h5>
            <ul class="list-group list-group-flush">
                <li class="list-group-item">Name: <%= account.getUsername() %></li>
                <li class="list-group-item">Contact Number: <%= account.getContact() %></li>
                <li class="list-group-item">Balance: <%= account.getInitialBalace() %></li>
                <li class="list-group-item">Email: <%= account.getEmail() %></li>
            </ul>
        </div>
    </div>
</div>
<% } else {
    response.sendRedirect("index.jsp");
} %>
</body>
</html>
