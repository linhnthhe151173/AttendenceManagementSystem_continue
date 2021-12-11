<%-- 
    Document   : submitted_attendence
    Created on : Dec 7, 2021, 2:07:13 PM
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
        <title>submitted_attendence</title>
    </head>
    <body>
        <!-- header -->
        <nav class="navbar navbar-expand-md sticky-top" style="background-color: #EF7F1B;">
            <c:forEach items="${list_attendence}" var="a" varStatus="status">
                <c:if test="${status.last}">
                    <a class="navbar-brand" href="today_schedule" style="color: white;">Attendence Management</a>

                </c:if>
            </c:forEach>
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


        <div class="container">
            <div style="padding-top: 20px;">
                <h5>Detail: </h5>
                <c:forEach items="${list_attendence}" var="a" varStatus="status">
                    <c:if test="${status.last}">
                        <span>[<span style="font-weight: bold;">Class:</span> ${a.getScheduleID().getClassID().getClassName()}, <span style="font-weight: bold;">Subject's Code:</span> ${a.getScheduleID().getSubjectID().getSubjectCode()}, <span style="font-weight: bold;">Attended Date:</span> ${a.getAttendenceDate()}]</span>

                    </c:if>
                </c:forEach>

            </div>
            <hr>
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
                            <th scope="col">Edit</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${list_attendence}" var="a" varStatus="status">
                            <tr>
                                <th scope="row">${status.count}</th>
                                <td><img src="../img/${a.getStudentID().getStudentImage()}" style="width: 100px;height: 100px;"></td>
                                <td>${a.getStudentID().getStudentEmail()}</td>
                                <td>${a.getStudentID().getStudentID()}</td>
                                <td>${a.getStudentID().getStudentName()}</td>
                                <td>
                                    <c:choose>
                                        <c:when test="${a.isPresent() == true}">
                                            <span style="color: green;">Present</span>
                                        </c:when>
                                        <c:otherwise>
                                            <span style="color: red;">Absent</span>
                                        </c:otherwise>
                                    </c:choose>
                                </td>
                                <td><a href="edit?studentID=${a.getStudentID().getStudentID()}&scheduleID=${a.getScheduleID().getScheduleID()}">Edit</a></td>
                            </tr>
                        </c:forEach>                        
                    </tbody>
                </table>
            </div>
            <div class="col-md-12" style="text-align: center;">
                <c:forEach items="${list_attendence}" var="a" varStatus="status">
                    <c:if test="${status.last}">
                        <button type="button" class="btn" style="background-color: #EF7F1B;
                                margin-top: 15px;"><a href="today_schedule" style="color: white;
                             text-decoration: none;">Check</a></button>
                        </c:if>

                </c:forEach>

            </div>
        </div>

    </body>
</html>
