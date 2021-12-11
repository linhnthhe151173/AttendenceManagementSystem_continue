<%-- 
    Document   : attendence_detail
    Created on : Dec 11, 2021, 12:21:46 PM
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
        <title>attendence_detail</title>
        <%
            ArrayList<Attendence> list_attendence = (ArrayList<Attendence>) request.getAttribute("list_attendence");
        %>
    </head>
    <body>
        <!-- header -->
        <nav class="navbar navbar-expand-md sticky-top" style="background-color: #EF7F1B;">
            <c:forEach items="${list_attendence}" var="a" varStatus="status">
                <c:if test="${status.last}">
                    <a class="navbar-brand" href="../teacher/today_schedule" style="color: white;">Attendence Management</a>

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
                        <a class="nav-link" href="../login" style="color: white;"><span class="fas fa-sign-in-alt"></span>| Logout</a>
                    </li>
                </ul>
            </div>
        </nav>

        <div class="container">
            <div style="padding-top: 20px;">
                <h5>Detail: </h5>
                <%
                    for (int i = 0; i < list_attendence.size(); i++) {

                %>
                <span>[<span style="font-weight: bold;">Class:</span> <%=list_attendence.get(i).getScheduleID().getClassID().getClassName()%>]
                    <%
                            break;
                        }
                    %>
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
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            for (int i = 0; i < list_attendence.size(); i++) {
                        %>
                        <tr>
                            <th scope="row"><%=i + 1%></th>
                            <td><img src="../img/<%=list_attendence.get(i).getStudentID().getStudentImage()%>" style="width: 100px;height: 100px;"></td>
                            <td><%=list_attendence.get(i).getStudentID().getStudentEmail()%></td>
                            <td><%=list_attendence.get(i).getStudentID().getStudentID()%></td>
                            <td><%=list_attendence.get(i).getStudentID().getStudentName()%></td>
                            <td>
                                <%
                                    if (list_attendence.get(i).isPresent() == true) {
                                %>
                                <span style="color: green;">Present</span>
                                <%
                                } else {
                                %>
                                <span style="color: red;">Absent</span>
                                <%
                                    }
                                %>
                            </td>
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
