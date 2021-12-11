<%-- 
    Document   : attendence_edit
    Created on : Dec 11, 2021, 11:39:08 AM
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
        <title>attendence_edit</title>
        <%
            ArrayList<Attendence> list_edit = (ArrayList<Attendence>) request.getAttribute("list_edit");
        %>
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
                        <a class="nav-link" href="" style="color: white;"><span class="fas fa-user"></span>${sessionScope.account.getDisplayName()}</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="../login" style="color: white;"><span class="fas fa-sign-in-alt"></span>| Logout</a>
                    </li>
                </ul>
            </div>
        </nav>

        <div class="container" style="margin-top: 20px">
            <h4 style="color: #EF7F1B;text-align: center;padding-bottom: 10px;">EDIT ATTENDENCE</h4>
            <form action="edit" method="POST">
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
                            <%
                                for (int i = 0; i < list_edit.size(); i++) {
                            %>
                            <tr>
                        <input type="hidden" name="studentID" value="<%=list_edit.get(i).getStudentID().getStudentID()%>" />
                        <th scope="row"><%=i + 1%></th>
                        <td><img src="../img/<%=list_edit.get(i).getStudentID().getStudentImage()%>" style="width: 100px;height: 100px;"></td>
                        <td><%=list_edit.get(i).getStudentID().getStudentEmail()%></td>
                        <td><%=list_edit.get(i).getStudentID().getStudentID()%></td>
                        <td><%=list_edit.get(i).getStudentID().getStudentName()%></td>
                        <td><input type="radio" name="attendence<%=list_edit.get(i).getStudentID().getStudentID()%>" value="true" <%=list_edit.get(i).isPresent() ?"checked":""%>/><span style="color: green;">Present</span> 
                            <input type="radio" name="attendence<%=list_edit.get(i).getStudentID().getStudentID()%>" value="false" <%=list_edit.get(i).isPresent() == false ?"checked":""%>/><span style="color: red;">Absent</span> </td>
                        </tr>
                        <%
                            }
                        %>

                        </tbody>
                    </table>
                </div>
                <div class="col text-center">
                    <button type="submit" class="btn" style="background-color: #EF7F1B;
                            color: white;">Submit</button>
                </div>
            </form>

        </div>
    </body>
</html>
