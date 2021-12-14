<%-- 
    Document   : other_schedule
    Created on : Dec 7, 2021, 12:04:27 PM
    Author     : Linh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <title>other_schedule</title>
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
                <button type="button" class="btn" style="background-color: #EF7F1B;margin-top: 20px;"><a href="today_schedule" style="color: white;
                                                                                                         text-decoration: none;">Back</a></button>
            </div>
            <div class="row">
                <div class="col-md-3">
                    <h6 style="margin-top: 20px;">Find attendance 's schedule </h6>
                    <form action="other_schedule" style="display: flex;" method="POST">
                        <input type="date" name="search_date" value="${search_date}" style="border-radius: 5px;"/>
                        <input type="submit" style="background-color: #EF7F1B;
                               border: none;" value="Search">
                    </form>
                </div>
                <div class="col-md-9" style="margin-top: 20px;">
                    <c:choose>
                        <c:when test="${search_date == null}">
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th scope="col">STT</th>
                                        <th scope="col">Subject's Code</th>
                                        <th scope="col">Class's Name</th>
                                        <th scope="col">Time Slot</th>
                                        <th scope="col">Date</th>
                                        <th scope="col">Edit</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${list_schedule_all}" var="sa" varStatus="status">
                                        <tr>
                                            <th scope="row">${status.count}</th>
                                            <td>${sa.getSubjectID().getSubjectCode()}</td>
                                            <c:choose>
                                                <c:when test="${sa.getScheduleDate() < date }">
                                                    <td><a href="../attendence/attendence_detail?scheduleID=${sa.getScheduleID()}">${sa.getClassID().getClassName()}</a></td>
                                                    </c:when>
                                                    <c:otherwise>
                                                    <td><a href="../class_model/class_detail?ClassID=${sa.getClassID().getClassID()}">${sa.getClassID().getClassName()}</a></td>
                                                    </c:otherwise>
                                                </c:choose>
                                            <td>${sa.getTimeSlotID().getTimeSlotStart()} - ${sa.getTimeSlotID().getTimeSlotEnd()}</td>
                                            <td>${sa.getScheduleDate()}</td>
                                            <c:choose>
                                                <c:when test="${sa.getScheduleDate() < date }">
                                                    <td><a href="../attendence/edit?scheduleID=${sa.getScheduleID()}">Edit</a></td>
                                                </c:when>
                                                <c:otherwise>
                                                    <td>No edit</td>
                                                </c:otherwise>
                                            </c:choose>
                                        </tr>
                                    </c:forEach>

                                </tbody>
                            </table>

                        </c:when>
                        <c:otherwise>
                            <c:choose>
                                <c:when test="${list_schedule.size() == 0 || list_schedule == null}">
                                    <!--time 2-->
                                    <div>
                                        <div class="alert alert-warning" role="alert">
                                            No schedule yet
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
                                                        <th scope="col">Subject's Code</th>
                                                        <th scope="col">Subject's Name</th>
                                                        <th scope="col">Class's Name</th>
                                                        <th scope="col">Time Slot</th>
                                                        <th scope="col">Edit</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <c:forEach items="${list_schedule}" var="s" varStatus="status">
                                                        <tr>
                                                            <th scope="row">${status.count}</th>
                                                            <td>${s.getSubjectID().getSubjectCode()}</td>
                                                            <td>${s.getSubjectID().getSubjectName()}</td>
                                                            <c:choose>
                                                                <c:when test="${s.getScheduleDate() < date }">
                                                                    <td><a href="../attendence/attendence_detail?scheduleID=${s.getScheduleID()}">${s.getClassID().getClassName()}</a></td>
                                                                    </c:when>
                                                                    <c:otherwise>
                                                                    <td><a href="../class_model/class_detail?ClassID=${s.getClassID().getClassID()}">${s.getClassID().getClassName()}</a></td>
                                                                    </c:otherwise>
                                                                </c:choose>

                                                            <td>${s.getTimeSlotID().getTimeSlotStart()} - ${s.getTimeSlotID().getTimeSlotEnd()}</td>
                                                            <c:choose>
                                                                <c:when test="${s.getScheduleDate() < date}">
                                                                    <td><a href="../attendence/edit?scheduleID=${s.getScheduleID()}">Edit</a></a></td>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <td>No edit</td>
                                                                </c:otherwise>
                                                            </c:choose>
                                                        </tr>
                                                    </c:forEach>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </c:otherwise>
                            </c:choose>
                        </c:otherwise>
                    </c:choose>

                </div>
            </div>
        </div>
    </body>
</html>
