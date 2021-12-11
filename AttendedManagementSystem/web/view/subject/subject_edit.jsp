<%-- 
    Document   : subject_edit
    Created on : Dec 10, 2021, 5:18:54 PM
    Author     : Linh
--%>

<%@page import="model.Semester"%>
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
        <title>subject_edit</title>
        <%
            ArrayList<Semester> list = (ArrayList<Semester>) request.getAttribute("list");
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
                    <input type="hidden" name="subjectID" value="${s.getSubjectID()}" />
                    <tr>
                        <td>Subject Code: </td>
                        <td><input type="text" name="subject_code" value="${s.getSubjectCode()}" /></td>
                    </tr>
                    <tr>
                        <td>Subject Name: </td>
                        <td><input type="text" name="subject_name" value="${s.getSubjectName()}" /></td>
                    </tr>
                    <tr>
                        <td>Total Slot: </td>
                        <td><input type="text" name="date" value="${s.getTotalSlot()}" /></td>
                    </tr>
                    <tr>
                        <td>Semester</td>
                        <td><select name="semester">
                                <%
                                    for (Semester s1 : list) {
                                %>
                                <option value="<%=s1.getSemesterID()%>"><%=s1.getSemesterName()%></option>
                                <%
                                    }
                                %>
                            </select></td>
                    </tr>
                </table>
                <button type="submmit" class="btn" style="background-color: #EF7F1B;
                        margin-top: 15px;">Save</button>
            </form>

        </div>
    </body>
</html>
