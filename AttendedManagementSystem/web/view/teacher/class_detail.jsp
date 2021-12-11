<%-- 
    Document   : class_detail
    Created on : Dec 7, 2021, 12:16:51 PM
    Author     : Linh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <title>class_detail</title>
    </head>
    <body>
        <!-- header -->
        <nav class="navbar navbar-expand-md sticky-top" style="background-color: #EF7F1B;margin-bottom: 20px;">
            <a class="navbar-brand" href="../teacher/other_schedule" style="color: white;">Attendence Management</a>
            <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navb" aria-expanded="true">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div id="navb" class="navbar-collapse collapse hide">
                <ul class="nav navbar-nav ml-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="" style="color: white;"><span class="fas fa-user"></span>${sessionScope.account.getDisplayName()}</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="../logout" style="color: white;"><span class="fas fa-sign-in-alt"></span>| Logout</a>
                    </li>
                </ul>
            </div>
        </nav>

        <!-- Container -->
        <div class="container">
            <div style="padding-top: 10px;">
                <h4 style="text-align: center;">Class name: <span style="color: #EF7F1B;">${c.getClassName()}</span></h4>   
            </div>
            <div style="margin-top: 20px;">
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th scope="col">STT</th>
                            <th scope="col">Image</th>
                            <th scope="col">Student Code</th>
                            <th scope="col">Email</th>
                            <th scope="col">Full Name</th>
                            <th scope="col">Date Of Birth</th>
                            <th scope="col">Gender</th>
                            <th scope="col">Address</th>
                            <th scope="col">Phone</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${students}" var="s" varStatus="status">
                            <tr>
                                <th scope="row">${status.count}</th>
                                <td><img src="../img/${s.getStudentImage()}" style="width: 100px;height: 100px;"></td>
                                <td>${s.getStudentID()}</td>
                                <td>${s.getStudentEmail()}</td>
                                <td>${s.getStudentName()}</td>
                                <td>${s.getStudentDOB()}</td>                            
                                <td>${s.isStudentGender() == "true" ? "Male":"Female"}</td>
                                <td>${s.getStudentAddress()}</td>
                                <td>${s.getStudentPhone()}</td>
                            </tr>
                        </c:forEach>                       
                    </tbody>
                </table>
            </div>
        </div>


        <!-- Footer -->
        <footer class="page-footer font-small blue" style="margin-top: 10px;">

            <!-- Copyright -->
            <div class="footer-copyright text-center py-3">© Powered by <span style="color: #EF7F1B;">Linhnthhe151173</span>
            </div>
            <!-- Copyright -->

        </footer>
        <!-- Footer -->
    </body>
</html>
