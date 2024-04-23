<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .login-container {
            margin-top: 100px;
        }
        .login-box {
            background-color: #f8f9fa;
            border-radius: 10px;
            padding: 20px;
            box-shadow: 0px 0px 10px 0px rgba(0,0,0,0.1);
        }
        .login-button {
            background-color: #6c757d;
            color: #fff;
            border: none;
            border-radius: 5px;
        }
        .login-button:hover {
            background-color: #5a6268;
        }
        #cancel {
            background-color: #6c757d;
            color: #fff;
            border: none;
            border-radius: 5px;
        }
        #cancel:hover {
            background-color: #5a6268;
        }
    </style>
</head>
<body>
<form method="post" action="login">
    <div class="container login-container">
        <div class="row justify-content-center">
            <div class="col-lg-4 col-md-6 col-sm-8 col-10">
                <div class="login-box">
                    <div class="mb-3">
                        <label for="username" class="form-label">Username</label>
                        <input type="text" id="username" name="username" class="form-control" placeholder="Username">
                    </div>
                    <div class="mb-3">
                        <label for="password" class="form-label">Password</label>
                        <input type="password" id="password" name="password" class="form-control" placeholder="Password">
                    </div>
                    <div class="row justify-content-around">
                        <button id="loginbutton" type="submit" class="col-4 btn login-button bi bi-box-arrow-in-right"> Login</button>
                        <button id="cancel" class="col-4 btn btn-secondary bi bi-x-circle-fill"> Cancel</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</form>
</body>
</html>