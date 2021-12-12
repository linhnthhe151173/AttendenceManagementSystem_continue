<%-- 
    Document   : schedule_detail
    Created on : Dec 10, 2021, 12:56:55 PM
    Author     : Linh
--%>

<%@page import="model.Schedule"%>
<%@page import="model.Schedule"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <title>schedule_detail</title>
        <%
            String search = (String) request.getAttribute("search");
            ArrayList<Schedule> list_search = (ArrayList<Schedule>) request.getAttribute("list_search");
        %>
    </head>
    <body>
        <!-- header -->
        <nav class="navbar navbar-expand-md sticky-top" style="background-color: #EF7F1B;">
            <a class="navbar-brand" href="../home" style="color: white;">Attendence Management</a>
            <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navb" aria-expanded="true">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div id="navb" class="navbar-collapse collapse hide">
                <ul class="nav navbar-nav ml-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="" style="color: white;"><span class="fas fa-user">Welcome: </span>${sessionScope.account.getDisplayName()}</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="" style="color: white;"><span class="fas fa-sign-in-alt"></span>| Logout</a>
                    </li>
                </ul>
            </div>
        </nav>

        <div class="container">
            <!-- Search form -->
            <form action="schedule_detail" method="POST">
                <div style="display: flex;margin-top: 20px;">
                    <input class="form-control" type="date" name="search" placeholder="Search" aria-label="Search">
                    <input type="submit" style="background-color: #EF7F1B;
                           border: none;" value="Search">
                </div>
            </form>

            <h4 style="text-align: center;
                margin-top: 20px;
                font-weight: bold;
                color: #EF7F1B;">SCHEDULE DETAIL</h4>
            <hr>
            <%
                if (search == null) {
            %>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th scope="col">STT</th>
                        <th scope="col">Teacher</th>
                        <th scope="col">Subject</th>
                        <th scope="col">Class</th>
                        <th scope="col">Date</th>
                        <th scope="col">Time Slot</th>
                        <th scope="col">Edit</th>
                        <th scope="col">Remove</th>
                    </tr>

                </thead>
                <tbody>
                    <c:forEach items="${list}" var="i" varStatus="status">
                        <tr>
                            <td>${status.count}</td>
                            <td>${i.getTeacherID().getTeacherName()}</td>
                            <td>${i.getSubjectID().getSubjectCode()}</td>
                            <td>${i.getClassID().getClassName()}</td>
                            <td>${i.getScheduleDate()}</td>
                            <td>${i.getTimeSlotID().getTimeSlotStart()} - ${i.getTimeSlotID().getTimeSlotEnd()}</td>
                            <td><a href="schedule/edit?scheduleID=${i.getScheduleID()}">Edit</a></td>
                            <td><a href="schedule/remove?scheduleID=${i.getScheduleID()}">Remove</a></td>
                        </tr>
                    </c:forEach>

                </tbody>
            </table>
            <%
            } else {
            %>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th scope="col">STT</th>
                        <th scope="col">Teacher</th>
                        <th scope="col">Subject</th>
                        <th scope="col">Class</th>
                        <th scope="col">Date</th>
                        <th scope="col">Time Slot</th>
                        <th scope="col">Edit</th>
                        <th scope="col">Remove</th>
                    </tr>

                </thead>
                <tbody>
                    <%
                        for (int i = 0; i < list_search.size(); i++) {
                    %>
                    <tr>
                        <td>${status.count} <%=i+1%></td>
                        <td><%=list_search.get(i).getTeacherID().getTeacherName() %></td>
                        <td><%=list_search.get(i).getSubjectID().getSubjectCode() %></td>
                        <td><%=list_search.get(i).getClassID().getClassName() %></td>
                        <td><%=list_search.get(i).getScheduleDate() %></td>
                        <td><%=list_search.get(i).getTimeSlotID().getTimeSlotStart() %> - <%=list_search.get(i).getTimeSlotID().getTimeSlotEnd()%></td>
                        <td><a href="schedule/edit?scheduleID=<%=list_search.get(i).getScheduleID() %>">Edit</a></td>
                        <td><a href="schedule/remove?scheduleID=<%=list_search.get(i).getScheduleID() %>">Remove</a></td>
                    </tr>
                    <%
                        }
                    %>
                    <c:forEach items="${list}" var="i" varStatus="status">
                        <tr>
                            <td>${status.count}</td>
                            <td>${i.getTeacherID().getTeacherName()}</td>
                            <td>${i.getSubjectID().getSubjectCode()}</td>
                            <td>${i.getClassID().getClassName()}</td>
                            <td>${i.getScheduleDate()}</td>
                            <td>${i.getTimeSlotID().getTimeSlotStart()} - ${i.getTimeSlotID().getTimeSlotEnd()}</td>
                            <td><a href="schedule/edit?scheduleID=${i.getScheduleID()}">Edit</a></td>
                            <td><a href="schedule/remove?scheduleID=${i.getScheduleID()}">Remove</a></td>
                        </tr>
                    </c:forEach>

                </tbody>
            </table>
            <%
                }
            %>

        </div>
    </body>
</html>
