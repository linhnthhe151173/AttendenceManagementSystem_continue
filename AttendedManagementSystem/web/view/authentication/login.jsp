<%-- 
    Document   : login
    Created on : Dec 4, 2021, 10:35:31 AM
    Author     : Linh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="css/login_style.css">
        <title>login</title>
    </head>
    <body>
        <!-- header -->
        <nav class="navbar">
            <a class="navbar-brand" href="login">Attendence Management System</a>
        </nav>

        <!-- Container -->
        <div class="container">
            <div class="row">
                <div class="col-md-6">
                    <img src="img/login.jpg" class="img-fluid" alt="Responsive image" style="margin-top: 50px;">
                </div>
                <div class="col-md-6"">
                    <form action="login" method="post">
                        <div class="imgcontainer">
                            <img src="img/avatar.png" alt="Avatar" class="avatar" style="width: 100px;height: 100px;">
                        </div>
                        <form action="login" method="POST">
                            <div class="container">
                                <label for="uname"><b>Username</b></label>
                                <input type="text" placeholder="Enter Username" name="username" required>

                                <label for="psw"><b>Password</b></label>
                                <input type="password" placeholder="Enter Password" name="password" required>

                                <button type="submit">Login</button>
                                <label>
                                    <input type="checkbox" checked="checked" name="remember"> Remember me
                                </label>
                            </div>
                        </form>

                        <div class="container" style="background-color:#f1f1f1;display: flex;">
                            <div>
                                <span class="psw">Forgot <a href="#">password?</a></span>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
