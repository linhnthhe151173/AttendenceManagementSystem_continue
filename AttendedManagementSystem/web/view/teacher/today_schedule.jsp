<%-- 
    Document   : today_schedule
    Created on : Dec 6, 2021, 8:35:38 PM
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
        <title>today_schedule</title>
    </head>
    <body>
        <!-- header -->
        <nav class="navbar navbar-expand-md sticky-top" style="background-color: #EF7F1B;">
            <a class="navbar-brand" href="" style="color: white;">Attendence Management</a>
            <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navb" aria-expanded="true">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div id="navb" class="navbar-collapse collapse hide">
                <ul class="nav navbar-nav ml-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="profile?teacherID=${t.getTeacherID()}" style="color: white;"><span class="fas fa-user"></span>${sessionScope.account.getDisplayName()}</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="../logout" style="color: white;"><span class="fas fa-sign-in-alt"></span>| Logout</a>
                    </li>
                </ul>
            </div>
        </nav>

        <!-- Container -->
        <div class="container">
            <div class="row">
                <div class="col-md-3">
                    <p style="margin-top: 20px;
                       font-weight: bold;">Other's schedule</p>
                </div>
                <div class="col-md-9" style="text-align: center;">
                    <button type="button" class="btn" style="background-color: #EF7F1B;
                            margin-top: 15px;"><a href="other_schedule" style="color: white;
                         text-decoration: none;">Check</a></button>
                </div>
            </div>
            <hr>
            <div class="row">
                <div class="col-md-2">
                    <p style="margin-top: 20px;
                       font-weight: bold;">Today's schedule</p>
                </div>
                <div class="col-md-10" style="margin-top: 20px;">
                    <c:choose>
                        <c:when test="${list_schedule.size() == 0 || list_schedule == null}">
                            <!--time 2-->
                            <div>
                                <div style="text-align: center;">
                                    <h5 style="color: #EF7F1B;">Date: ${date}</h5> 
                                </div>
                                <div class="alert alert-warning" role="alert">
                                    You don't have a schedule today.
                                </div>

                            </div>
                        </c:when>

                        <c:otherwise>

                            <div style="margin-bottom: 40px;">
                                <div style="text-align: center;">
                                    <c:forEach items="${list_schedule}" var="s" varStatus="status">
                                        <c:if test="${status.last}"><h5 style="color: #EF7F1B;">Date: ${s.getScheduleDate()}</h5></c:if>
                                    </c:forEach>
                                </div>
                                <div>
                                    <table class="table">
                                        <thead>
                                            <tr>
                                                <th scope="col">STT</th>
                                                <th scope="col">Teacher</th>
                                                <th scope="col">Subject</th>
                                                <th scope="col">S_Name</th>
                                                <th scope="col">C_Name</th>
                                                <th scope="col">Time Slot</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${list_schedule}" var="s" varStatus="status">
                                                <tr>
                                                    <th scope="row">${status.count}</th>
                                                    <td>${s.getTeacherID().getTeacherName()}</td>
                                                    <td>${s.getSubjectID().getSubjectCode()}</td>
                                                    <td>${s.getSubjectID().getSubjectName()}</td>
                                                    <c:choose>
                                                        <c:when test="${scheduleID == s.getScheduleID()}">
                                                            <td><a href="../class_model/class_detail?ClassID=${s.getClassID().getClassID()}">${s.getClassID().getClassName()}</a></td>
                                                            </c:when>
                                                            <c:otherwise>
                                                            <td><a href="attendence?scheduleID=${s.getScheduleID()}&classID=${s.getClassID().getClassID()}">${s.getClassID().getClassName()}</a></td>
                                                            </c:otherwise>
                                                        </c:choose>
                                                    <td>${s.getTimeSlotID().getTimeSlotStart()} - ${s.getTimeSlotID().getTimeSlotEnd()}</td>

                                                </tr>
                                            </c:forEach>                                            
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </div>
    </body>
</html>
