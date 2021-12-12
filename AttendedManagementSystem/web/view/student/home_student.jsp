<%-- 
    Document   : home_student
    Created on : Dec 7, 2021, 2:48:55 PM
    Author     : Linh
--%>

<%@page import="model.Attendence"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <title>home_student</title>
        <%
            ArrayList<Attendence> list_attendence = (ArrayList<Attendence>) request.getAttribute("list_attendence");
        %>
    </head>
    <body>
        <!-- header -->
        <nav class="navbar navbar-expand-md sticky-top" style="background-color: #EF7F1B;">
            <a class="navbar-brand" href="#" style="color: white;">Attendence Management</a>
            <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navb" aria-expanded="true">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div id="navb" class="navbar-collapse collapse hide">
                <ul class="nav navbar-nav ml-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="../student/profile_student" style="color: white;"><span class="fas fa-user">Welcome: </span>${sessionScope.account.getDisplayName()}</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="../logout" style="color: white;"><span class="fas fa-sign-in-alt"></span>| Logout</a>
                    </li>
                </ul>
            </div>
        </nav>

        <div class="container">
            <h5 style="color: #EF7F1B;margin-top: 20px;">Check your attended schedule with:</h5>
            <div class="row">
                <div class="col-md-2">
                    <table class="table table-hover">
                        <thead>
                        <th>Semester</th>
                        </thead>
                        <tbody>
                            <tr>
                                <td>${semester.getSemesterName()}</td>
                            </tr>
                        </tbody>
                    </table>

                </div>
                <div class="col-md-3" style="border-left: 1px solid black;">
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th scope="col">STT</th>
                                <th scope="col">Subject's Name</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${list_subject}" var="subject" varStatus="status">
                                <tr>
                                    <th scope="row">${status.count}</th>
                            <form action="home_student" method="POST">
                                <td>${subject.getSubjectCode()} <input type="hidden" name="subjectID" value="${subject.getSubjectID()}" /><input type="submit" value="Check" /></td>
                            </form>
                            </tr>
                        </c:forEach>                         
                        </tbody>
                    </table>
                </div>
                <%
                    if (list_attendence != null) {
                %>
                <div class="col-md-7"  style="border-left: 1px solid black;">
                    <h6>Lecture: ${teacher.getTeacherName()}</h6>
                    <table class="table table-hover">
                        <thead>
                        <th>STT</th>
                        <th>Date</th>
                        <th>Time Slot</th>
                        <th>Class Name</th>
                        <th>Attendance Status</th>
                        </thead>
                        <tbody>
                            <%
                                for (int i = 0; i < list_attendence.size(); i++) {
                            %>
                            <tr>
                                <td>${sta.count} <%=i + 1%></td>
                                <td><%=list_attendence.get(i).getAttendenceDate()%></td>
                                <td><%=list_attendence.get(i).getScheduleID().getTimeSlotID().getTimeSlotStart()%> - <%=list_attendence.get(i).getScheduleID().getTimeSlotID().getTimeSlotEnd()%></td>
                                <td><%=list_attendence.get(i).getScheduleID().getClassID().getClassName()%></td>
                                <td><%=list_attendence.get(i).isPresent() ? "Present" : "Absent"%></td>
                            </tr>
                            <%
                                }
                            %>
                        </tbody>
                    </table>

                </div>
                <%
                } else {
                %>
                <div class="col-md-7"  style="border-left: 1px solid black;">
                    <div class="alert alert-warning" role="alert" cla>
                        No attendence
                    </div>
                </div>

                <%
                    }
                %>
            </div>
        </div>
    </body>
</html>
