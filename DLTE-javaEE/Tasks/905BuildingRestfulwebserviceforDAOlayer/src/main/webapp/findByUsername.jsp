<%--
  Created by IntelliJ IDEA.
  User: xxnlnnpa
  Date: 4/23/2024
  Time: 5:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="application.db.Services.UserInfoServices" %>
<%@ page import="application.db.Remotes.StorageTarget" %>
<%@ page import="application.db.Middlewares.DatabaseTarget" %>
<%@page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>find By Username</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
</head>
<body>
<% response.setHeader("Cache-Control","no-cache,no store,must-revalidate");
    UserInfoServices userInfoServices;
    StorageTarget storageTarget = new DatabaseTarget();
    userInfoServices = new UserInfoServices(storageTarget);
    if(session.getAttribute("username")!=null){%>
<nav class="navbar navbar-expand-lg" style="background:linear-gradient(90deg,white,red);">
    <div class="container-fluid">
        <!-- 1st logo/ brand -->
        <a class="navbar-brand text-danger display-6 text-uppercase" style="font-weight: bold;" href="#">MyBank</a>
        <!-- 2nd toggle a -->
        <a class="navbar-toggler bg-light" type="a" data-bs-toggle="collapse" data-bs-target="#myBankMenu">
            <span class="navbar-toggler-icon"></span>
        </a>
        <!-- 3rd Menu -->
        <div class="collapse navbar-collapse" id="myBankMenu">
            <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a href="view" class="btn btn-outline-light rounded-5 me-2"><span class="bi bi-list-columns"></span> View</a>
                </li>
                <li class="nav-item">
                    <a href="create.jsp" class="btn btn-outline-light rounded-5 me-2"><span class="bi bi-credit-card"></span> Create account</a>
                </li>
                <li class="nav-item">
                    <a href="findByUsername.jsp" class="btn btn-outline-light rounded-5 me-2"><span class="bi bi-cloud-plus-fill"></span> find by username</a>
                </li>
                <li class="nav-item">
                    <a href="logout" class="btn btn-outline-light rounded-5 me-2"><span class="bi bi-door-open"></span> Logout</a>
                </li>
                <li>
                    <form action="viewByUser.jsp">
                        <input type="text" name="username" />
                        <input type="submit" value="filter">
                    </form>
                </li>
            </ul>
        </div>
    </div>
</nav>
<%
    String info = (String) request.getAttribute("info");
%>
<div class="container">
    <% if(info!=null && !info.isEmpty()){%>
    <h1 class="text-center text-success"><%=info%></h1>
    <% }%>
    <h1>Find By Username</h1>
    <form action="findUsername">
        <div class="mb-3">
            <label for="username" class="form-label">Enter the Username</label>
            <input type="text" id="username" name="username" class="form-control" required>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>
<%@ taglib prefix="sqlJstl" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="coreJstl" uri="http://java.sun.com/jsp/jstl/core" %>
<sqlJstl:setDataSource var="driverSource" driver="oracle.jdbc.driver.OracleDriver"
                       url="jdbc:oracle:thin:@localhost:1521:xe"
                       user="system"
                       password="admin"
/>
<sqlJstl:query var="limit" dataSource="${driverSource}"
               sql="select * from my_bank where username=?">
    <sqlJstl:param value="${param['username']}"/>
</sqlJstl:query>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-lg-4 col-md-8 col-12 table-responsive p-5 shadow-lg">
            <table class="table table-striped text-nowrap">
                <thead>
                <tr>
                    <th>Username</th>
                    <th>Password</th>
                    <th>Address</th>
                    <th>Email</th>
                    <th>Contact</th>
                    <th>Initial Balance</th>
                </tr>
                </thead>
                <tbody>
                <coreJstl:forEach items="${limit.rows}" var="data">
                    <tr>
                        <td>${data.username}</td>
                        <td>${data.password}</td>
                        <td>${data.address}</td>
                        <td>${data.email}</td>
                        <td>${data.contact}</td>
                        <td>${data.initialbalance}</td>

                    </tr>
                </coreJstl:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<% } else {
    response.sendRedirect("index.jsp");
} %>
</body>
</html>