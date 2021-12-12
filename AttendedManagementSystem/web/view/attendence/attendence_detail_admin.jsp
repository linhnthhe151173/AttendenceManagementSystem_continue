<%-- 
    Document   : attendence_detail_admin
    Created on : Dec 12, 2021, 3:14:25 PM
    Author     : Linh
--%>

<%@page import="model.Attendence"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <title>attendence_detail_admin</title>
        <%
            ArrayList<Attendence> list_attendence = (ArrayList<Attendence>) request.getAttribute("list_attendence");
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
                        <a class="nav-link" href="../logout" style="color: white;"><span class="fas fa-sign-in-alt"></span>| Logout</a>
                    </li>
                </ul>
            </div>
        </nav>

        <div class="container">
            <h4 style="text-align: center;
                margin-top: 20px;
                font-weight: bold;
                color: #EF7F1B;">REPORT ATTENDENCE</h4>
            <hr>
            <div style="margin-top: 20px;">
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th scope="col">STT</th>
                            <th scope="col">Student Code</th>
                            <th scope="col">Teacher Name</th>
                            <th scope="col">Subject Code</th>
                            <th scope="col">Class Name</th>
                            <th scope="col">Time Slot</th>
                            <th scope="col">Attendence Date</th>
                            <th scope="col">Attendence</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            for (int i = 0; i < list_attendence.size(); i++) {
                        %>
                        <tr>
                            <td><%=i+1%></td>
                            <td><%=list_attendence.get(i).getStudentID().getStudentID() %></td>
                            <td><%=list_attendence.get(i).getScheduleID().getTeacherID().getTeacherName() %></td>
                            <td><%=list_attendence.get(i).getScheduleID().getSubjectID().getSubjectCode()%></td> 
                            <td><%=list_attendence.get(i).getScheduleID().getClassID().getClassName() %></td>
                            <td><%=list_attendence.get(i).getScheduleID().getTimeSlotID().getTimeSlotStart() %> - <%=list_attendence.get(i).getScheduleID().getTimeSlotID().getTimeSlotEnd()%></td> 
                            <td><%=list_attendence.get(i).getAttendenceDate() %></td>
                            <td><%=list_attendence.get(i).isPresent() ? "Present":"Absent"%></td> 
                        </tr>
                        <%
                            }
                        %>

                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
