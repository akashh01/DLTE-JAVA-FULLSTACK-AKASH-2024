<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Deposits Servlet Login page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

</head>
<body>
<!-- Login form -->
<form method="post" action="login">
    <div class="container login-container">
        <div class="row justify-content-center mt-5">
            <div class="col-lg-5 col-md-6 col-12 align-self-center p-5 rounded-5 shadow" id="loginCard">
                <div class="form-group">
                    <label for="username">Username</label>
                    <input type="text" id="username" name="username" class="form-control" placeholder="Username">
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input type="password" id="password" name="password" class="form-control" placeholder="Password">
                </div>
                <div class="mt-5 d-flex justify-content-around ">
                    <button id="loginButton" type="submit" class="col-4 btn login-button bi bi-box-arrow-in-right"> Login</button>
                    <button id="cancel" class="col-4 btn btn-secondary bi bi-x-circle-fill"> Cancel</button>
                </div>
            </div>
        </div>
        <!-- login form text -->
        <div class="row justify-content-center mt-5">
            <div class="col-lg-5 col-md-6 col-12">
                <h1 class="text-center text-white ">Login Form</h1>
            </div>
        </div>
    </div>
</form>


</body>
</html>