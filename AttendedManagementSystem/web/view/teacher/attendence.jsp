<%-- 
    Document   : attendence
    Created on : Dec 4, 2021, 3:21:36 PM
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
        <title>attendece</title>
    </head>
    <body>
        <!-- header -->
        <nav class="navbar navbar-expand-md sticky-top" style="background-color: #EF7F1B;">
            <a class="navbar-brand" href="today_schedule" style="color: white;">Attendence Management</a>
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
            <div>
                <button type="button" class="btn" style="background-color: #EF7F1B;
                        margin-top: 20px;"><a href="today_schedule" style="color: white;
                     text-decoration: none;">Back</a></button>
            </div>
            <form action="attendence" method="POST">
                <div class="row justify-content-center">
                    <div style="width: 400px;
                         height: 200px;
                         text-align: center;
                         margin-top: 20px;">
                        <input type="hidden" name="scheduleID" value="${s.getScheduleID()}" />
                        <table class="table table-bordered">
                            <tr>
                                <th scope="row">Subject: </th>
                                <td>${s.getSubjectID().getSubjectCode()}</td>
                            </tr>
                            <tr>
                                <th scope="row">Class: </th>
                                <td>${s.getClassID().getClassName()}</td>
                            </tr>
                            <tr>
                                <th scope="row">Date: </th>
                                <td>${s.getScheduleDate()}</td>
                            </tr>
                            <tr>
                                <th scope="row">Time slot: </th>
                                <td>${s.getTimeSlotID().getTimeSlotStart()} - ${s.getTimeSlotID().getTimeSlotEnd()}</td>
                            </tr>
                        </table>
                    </div>   
                </div>
                <div style="margin-top: 20px;">
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th scope="col">STT</th>
                                <th scope="col">Image</th>
                                <th scope="col">Email</th>
                                <th scope="col">Student Code</th>
                                <th scope="col">Full Name</th>
                                <th scope="col">Attendance</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${students}" var="s" varStatus="status">
                                <tr>
                            <input type="hidden" name="studentID" value="${s.getStudentID()}" />
                            <th scope="row">${status.count}</th>
                            <td><img src="../img/${s.getStudentImage()}" style="width: 100px;height: 100px;"></td>
                            <td>${s.getStudentEmail()}</td>
                            <td>${s.getStudentID()}</td>
                            <td>${s.getStudentName()}</td>
                            <td><input type="radio" name="attendence${s.getStudentID()}" value="true"/><span style="color: green;">Present</span> 
                                <input type="radio" name="attendence${s.getStudentID()}" value="false" checked="checked"/><span style="color: red;">Absent</span> </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div class="col text-center">
                    <button type="submit" class="btn" style="background-color: #EF7F1B;
                            color: white;">Submit</button>
                </div>
            </form>
            <!-- Footer -->
            <footer class="page-footer font-small blue" style="margin-top: 10px;">

                <!-- Copyright -->
                <div class="footer-copyright text-center py-3">© Powered by <span style="color: #EF7F1B;">Linhnthhe151173</span>
                </div>
                <!-- Copyright -->

            </footer>
            <!-- Footer -->
        </div>
    </body>
</html>
