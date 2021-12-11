<%-- 
    Document   : schedule_edit
    Created on : Dec 10, 2021, 7:36:34 PM
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
        <title>schedule_edit</title>
    </head>
    <body>
        <!-- header -->
        <nav class="navbar navbar-expand-md sticky-top" style="background-color: #EF7F1B;">
            <a class="navbar-brand" href="home" style="color: white;">Attendence Management</a>
            <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navb" aria-expanded="true">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div id="navb" class="navbar-collapse collapse hide">
                <ul class="nav navbar-nav ml-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="" style="color: white;"><span class="fas fa-user">Welcome: </span>${sessionScope.account.getDisplayName()}</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="../logout" style="color: white;"><span class="fas fa-sign-in-alt"></span>| Logout</a>
                    </li>
                </ul>
            </div>
        </nav>
        <div class="container" style="margin-top: 20px">
            <h4 style="color: #EF7F1B;text-align: center;padding-bottom: 10px;">EDIT SUBJECT</h4>
            <form action="edit" method="POST">
                <table class="table table-bordered">
                    <input type="hidden" name="scheduleID" value="${s.getScheduleID()}" />
                    <tr>
                        <td>Teacher Name: </td>
                        <td>
                            <select name="teacher">
                                <c:forEach items="${list_teacher}" var="t">
                                    <option value="${t.getTeacherID()}" ${t.getTeacherID() == s.getTeacherID().getTeacherID()?"selected":""}>${t.getTeacherName()}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Subject: </td>
                        <td>
                            <select name="subject">
                                <c:forEach items="${list_subject}" var="su">
                                    <option value="${su.getSubjectID()}" ${su.getSubjectID() == s.getSubjectID().getSubjectID()?"selected":""}>${su.getSubjectCode()} (${su.getSubjectName()})</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Class Name: </td>
                        <td>
                            <select name="class">
                                <c:forEach items="${list_class}" var="c">
                                    <option value="${c.getClassID()}" ${c.getClassID() == s.getClassID().getClassID()?"selected":""}>${c.getClassName()}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Date: </td>
                        <td><input type="date" name="date" value="${s.getScheduleDate()}" /></td>
                    </tr>
                    <tr>
                        <td>Time Slot: </td>
                        <td>
                            <select name="time">
                                <c:forEach items="${list_timeslot}" var="ts">
                                    <option value="${ts.getTimeSlotID()}" ${ts.getTimeSlotID() == s.getTimeSlotID().getTimeSlotID()?"selected":""}>${ts.getTimeSlotStart()} - ${ts.getTimeSlotEnd()}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>

                </table>
                <button type="submmit" class="btn" style="background-color: #EF7F1B;
                        margin-top: 15px;">Save</button>
            </form>

        </div>
    </body>
</html>
